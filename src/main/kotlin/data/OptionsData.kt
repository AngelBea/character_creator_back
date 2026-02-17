package dnd.data

import dnd.data.Labels.Gender.*
import dnd.data.Labels.GenericId.*
import dnd.data.Labels.RuleBook.*
import dnd.dtos.SelectionCardData
import dnd.managers.Stage.*

object Cards {
    object Rule {
        val C_DND_5E_2024 = SelectionCardData(
            id = DND_5E_2024.id,
            name = DND_5E_2024 dot RULE_BOOK dot TITLE,
            description = DND_5E_2024 dot RULE_BOOK dot DESCRIPTION,
            collapsed = true,
            type = "rules",
            imagePath = DND_5E_2024 dot RULE_BOOK dot COVER_IMAGE,
            altImageDescription = DND_5E_2024 dot RULE_BOOK dot ALT_TEXT,
            iconPath = "/assets/DnD-Symbol.webp",
            iconPathAlt = "D&D"
        )
    }

    object Gender{
        val C_MALE = SelectionCardData(
            id = MALE.id,
            name = DND_5E_2024 dot GENDER_PICK dot MALE dot TITLE,
            description = DND_5E_2024 dot GENDER_PICK dot MALE dot DESCRIPTION,
            collapsed = true,
            type = "gender",
            imagePath = "/assets/Male.webp",
            altImageDescription = "Male Character",
            iconPath = "/assets/MaleSymbol.webp",
            iconPathAlt = "Male Symbol"
        )
        val C_WOMAN = SelectionCardData(
            id = WOMAN.id,
            name = DND_5E_2024 dot GENDER_PICK dot WOMAN dot TITLE,
            description = DND_5E_2024 dot GENDER_PICK dot WOMAN dot DESCRIPTION,
            collapsed = true,
            type = "gender",
            imagePath = "/assets/Woman.webp",
            altImageDescription = "Woman Character",
            iconPath = "/assets/WomanSymbol.webp",
            iconPathAlt = "Woman Symbol"
        )
        val C_OTHER = SelectionCardData(
            id = OTHER.id,
            name = DND_5E_2024 dot GENDER_PICK dot OTHER dot TITLE,
            description = DND_5E_2024 dot GENDER_PICK dot OTHER dot DESCRIPTION,
            collapsed = true,
            type = "gender",
            imagePath = "/assets/Other.webp",
            altImageDescription = "Other Character",
            iconPath = "/assets/OtherSymbol.webp",
            iconPathAlt = "Other Symbol"
        )
    }
    object Class {
    }
    object Question{

    }
}

val GENDER_CARDS = listOf(
    Cards.Gender.C_MALE,
    Cards.Gender.C_WOMAN,
    //Cards.Gender.C_OTHER
)

val RULE_CARDS = listOf(
    Cards.Rule.C_DND_5E_2024
)