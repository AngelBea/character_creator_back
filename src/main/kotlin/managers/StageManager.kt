package dnd.managers

import dnd.data.GENDER_CARDS
import dnd.data.Label
import dnd.data.Labels
import dnd.data.Labels.Answer
import dnd.data.Labels.Answer.*
import dnd.data.Labels.FilterQuestion
import dnd.data.Labels.GenericId.*
import dnd.data.Labels.RuleBook.*
import dnd.data.RULE_CARDS
import dnd.data.Tests
import dnd.data.dot
import dnd.data.toLabel
import dnd.dtos.SelectionCardData
import dnd.dtos.Test
import dnd.dtos.UserPickData
import dnd.dtos.setNextQuestion
import dnd.factories.getClassTest
import dnd.factories.getPickClassTest
import dnd.managers.Stage.*
import kotlinx.serialization.Serializable
object Managers{
    private val stageManagers = mutableMapOf<String, StageManager>()
    fun getManager(sessionId: String): StageManager{
        stageManagers.forEach { "${it.key} = ${it.value.toDto()}".let(::println) }
        return stageManagers.getOrPut(sessionId){ StageManager.initStageManager() }
    }
}

@Serializable
data class StageManagerDTO(val stage: String, val nextStage: String, val previousStage: String,
                           val currentStageOptions: List<SelectionCardData>, val stageTitle: String, val test: Test?)
class StageManager(var stage: Stage, var nextStage: Stage, var previousStage: Stage,
                   var currentStageOptions: List<SelectionCardData>, var stageTitle: String, var currentTest: Test? = null){

    companion object {
        fun initStageManager() = StageManager(
            RULE_PICK, GENDER_PICK,
            NONE, RULE_CARDS, DND_5E_2024 dot RULE_PICK dot TITLE
        )
    }

    fun nextStage(userPickData: UserPickData): StageManager {
        val currentTestNoMutable = this.currentTest
        if (currentTestNoMutable != null){
            val currentQuestionNumber = currentTestNoMutable?.currentQuestion?.number ?: -1
            val numberOfQuestions = currentTestNoMutable?.numberOfQuestions ?: -1
            if (currentQuestionNumber < numberOfQuestions){
                this.stageTitle = currentTestNoMutable.setNextQuestion()?.question ?: "TEST FINISHED"
            }
        }else{
            this.stage = this.stage.next(userPickData, this)
            refresh(userPickData)
        }

        if (this.stageTitle === "TEST FINISHED"){
            this.stage = this.stage.next(userPickData, this)
            refresh(userPickData)
        }

        return this
    }

    fun previousStage(userPickData: UserPickData): StageManager{
        this.stage = this.stage.previous(userPickData)
        refresh(userPickData)

        return this
    }

    fun refresh(userPickData: UserPickData){
        this.previousStage = this.stage.previous(userPickData)
        this.currentStageOptions = this.stage.options()
        this.stageTitle = this.stage.title()
        this.nextStage = this.stage.next(userPickData, this)
        this.currentTest = this.stage.getTest(userPickData)
        if (this.currentTest != null) this.stageTitle = this.currentTest!!.currentQuestion.question
    }

    fun toDto(): StageManagerDTO{
        return StageManagerDTO(
            this.stage.id, this.nextStage.id, this.previousStage.id,
            this.currentStageOptions, this.stageTitle, this.currentTest)
    }
}


enum class Stage(): Label {
    RULE_PICK,
    GENDER_PICK,
    CLASS_PICK,
    BACKGROUND_PICK,
    PICK_CLASS_TEST,
    CLASS_TEST,
    NONE;

    fun previous(userPickData: UserPickData): Stage{
        return when(this){
            RULE_PICK -> NONE
            GENDER_PICK -> RULE_PICK
            CLASS_PICK -> PICK_CLASS_TEST
            BACKGROUND_PICK -> CLASS_PICK
            PICK_CLASS_TEST -> GENDER_PICK
            CLASS_TEST -> PICK_CLASS_TEST
            NONE -> NONE
        }
    }

    fun next(userPickData: UserPickData, stageManager: StageManager): Stage{
        return when(this){
            RULE_PICK -> GENDER_PICK
            GENDER_PICK -> PICK_CLASS_TEST
            CLASS_PICK -> BACKGROUND_PICK
            BACKGROUND_PICK -> NONE
            PICK_CLASS_TEST -> if (userPickData.testAnswers[FilterQuestion.DO_CLASS_TEST.id]?.first() == YES.id) CLASS_TEST else CLASS_PICK
            CLASS_TEST -> CLASS_PICK
            NONE -> NONE
        }
    }

    fun title(): String{
        return when(this){
            RULE_PICK -> DND_5E_2024 dot RULE_PICK dot TITLE
            GENDER_PICK -> DND_5E_2024 dot GENDER_PICK dot TITLE
            CLASS_PICK -> DND_5E_2024 dot CLASS_PICK dot TITLE
            BACKGROUND_PICK -> DND_5E_2024 dot BACKGROUND_PICK dot TITLE
            PICK_CLASS_TEST -> DND_5E_2024 dot PICK_CLASS_TEST dot TITLE
            CLASS_TEST -> DND_5E_2024 dot CLASS_TEST dot TITLE
            NONE -> ""
        }
    }

    fun options(): List<SelectionCardData>{
        return when(this){
            RULE_PICK -> RULE_CARDS
            GENDER_PICK -> GENDER_CARDS
            CLASS_PICK -> emptyList()
            BACKGROUND_PICK -> emptyList()
            else -> emptyList()
        }
    }

    fun getTest(userPickData: UserPickData): Test?{
        return when(this){
            PICK_CLASS_TEST -> getPickClassTest(userPickData)
            CLASS_TEST -> getClassTest(userPickData)
            else -> null
        }

    }

    override val id = name.lowercase()
}
