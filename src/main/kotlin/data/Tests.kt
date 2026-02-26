package dnd.data

import dnd.data.Labels.Answer.*
import dnd.data.Labels.FilterQuestion
import dnd.data.Labels.FilterQuestion.*
import dnd.data.Labels.GenericId.*
import dnd.data.Labels.RuleBook.*
import dnd.dtos.Answer
import dnd.dtos.Question
import dnd.dtos.Test
import dnd.dtos.UserPickData
import dnd.managers.Stage
import dnd.managers.Stage.*

object Tests {
    class PickClassTest(userPickData: UserPickData){
        val answers = listOf(
            Answer(
                DND_5E_2024 dot PICK_CLASS_TEST dot DO_CLASS_TEST dot YES,
                "yes"
            ),
            Answer(DND_5E_2024 dot PICK_CLASS_TEST dot DO_CLASS_TEST dot NO,
                "no")
        )
        val questions = listOf(Question(
            DND_5E_2024 dot PICK_CLASS_TEST dot TITLE dot userPickData.gender!!.toLabel(),
            answers,
            DO_CLASS_TEST.id,
            0
        ))

        val test = Test(
                questions,
                id = DND_5E_2024 dot PICK_CLASS_TEST
        )
    }
}