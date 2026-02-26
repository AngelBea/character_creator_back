package dnd.builders

import dnd.dtos.Answer
import dnd.dtos.Question
import dnd.dtos.ScoringTag
import dnd.dtos.Test

@DslMarker
annotation class TestBuilderDsl

@TestBuilderDsl
class TestBuilder(val block: TestBuilder.() -> Unit){
    var id: String = ""
    private val questions: MutableList<Question> = mutableListOf()

    fun question(block: QuestionBuilder.() -> Unit){
        questions.add(QuestionBuilder().apply(block).build())
    }

    fun build(): Test{
        this.apply(block)
        return Test(questions, id = id)
    }
}

@TestBuilderDsl
class QuestionBuilder{
    var id: String = ""
    var question: String = ""
    var answers: MutableList<Answer> = mutableListOf()
    var number: Int = 0
    fun answer(block: AnswerBuilder.() -> Unit){
        answers.add(AnswerBuilder().apply(block).build())
    }

    fun build() = Question(question, answers, id, number)
}

@TestBuilderDsl
class AnswerBuilder{
    var id: String = ""
    var answer: String = ""
    var scoringTags: MutableList<ScoringTag> = mutableListOf()

    fun scoringTag(block: ScoringTagBuilder.() -> Unit){
        scoringTags.add(ScoringTagBuilder().apply(block).build())
    }

    fun build() = Answer(answer, id, scoringTags)
}

@TestBuilderDsl
class ScoringTagBuilder{
    var tag: String = ""
    var score: Int = 0

    fun build() = ScoringTag(tag, score)
}