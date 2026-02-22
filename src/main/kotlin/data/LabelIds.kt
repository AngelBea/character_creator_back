package dnd.data

interface Label{
    val id: String
}
object Labels{
    enum class RuleBook: Label{
        DND_5E_2024,
        TASHAS_CAULDRON_OF_EVERYTHING,
        EBERRON_RISING_FROM_THE_LAST_WAR;

        override val id = name.lowercase()
    }

    enum class GenericId : Label {
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

    enum class Gender(override val id: String) : Label {
        MALE("male"),
        WOMAN("female"),
        OTHER("other")
    }

    enum class DndClass(val ruleBook: RuleBook, val mainRole: ClassTag, val mainAttribute: ClassTag, secondaryAttributes: List<ClassTag>, armorMastery: List<ClassTag>, weaponMastery: List<ClassTag>, skills: List<ClassTag>) : Label {
        BARBARIAN(
            ruleBook = RuleBook.DND_5E_2024,
            mainRole = ClassTag.MARTIAL,
            mainAttribute = ClassTag.STRENGTH,
            secondaryAttributes = listOf(ClassTag.CONSTITUTION),
            armorMastery = listOf(ClassTag.LIGHT_ARMOR, ClassTag.MEDIUM_ARMOR, ClassTag.SHIELD),
            weaponMastery = listOf(ClassTag.SIMPLE_WEAPONS, ClassTag.MARTIAL_WEAPONS),
            skills = listOf(
                ClassTag.ANIMAL_HANDLING,
                ClassTag.ATHLETICS,
                ClassTag.INTIMIDATION,
                ClassTag.NATURE,
                ClassTag.PERCEPTION,
                ClassTag.SURVIVAL
            )
        ),

        BARD(
            ruleBook = RuleBook.DND_5E_2024,
            mainRole = ClassTag.CASTER,
            mainAttribute = ClassTag.CHARISMA,
            secondaryAttributes = listOf(ClassTag.DEXTERITY),
            armorMastery = listOf(ClassTag.LIGHT_ARMOR),
            weaponMastery = listOf(ClassTag.SIMPLE_WEAPONS),
            skills = listOf(
                ClassTag.ACROBATICS,
                ClassTag.ANIMAL_HANDLING,
                ClassTag.ARCANA,
                ClassTag.ATHLETICS,
                ClassTag.DECEPTION,
                ClassTag.HISTORY,
                ClassTag.INSIGHT,
                ClassTag.INTIMIDATION,
                ClassTag.INVESTIGATION,
                ClassTag.MEDICINE,
                ClassTag.NATURE,
                ClassTag.PERCEPTION,
                ClassTag.PERFORMANCE,
                ClassTag.PERSUASION,
                ClassTag.RELIGION,
                ClassTag.SLEIGHT_OF_HAND,
                ClassTag.STEALTH,
                ClassTag.SURVIVAL
            )
        ),

        CLERIC(
            ruleBook = RuleBook.DND_5E_2024,
            mainRole = ClassTag.HYBRID,
            mainAttribute = ClassTag.WISDOM,
            secondaryAttributes = listOf(ClassTag.CHARISMA),
            armorMastery = listOf(ClassTag.LIGHT_ARMOR, ClassTag.MEDIUM_ARMOR, ClassTag.SHIELD),
            weaponMastery = listOf(ClassTag.SIMPLE_WEAPONS),
            skills = listOf(
                ClassTag.HISTORY,
                ClassTag.INSIGHT,
                ClassTag.MEDICINE,
                ClassTag.PERSUASION,
                ClassTag.RELIGION
            )
        ),

        DRUID(
            ruleBook = RuleBook.DND_5E_2024,
            mainRole = ClassTag.HYBRID,
            mainAttribute = ClassTag.WISDOM,
            secondaryAttributes = listOf(ClassTag.CONSTITUTION),
            armorMastery = listOf(ClassTag.LIGHT_ARMOR, ClassTag.MEDIUM_ARMOR, ClassTag.SHIELD),
            weaponMastery = listOf(ClassTag.SIMPLE_WEAPONS),
            skills = listOf(
                ClassTag.ARCANA,
                ClassTag.ANIMAL_HANDLING,
                ClassTag.INSIGHT,
                ClassTag.MEDICINE,
                ClassTag.NATURE,
                ClassTag.PERCEPTION,
                ClassTag.RELIGION,
                ClassTag.SURVIVAL
            )
        ),

        FIGHTER(
            ruleBook = RuleBook.DND_5E_2024,
            mainRole = ClassTag.MARTIAL,
            mainAttribute = ClassTag.STRENGTH,
            secondaryAttributes = listOf(ClassTag.DEXTERITY, ClassTag.CONSTITUTION),
            armorMastery = listOf(ClassTag.LIGHT_ARMOR, ClassTag.MEDIUM_ARMOR, ClassTag.HEAVY_ARMOR, ClassTag.SHIELD),
            weaponMastery = listOf(ClassTag.SIMPLE_WEAPONS, ClassTag.MARTIAL_WEAPONS),
            skills = listOf(
                ClassTag.ACROBATICS,
                ClassTag.ANIMAL_HANDLING,
                ClassTag.ATHLETICS,
                ClassTag.HISTORY,
                ClassTag.INSIGHT,
                ClassTag.INTIMIDATION,
                ClassTag.PERCEPTION,
                ClassTag.SURVIVAL
            )
        ),

        MONK(
            ruleBook = RuleBook.DND_5E_2024,
            mainRole = ClassTag.MARTIAL,
            mainAttribute = ClassTag.DEXTERITY,
            secondaryAttributes = listOf(ClassTag.WISDOM),
            armorMastery = emptyList(),
            weaponMastery = listOf(ClassTag.SIMPLE_WEAPONS),
            skills = listOf(
                ClassTag.ACROBATICS,
                ClassTag.ATHLETICS,
                ClassTag.HISTORY,
                ClassTag.INSIGHT,
                ClassTag.RELIGION,
                ClassTag.STEALTH
            )
        ),

        PALADIN(
            ruleBook = RuleBook.DND_5E_2024,
            mainRole = ClassTag.HYBRID,
            mainAttribute = ClassTag.CHARISMA,
            secondaryAttributes = listOf(ClassTag.STRENGTH, ClassTag.CONSTITUTION),
            armorMastery = listOf(ClassTag.LIGHT_ARMOR, ClassTag.MEDIUM_ARMOR, ClassTag.HEAVY_ARMOR, ClassTag.SHIELD),
            weaponMastery = listOf(ClassTag.SIMPLE_WEAPONS, ClassTag.MARTIAL_WEAPONS),
            skills = listOf(
                ClassTag.ATHLETICS,
                ClassTag.INSIGHT,
                ClassTag.INTIMIDATION,
                ClassTag.MEDICINE,
                ClassTag.PERSUASION,
                ClassTag.RELIGION
            )
        ),

        RANGER(
            ruleBook = RuleBook.DND_5E_2024,
            mainRole = ClassTag.HYBRID,
            mainAttribute = ClassTag.DEXTERITY,
            secondaryAttributes = listOf(ClassTag.WISDOM, ClassTag.CONSTITUTION),
            armorMastery = listOf(ClassTag.LIGHT_ARMOR, ClassTag.MEDIUM_ARMOR, ClassTag.SHIELD),
            weaponMastery = listOf(ClassTag.SIMPLE_WEAPONS, ClassTag.MARTIAL_WEAPONS),
            skills = listOf(
                ClassTag.ANIMAL_HANDLING,
                ClassTag.ATHLETICS,
                ClassTag.INSIGHT,
                ClassTag.INVESTIGATION,
                ClassTag.NATURE,
                ClassTag.PERCEPTION,
                ClassTag.STEALTH,
                ClassTag.SURVIVAL
            )
        ),

        ROGUE(
            ruleBook = RuleBook.DND_5E_2024,
            mainRole = ClassTag.MARTIAL,
            mainAttribute = ClassTag.DEXTERITY,
            secondaryAttributes = listOf(ClassTag.INTELLIGENCE),
            armorMastery = listOf(ClassTag.LIGHT_ARMOR),
            weaponMastery = listOf(ClassTag.SIMPLE_WEAPONS, ClassTag.MARTIAL_WEAPONS),
            skills = listOf(
                ClassTag.ACROBATICS,
                ClassTag.ATHLETICS,
                ClassTag.DECEPTION,
                ClassTag.INSIGHT,
                ClassTag.INTIMIDATION,
                ClassTag.INVESTIGATION,
                ClassTag.PERCEPTION,
                ClassTag.PERFORMANCE,
                ClassTag.PERSUASION,
                ClassTag.SLEIGHT_OF_HAND,
                ClassTag.STEALTH
            )
        ),

        SORCERER(
            ruleBook = RuleBook.DND_5E_2024,
            mainRole = ClassTag.CASTER,
            mainAttribute = ClassTag.CHARISMA,
            secondaryAttributes = listOf(ClassTag.CONSTITUTION),
            armorMastery = emptyList(),
            weaponMastery = listOf(ClassTag.SIMPLE_WEAPONS),
            skills = listOf(
                ClassTag.ARCANA,
                ClassTag.DECEPTION,
                ClassTag.INSIGHT,
                ClassTag.INTIMIDATION,
                ClassTag.PERSUASION,
                ClassTag.RELIGION
            )
        ),

        WARLOCK(
            ruleBook = RuleBook.DND_5E_2024,
            mainRole = ClassTag.CASTER,
            mainAttribute = ClassTag.CHARISMA,
            secondaryAttributes = listOf(ClassTag.WISDOM),
            armorMastery = listOf(ClassTag.LIGHT_ARMOR),
            weaponMastery = listOf(ClassTag.SIMPLE_WEAPONS),
            skills = listOf(
                ClassTag.ARCANA,
                ClassTag.DECEPTION,
                ClassTag.HISTORY,
                ClassTag.INTIMIDATION,
                ClassTag.INVESTIGATION,
                ClassTag.NATURE,
                ClassTag.RELIGION
            )
        ),

        WIZARD(
            ruleBook = RuleBook.DND_5E_2024,
            mainRole = ClassTag.CASTER,
            mainAttribute = ClassTag.INTELLIGENCE,
            secondaryAttributes = listOf(ClassTag.WISDOM),
            armorMastery = emptyList(),
            weaponMastery = listOf(ClassTag.SIMPLE_WEAPONS),
            skills = listOf(
                ClassTag.ARCANA,
                ClassTag.HISTORY,
                ClassTag.INSIGHT,
                ClassTag.INVESTIGATION,
                ClassTag.MEDICINE,
                ClassTag.RELIGION
            )
        ),

        ARTIFICER(
            ruleBook = RuleBook.EBERRON_RISING_FROM_THE_LAST_WAR,
            mainRole = ClassTag.CASTER,
            mainAttribute = ClassTag.INTELLIGENCE,
            secondaryAttributes = listOf(ClassTag.CONSTITUTION),
            armorMastery = listOf(ClassTag.LIGHT_ARMOR, ClassTag.MEDIUM_ARMOR, ClassTag.SHIELD),
            weaponMastery = listOf(ClassTag.SIMPLE_WEAPONS),
            skills = listOf(
                ClassTag.ARCANA,
                ClassTag.HISTORY,
                ClassTag.INVESTIGATION,
                ClassTag.MEDICINE,
                ClassTag.NATURE,
                ClassTag.PERCEPTION,
                ClassTag.SLEIGHT_OF_HAND
            )
        );

        override val id = name.lowercase()
    }

    enum class ClassTag(category: TagCategory) : Label {
        // Mechanic Roles
        CASTER(TagCategory.MECHANIC_ROLE),
        HYBRID(TagCategory.MECHANIC_ROLE),
        MARTIAL(TagCategory.MECHANIC_ROLE),

        // Main Attributes Role
        STRENGTH(TagCategory.MAIN_ATTRIBUTE),
        DEXTERITY(TagCategory.MAIN_ATTRIBUTE),
        CONSTITUTION(TagCategory.MAIN_ATTRIBUTE),
        INTELLIGENCE(TagCategory.MAIN_ATTRIBUTE),
        WISDOM(TagCategory.MAIN_ATTRIBUTE),
        CHARISMA(TagCategory.MAIN_ATTRIBUTE),

        // Armor
        LIGHT_ARMOR(TagCategory.ARMOR),
        MEDIUM_ARMOR(TagCategory.ARMOR),
        HEAVY_ARMOR(TagCategory.ARMOR),
        SHIELD(TagCategory.ARMOR),

        //Weapons
        SIMPLE_WEAPONS(TagCategory.WEAPON_MASTERY),
        MARTIAL_WEAPONS(TagCategory.WEAPON_MASTERY),

        //Skills
        ACROBATICS(TagCategory.SKILL),
        ANIMAL_HANDLING(TagCategory.SKILL),
        ARCANA(TagCategory.SKILL),
        ATHLETICS(TagCategory.SKILL),
        DECEPTION(TagCategory.SKILL),
        HISTORY(TagCategory.SKILL),
        INSIGHT(TagCategory.SKILL),
        INTIMIDATION(TagCategory.SKILL),
        INVESTIGATION(TagCategory.SKILL),
        MEDICINE(TagCategory.SKILL),
        NATURE(TagCategory.SKILL),
        PERCEPTION(TagCategory.SKILL),
        PERFORMANCE(TagCategory.SKILL),
        PERSUASION(TagCategory.SKILL),
        RELIGION(TagCategory.SKILL),
        SLEIGHT_OF_HAND(TagCategory.SKILL),
        STEALTH(TagCategory.SKILL),
        SURVIVAL(TagCategory.SKILL);

        override val id = name.lowercase()
    }

    enum class TagCategory : Label {
        MECHANIC_ROLE,
        MAIN_ATTRIBUTE,
        ARMOR,
        WEAPON_MASTERY,
        SKILL;

        override val id = name.lowercase()
    }

    enum class FilterQuestion : Label {
        DO_CLASS_TEST;

        override val id = name.lowercase()
    }

    enum class Answer : Label {
        YES,
        NO;

        override val id = name.lowercase()
    }

    fun getAllLabels(): List<Label> {
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