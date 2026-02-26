package dnd.dtos

import dnd.data.Label
import kotlinx.serialization.Serializable
import kotlinx.serialization.Transient

@Serializable
data class Test(@Transient val questions: List<Question> = emptyList(),
                @Transient val numberOfQuestions: Int = questions.size,
                var currentQuestion: Question = questions.first(),
                override val id: String): Label
@Serializable
data class Question(val question: String, val answers: List<Answer>, override val id: String,
                    @Transient var number: Int = 0): Label
@Serializable
data class Answer(val answer: String, override val id: String,
                  @Transient val scoringTags: List<ScoringTag> = emptyList()): Label

data class ScoringTag(val tag: String, val score: Int)

fun Test.setNextQuestion(): Question?{
    val question = questions.getOrNull(currentQuestion.number + 1);
    if (question != null) currentQuestion = question
    return question
}