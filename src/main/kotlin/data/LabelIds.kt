package dnd.data

interface Label{
    val id: String
}
object Labels{
    enum class RuleBook: Label{
        DND_5E_2024;
        override val id = name.lowercase()
    }
    enum class GenericId: Label {
        COVER_IMAGE,
        TITLE,
        RULE_BOOK,
        DESCRIPTION,
        ALT_TEXT,
        FILTER_QUESTION,
        TAG,
        PRIMARY,
        SECONDARY,
        TERTIARY;

        override val id = name.lowercase()
    }

    enum class Gender(override val id: String): Label {
        MALE("male"),
        WOMAN("female"),
        OTHER("other")
    }

    enum class DndClass(val tags: List<ClassTag>) : Label {
        BARBARIAN(
            listOf(
                ClassTag.FRONTLINE,
                ClassTag.DAMAGE_SUSTAINED,
                ClassTag.INSTINCTIVE,
                ClassTag.SIMPLE,
            )
        ),

        BARD(
            listOf(
                ClassTag.INNATE,
                ClassTag.SUPPORT,
                ClassTag.SOCIAL,
                ClassTag.ADAPTIVE,
                ClassTag.MODERATE,
            )
        ),

        CLERIC(
            listOf(
                ClassTag.DIVINE,
                ClassTag.SUPPORT,
                ClassTag.CONTROL,
                ClassTag.STRATEGIC,
                ClassTag.MODERATE,
            )
        ),

        DRUID(
            listOf(
                ClassTag.NATURE,
                ClassTag.CONTROL,
                ClassTag.SUPPORT,
                ClassTag.STRATEGIC,
                ClassTag.COMPLEX,
            )
        ),

        FIGHTER(
            listOf(
                ClassTag.FRONTLINE,
                ClassTag.DAMAGE_SUSTAINED,
                ClassTag.TACTICAL,
                ClassTag.SIMPLE,
            )
        ),

        MONK(
            listOf(
                ClassTag.MOBILITY,
                ClassTag.DAMAGE_SUSTAINED,
                ClassTag.TACTICAL,
                ClassTag.MODERATE,
            )
        ),

        PALADIN(
            listOf(
                ClassTag.DIVINE,
                ClassTag.FRONTLINE,
                ClassTag.DAMAGE_BURST,
                ClassTag.SUPPORT,
                ClassTag.TACTICAL,
                ClassTag.MODERATE,
            )
        ),

        RANGER(
            listOf(
                ClassTag.NATURE,
                ClassTag.DAMAGE_SUSTAINED,
                ClassTag.MOBILITY,
                ClassTag.TACTICAL,
                ClassTag.MODERATE,
            )
        ),

        ROGUE(
            listOf(
                ClassTag.DAMAGE_BURST,
                ClassTag.MOBILITY,
                ClassTag.TACTICAL,
                ClassTag.MODERATE,
            )
        ),

        SORCERER(
            listOf(
                ClassTag.INNATE,
                ClassTag.DAMAGE_BURST,
                ClassTag.CONTROL,
                ClassTag.ADAPTIVE,
                ClassTag.MODERATE,
            )
        ),

        WARLOCK(
            listOf(
                ClassTag.PACT,
                ClassTag.DAMAGE_SUSTAINED,
                ClassTag.CONTROL,
                ClassTag.ADAPTIVE,
                ClassTag.MODERATE,
            )
        ),

        WIZARD(
            listOf(
                ClassTag.ARCANE,
                ClassTag.CONTROL,
                ClassTag.UTILITY,
                ClassTag.STRATEGIC,
                ClassTag.COMPLEX,
            )
        ),

        ARTIFICER(
            listOf(
                ClassTag.CRAFT,
                ClassTag.UTILITY,
                ClassTag.SUPPORT,
                ClassTag.STRATEGIC,
                ClassTag.COMPLEX,
            )
        );

        override val id = name.lowercase()
    }

    enum class ClassTag : Label {
        DIVINE,
        ARCANE,
        INNATE,
        PACT,
        NATURE,
        CRAFT,

        FRONTLINE,
        DAMAGE_BURST,
        DAMAGE_SUSTAINED,
        CONTROL,
        SUPPORT,
        UTILITY,
        MOBILITY,
        SOCIAL,

        STRATEGIC,
        TACTICAL,
        INSTINCTIVE,
        ADAPTIVE,

        SIMPLE,
        MODERATE,
        COMPLEX;

        override val id = name.lowercase()
    }

    enum class FilterQuestion: Label{
        DO_CLASS_TEST;
        override val id = name.lowercase()
    }
    enum class Answer: Label{
        YES,
        NO;

        override val id = name.lowercase()
    }

    fun getAllLabels(): List<Label>{
        return mutableListOf<Label>().apply {
            addAll(RuleBook.entries.toTypedArray())
            addAll(GenericId.entries.toTypedArray())
            addAll(Gender.entries.toTypedArray())
            addAll(DndClass.entries.toTypedArray())
            addAll(ClassTag.entries.toTypedArray())
            addAll(FilterQuestion.entries.toTypedArray())
            addAll(Answer.entries.toTypedArray())
        }.toList()
    }
}

infix fun Label.dot(other: Label) = "${this.id}.${other.id}"
infix fun String.dot(other: Label) = "$this.${other.id}"
fun String.toLabel() = Labels.getAllLabels().find { it.id == this }!!