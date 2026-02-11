package dnd.data

interface Label{
    val id: String
}
object Labels{
    enum class RuleBook(override val id: String): Label{
        DND_5E_2024("dnd5e_2024")
    }
    enum class GenericId(override val id: String): Label {
        COVER_IMAGE("cover_image"),
        TITLE("title"),
        RULE_BOOK("rule_book"),
        DESCRIPTION("description"),
        ALT_TEXT("alt_text")
    }

    enum class Gender(override val id: String): Label {
        MALE("male"),
        WOMAN("female"),
        OTHER("other")
    }

    fun getAllLabels(): List<Label>{
        return mutableListOf<Label>().apply {
            addAll(RuleBook.entries.toTypedArray())
            addAll(GenericId.entries.toTypedArray())
            addAll(Gender.entries.toTypedArray())
        }.toList()
    }
}

infix fun Label.dot(other: Label) = "${this.id}.${other.id}"
infix fun String.dot(other: Label) = "$this.${other.id}"
fun String.toLabel() = Labels.getAllLabels().find { it.id == this }!!