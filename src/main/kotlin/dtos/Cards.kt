package dnd.dtos

import kotlinx.serialization.Serializable

@Serializable
data class SelectionCardData(
    val id: String,
    val name: String,
    val description: String,
    val collapsed: Boolean,
    val type: String,
    val imagePath: String,
    val altImageDescription: String,
    val iconPath: String,
    val iconPathAlt: String,
    val keyAttributes: List<String> = emptyList()
)

@Serializable
data class UserPickData(
    val rules: String? = null,
    val characterClass: String? = null,
    val background: String? = null,
    val gender: String? = null,
    val testAnswers: Map<String, List<String>>
)