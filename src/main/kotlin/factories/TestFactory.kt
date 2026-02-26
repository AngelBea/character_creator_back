package dnd.factories

import dnd.builders.TestBuilder
import dnd.data.Labels.Answer.NO
import dnd.data.Labels.Answer.YES
import dnd.data.Labels.FilterQuestion.DO_CLASS_TEST
import dnd.data.Labels.GenericId.TITLE
import dnd.data.Labels.RuleBook.DND_5E_2024
import dnd.data.dot
import dnd.data.toLabel
import dnd.dtos.UserPickData
import dnd.managers.Stage
import dnd.managers.Stage.PICK_CLASS_TEST
import dnd.data.Labels.ClassTag.*
import dnd.data.Labels.ClassTestQuestion.*
import dnd.data.Labels.ClassTestAnswer.*

fun getPickClassTest(userPickData: UserPickData) = TestBuilder {
    id = DND_5E_2024 dot PICK_CLASS_TEST

    question{
        id = DO_CLASS_TEST.id
        question = DND_5E_2024 dot PICK_CLASS_TEST dot TITLE dot userPickData.gender!!.toLabel()

        answer{
            answer = DND_5E_2024 dot PICK_CLASS_TEST dot DO_CLASS_TEST dot YES
            id = YES.id
        }
        answer {
            answer = DND_5E_2024 dot PICK_CLASS_TEST dot DO_CLASS_TEST dot NO
            id = NO.id
        }
    }
}.build()


fun getClassTest(userPickData: UserPickData) = TestBuilder {
    id = DND_5E_2024 dot Stage.CLASS_TEST

    // 🧛‍♂️ Pregunta 1: Lord Zaz, el rey vampiro
    question {
        id = LORD_ZAZ.id
        question = DND_5E_2024 dot Stage.CLASS_TEST dot LORD_ZAZ dot userPickData.gender!!.toLabel()

        answer {
            id = LORD_ZAZ dot ANS_1
            answer = DND_5E_2024 dot Stage.CLASS_TEST dot LORD_ZAZ dot ANS_1 dot userPickData.gender!!.toLabel()
            scoringTag { tag = STRENGTH.id; score = 1 }
            scoringTag { tag = MARTIAL.id; score = 1 }
            scoringTag { tag = HEAVY_ARMOR.id; score = 1 }
            scoringTag { tag = SHIELD.id; score = 1 }
            scoringTag { tag = ATHLETICS.id; score = 1 }
            scoringTag { tag = INTIMIDATION.id; score = 1 }
        }
        answer {
            id = LORD_ZAZ dot ANS_2
            answer = DND_5E_2024 dot Stage.CLASS_TEST dot LORD_ZAZ dot ANS_2 dot userPickData.gender!!.toLabel()
            scoringTag { tag = INTELLIGENCE.id; score = 1 }
            scoringTag { tag = HYBRID.id; score = 1 }
            scoringTag { tag = LIGHT_ARMOR.id; score = 1 }
            scoringTag { tag = ARCANA.id; score = 1 }
            scoringTag { tag = PERCEPTION.id; score = 1 }
            scoringTag { tag = INSIGHT.id; score = 1 }
            scoringTag { tag = STEALTH.id; score = 1 }
        }
        answer {
            id = LORD_ZAZ dot ANS_3
            answer = DND_5E_2024 dot Stage.CLASS_TEST dot LORD_ZAZ dot ANS_3 dot userPickData.gender!!.toLabel()
            scoringTag { tag = DEXTERITY.id; score = 1 }
            scoringTag { tag = MARTIAL.id; score = 1 }
            scoringTag { tag = LIGHT_ARMOR.id; score = 1 }
            scoringTag { tag = STEALTH.id; score = 1 }
            scoringTag { tag = DECEPTION.id; score = 1 }
            scoringTag { tag = ATHLETICS.id; score = 1 }
            scoringTag { tag = PERCEPTION.id; score = 1 }
        }
        answer {
            id = LORD_ZAZ dot ANS_4
            answer = DND_5E_2024 dot Stage.CLASS_TEST dot LORD_ZAZ dot ANS_4 dot userPickData.gender!!.toLabel()
            scoringTag { tag = CHARISMA.id; score = 1 }
            scoringTag { tag = HYBRID.id; score = 1 }
            scoringTag { tag = PERSUASION.id; score = 1 }
            scoringTag { tag = ANIMAL_HANDLING.id; score = 1 }
            scoringTag { tag = NATURE.id; score = 1 }
            scoringTag { tag = INSIGHT.id; score = 1 }
        }
        answer {
            id = LORD_ZAZ dot ANS_5
            answer = DND_5E_2024 dot Stage.CLASS_TEST dot LORD_ZAZ dot ANS_5 dot userPickData.gender!!.toLabel()
            scoringTag { tag = CONSTITUTION.id; score = 1 }
            scoringTag { tag = SURVIVAL.id; score = 1 }
            scoringTag { tag = ATHLETICS.id; score = 1 }
            scoringTag { tag = HEAVY_ARMOR.id; score = 1 }
        }
        answer {
            id = LORD_ZAZ dot ANS_6
            answer = DND_5E_2024 dot Stage.CLASS_TEST dot LORD_ZAZ dot ANS_6 dot userPickData.gender!!.toLabel()
            scoringTag { tag = DEXTERITY.id; score = 1 }
            scoringTag { tag = MARTIAL.id; score = 1 }
            scoringTag { tag = PERCEPTION.id; score = 1 }
            scoringTag { tag = ATHLETICS.id; score = 1 }
            scoringTag { tag = INTIMIDATION.id; score = 1 }
            scoringTag { tag = STEALTH.id; score = 1 }
            scoringTag { tag = LIGHT_ARMOR.id; score = 1 }
            scoringTag { tag = ACROBATICS.id; score = 1 }
        }
    }

    // 🕷️ Pregunta 2: La señora que concede deseos
    question {
        id = WISH_LADY.id
        question = DND_5E_2024 dot Stage.CLASS_TEST dot WISH_LADY dot userPickData.gender!!.toLabel()
        number = 1

        answer {
            id = WISH_LADY dot ANS_1
            answer = DND_5E_2024 dot Stage.CLASS_TEST dot WISH_LADY dot ANS_1 dot userPickData.gender!!.toLabel()
            scoringTag { tag = WISDOM.id; score = 1 }
            scoringTag { tag = CASTER.id; score = 1 }
            scoringTag { tag = NATURE.id; score = 1 }
            scoringTag { tag = ANIMAL_HANDLING.id; score = 1 }
            scoringTag { tag = ARCANA.id; score = 1 }
        }
        answer {
            id = WISH_LADY dot ANS_2
            answer = DND_5E_2024 dot Stage.CLASS_TEST dot WISH_LADY dot ANS_2 dot userPickData.gender!!.toLabel()
            scoringTag { tag = INTELLIGENCE.id; score = 1 }
            scoringTag { tag = CASTER.id; score = 1 }
            scoringTag { tag = ARCANA.id; score = 1 }
            scoringTag { tag = DECEPTION.id; score = 1 }
            scoringTag { tag = INSIGHT.id; score = 1 }
        }
        answer {
            id = WISH_LADY dot ANS_3
            answer = DND_5E_2024 dot Stage.CLASS_TEST dot WISH_LADY dot ANS_3 dot userPickData.gender!!.toLabel()
            scoringTag { tag = CHARISMA.id; score = 1 }
            scoringTag { tag = PERSUASION.id; score = 1 }
            scoringTag { tag = PERFORMANCE.id; score = 1 }
            scoringTag { tag = DECEPTION.id; score = 1 }
            scoringTag { tag = INSIGHT.id; score = 1 }
            scoringTag { tag = HYBRID.id; score = 1 }
        }
        answer {
            id = WISH_LADY dot ANS_4
            answer = DND_5E_2024 dot Stage.CLASS_TEST dot WISH_LADY dot ANS_4 dot userPickData.gender!!.toLabel()
            scoringTag { tag = STRENGTH.id; score = 1 }
            scoringTag { tag = CONSTITUTION.id; score = 1 }
            scoringTag { tag = MARTIAL.id; score = 1 }
            scoringTag { tag = ATHLETICS.id; score = 1 }
            scoringTag { tag = SURVIVAL.id; score = 1 }
        }
        answer {
            id = WISH_LADY dot ANS_5
            answer = DND_5E_2024 dot Stage.CLASS_TEST dot WISH_LADY dot ANS_5 dot userPickData.gender!!.toLabel()
            scoringTag { tag = INTELLIGENCE.id; score = 1 }
            scoringTag { tag = INVESTIGATION.id; score = 1 }
            scoringTag { tag = ARCANA.id; score = 1 }
            scoringTag { tag = MEDICINE.id; score = 1 }
            scoringTag { tag = HISTORY.id; score = 1 }
            scoringTag { tag = CASTER.id; score = 1 }
        }
        answer {
            id = WISH_LADY dot ANS_6
            answer = DND_5E_2024 dot Stage.CLASS_TEST dot WISH_LADY dot ANS_6 dot userPickData.gender!!.toLabel()
            scoringTag { tag = DEXTERITY.id; score = 1 }
            scoringTag { tag = LIGHT_ARMOR.id; score = 1 }
            scoringTag { tag = PERCEPTION.id; score = 1 }
            scoringTag { tag = INSIGHT.id; score = 1 }
        }
    }

    // 🐉 Pregunta 3: El huevo de dragón robado
    question {
        id = DRAGON_EGG.id
        question = DND_5E_2024 dot Stage.CLASS_TEST dot DRAGON_EGG dot userPickData.gender!!.toLabel()
        number = 2

        answer {
            id = DRAGON_EGG dot ANS_1
            answer = DND_5E_2024 dot Stage.CLASS_TEST dot DRAGON_EGG dot ANS_1 dot userPickData.gender!!.toLabel()
            scoringTag { tag = DEXTERITY.id; score = 1 }
            scoringTag { tag = WISDOM.id; score = 1 }
            scoringTag { tag = NATURE.id; score = 1 }
            scoringTag { tag = SURVIVAL.id; score = 1 }
            scoringTag { tag = PERCEPTION.id; score = 1 }
            scoringTag { tag = STEALTH.id; score = 1 }
            scoringTag { tag = LIGHT_ARMOR.id; score = 1 }
        }
        answer {
            id = DRAGON_EGG dot ANS_2
            answer = DND_5E_2024 dot Stage.CLASS_TEST dot DRAGON_EGG dot ANS_2 dot userPickData.gender!!.toLabel()
            scoringTag { tag = STRENGTH.id; score = 1 }
            scoringTag { tag = MARTIAL.id; score = 1 }
            scoringTag { tag = ATHLETICS.id; score = 1 }
            scoringTag { tag = INTIMIDATION.id; score = 1 }
            scoringTag { tag = PERCEPTION.id; score = 1 }
        }
        answer {
            id = DRAGON_EGG dot ANS_3
            answer = DND_5E_2024 dot Stage.CLASS_TEST dot DRAGON_EGG dot ANS_3 dot userPickData.gender!!.toLabel()
            scoringTag { tag = CHARISMA.id; score = 1 }
            scoringTag { tag = HYBRID.id; score = 1 }
            scoringTag { tag = RELIGION.id; score = 1 }
            scoringTag { tag = PERSUASION.id; score = 1 }
            scoringTag { tag = INSIGHT.id; score = 1 }
        }
        answer {
            id = DRAGON_EGG dot ANS_4
            answer = DND_5E_2024 dot Stage.CLASS_TEST dot DRAGON_EGG dot ANS_4 dot userPickData.gender!!.toLabel()
            scoringTag { tag = CHARISMA.id; score = 1 }
            scoringTag { tag = DECEPTION.id; score = 1 }
            scoringTag { tag = PERSUASION.id; score = 1 }
            scoringTag { tag = INVESTIGATION.id; score = 1 }
        }
        answer {
            id = DRAGON_EGG dot ANS_5
            answer = DND_5E_2024 dot Stage.CLASS_TEST dot DRAGON_EGG dot ANS_5 dot userPickData.gender!!.toLabel()
            scoringTag { tag = INTELLIGENCE.id; score = 1 }
            scoringTag { tag = HISTORY.id; score = 1 }
            scoringTag { tag = INTIMIDATION.id; score = 1 }
            scoringTag { tag = PERSUASION.id; score = 1 }
        }
        answer {
            id = DRAGON_EGG dot ANS_6
            answer = DND_5E_2024 dot Stage.CLASS_TEST dot DRAGON_EGG dot ANS_6 dot userPickData.gender!!.toLabel()
            scoringTag { tag = CONSTITUTION.id; score = 1 }
            scoringTag { tag = WISDOM.id; score = 1 }
            scoringTag { tag = SURVIVAL.id; score = 1 }
            scoringTag { tag = NATURE.id; score = 1 }
            scoringTag { tag = PERCEPTION.id; score = 1 }
            scoringTag { tag = ATHLETICS.id; score = 1 }
            scoringTag { tag = MEDICINE.id; score = 1 }
        }
    }

    // 👑 Pregunta 4: El sacrificio del heredero
    question {
        id = HEIR_SACRIFICE.id
        question = DND_5E_2024 dot Stage.CLASS_TEST dot HEIR_SACRIFICE dot userPickData.gender!!.toLabel()
        number = 3
        answer {
            id = HEIR_SACRIFICE dot ANS_1
            answer = DND_5E_2024 dot Stage.CLASS_TEST dot HEIR_SACRIFICE dot ANS_1 dot userPickData.gender!!.toLabel()
            scoringTag { tag = INTELLIGENCE.id; score = 1 }
            scoringTag { tag = CASTER.id; score = 1 }
            scoringTag { tag = ARCANA.id; score = 1 }
            scoringTag { tag = INTIMIDATION.id; score = 1 }
        }
        answer {
            id = HEIR_SACRIFICE dot ANS_2
            answer = DND_5E_2024 dot Stage.CLASS_TEST dot HEIR_SACRIFICE dot ANS_2 dot userPickData.gender!!.toLabel()
            scoringTag { tag = WISDOM.id; score = 1 }
            scoringTag { tag = NATURE.id; score = 1 }
            scoringTag { tag = ANIMAL_HANDLING.id; score = 1 }
            scoringTag { tag = SURVIVAL.id; score = 1 }
        }
        answer {
            id = HEIR_SACRIFICE dot ANS_3
            answer = DND_5E_2024 dot Stage.CLASS_TEST dot HEIR_SACRIFICE dot ANS_3 dot userPickData.gender!!.toLabel()
            scoringTag { tag = STRENGTH.id; score = 1 }
            scoringTag { tag = MARTIAL.id; score = 1 }
            scoringTag { tag = ATHLETICS.id; score = 1 }
            scoringTag { tag = SURVIVAL.id; score = 1 }
        }
        answer {
            id = HEIR_SACRIFICE dot ANS_4
            answer = DND_5E_2024 dot Stage.CLASS_TEST dot HEIR_SACRIFICE dot ANS_4 dot userPickData.gender!!.toLabel()
            scoringTag { tag = CHARISMA.id; score = 1 }
            scoringTag { tag = DECEPTION.id; score = 1 }
            scoringTag { tag = PERSUASION.id; score = 1 }
            scoringTag { tag = INTIMIDATION.id; score = 1 }
        }
        answer {
            id = HEIR_SACRIFICE dot ANS_5
            answer = DND_5E_2024 dot Stage.CLASS_TEST dot HEIR_SACRIFICE dot ANS_5 dot userPickData.gender!!.toLabel()
            scoringTag { tag = CONSTITUTION.id; score = 1 }
            scoringTag { tag = WISDOM.id; score = 1 }
            scoringTag { tag = INSIGHT.id; score = 1 }
            scoringTag { tag = SURVIVAL.id; score = 1 }
            scoringTag { tag = MEDICINE.id; score = 1 }
        }
        answer {
            id = HEIR_SACRIFICE dot ANS_6
            answer = DND_5E_2024 dot Stage.CLASS_TEST dot HEIR_SACRIFICE dot ANS_6 dot userPickData.gender!!.toLabel()
            scoringTag { tag = INTELLIGENCE.id; score = 1 }
            scoringTag { tag = HISTORY.id; score = 1 }
            scoringTag { tag = INSIGHT.id; score = 1 }
            scoringTag { tag = DECEPTION.id; score = 1 }
            scoringTag { tag = PERSUASION.id; score = 1 }
        }
    }

    // 🛡️ Pregunta 5: La orden de caballeros
    question {
        id = KNIGHT_ORDER.id
        question = DND_5E_2024 dot Stage.CLASS_TEST dot KNIGHT_ORDER dot userPickData.gender!!.toLabel()
        number = 4
        answer {
            id = KNIGHT_ORDER dot ANS_1
            answer = DND_5E_2024 dot Stage.CLASS_TEST dot KNIGHT_ORDER dot ANS_1 dot userPickData.gender!!.toLabel()
            scoringTag { tag = CHARISMA.id; score = 1 }
            scoringTag { tag = PERFORMANCE.id; score = 1 }
            scoringTag { tag = PERSUASION.id; score = 1 }
            scoringTag { tag = DECEPTION.id; score = 1 }
        }
        answer {
            id = KNIGHT_ORDER dot ANS_2
            answer = DND_5E_2024 dot Stage.CLASS_TEST dot KNIGHT_ORDER dot ANS_2 dot userPickData.gender!!.toLabel()
            scoringTag { tag = STRENGTH.id; score = 1 }
            scoringTag { tag = MARTIAL.id; score = 1 }
            scoringTag { tag = ATHLETICS.id; score = 1 }
            scoringTag { tag = INTIMIDATION.id; score = 1 }
        }
        answer {
            id = KNIGHT_ORDER dot ANS_3
            answer = DND_5E_2024 dot Stage.CLASS_TEST dot KNIGHT_ORDER dot ANS_3 dot userPickData.gender!!.toLabel()
            scoringTag { tag = CHARISMA.id; score = 1 }
            scoringTag { tag = PERSUASION.id; score = 1 }
            scoringTag { tag = INSIGHT.id; score = 1 }
            scoringTag { tag = PERFORMANCE.id; score = 1 }
        }
        answer {
            id = KNIGHT_ORDER dot ANS_4
            answer = DND_5E_2024 dot Stage.CLASS_TEST dot KNIGHT_ORDER dot ANS_4 dot userPickData.gender!!.toLabel()
            scoringTag { tag = WISDOM.id; score = 1 }
            scoringTag { tag = NATURE.id; score = 1 }
            scoringTag { tag = INSIGHT.id; score = 1 }
            scoringTag { tag = INTIMIDATION.id; score = 1 }
        }
        answer {
            id = KNIGHT_ORDER dot ANS_5
            answer = DND_5E_2024 dot Stage.CLASS_TEST dot KNIGHT_ORDER dot ANS_5 dot userPickData.gender!!.toLabel()
            scoringTag { tag = CONSTITUTION.id; score = 1 }
            scoringTag { tag = RELIGION.id; score = 1 }
            scoringTag { tag = INSIGHT.id; score = 1 }
            scoringTag { tag = INTIMIDATION.id; score = 1 }
            scoringTag { tag = SURVIVAL.id; score = 1 }
        }
        answer {
            id = KNIGHT_ORDER dot ANS_6
            answer = DND_5E_2024 dot Stage.CLASS_TEST dot KNIGHT_ORDER dot ANS_6 dot userPickData.gender!!.toLabel()
            scoringTag { tag = DEXTERITY.id; score = 1 }
            scoringTag { tag = PERCEPTION.id; score = 1 }
            scoringTag { tag = ATHLETICS.id; score = 1 }
            scoringTag { tag = INTIMIDATION.id; score = 1 }
        }
    }

    // 🔮 Pregunta 6: El destino inexorable
    question {
        id = INEXORABLE_FATE.id
        question = DND_5E_2024 dot Stage.CLASS_TEST dot INEXORABLE_FATE dot userPickData.gender!!.toLabel()
        number = 5
        answer {
            id = INEXORABLE_FATE dot ANS_1
            answer = DND_5E_2024 dot Stage.CLASS_TEST dot INEXORABLE_FATE dot ANS_1 dot userPickData.gender!!.toLabel()
            scoringTag { tag = STRENGTH.id; score = 1 }
            scoringTag { tag = MARTIAL.id; score = 1 }
            scoringTag { tag = INTIMIDATION.id; score = 1 }
        }
        answer {
            id = INEXORABLE_FATE dot ANS_2
            answer = DND_5E_2024 dot Stage.CLASS_TEST dot INEXORABLE_FATE dot ANS_2 dot userPickData.gender!!.toLabel()
            scoringTag { tag = CONSTITUTION.id; score = 1 }
            scoringTag { tag = INSIGHT.id; score = 1 }
            scoringTag { tag = SURVIVAL.id; score = 1 }
        }
        answer {
            id = INEXORABLE_FATE dot ANS_3
            answer = DND_5E_2024 dot Stage.CLASS_TEST dot INEXORABLE_FATE dot ANS_3 dot userPickData.gender!!.toLabel()
            scoringTag { tag = WISDOM.id; score = 1 }
            scoringTag { tag = HYBRID.id; score = 1 }
            scoringTag { tag = RELIGION.id; score = 1 }
            scoringTag { tag = PERCEPTION.id; score = 1 }
        }
        answer {
            id = INEXORABLE_FATE dot ANS_4
            answer = DND_5E_2024 dot Stage.CLASS_TEST dot INEXORABLE_FATE dot ANS_4 dot userPickData.gender!!.toLabel()
            scoringTag { tag = CHARISMA.id; score = 1 }
            scoringTag { tag = PERSUASION.id; score = 1 }
            scoringTag { tag = NATURE.id; score = 1 }
            scoringTag { tag = HISTORY.id; score = 1 }
        }
        answer {
            id = INEXORABLE_FATE dot ANS_5
            answer = DND_5E_2024 dot Stage.CLASS_TEST dot INEXORABLE_FATE dot ANS_5 dot userPickData.gender!!.toLabel()
            scoringTag { tag = DEXTERITY.id; score = 1 }
            scoringTag { tag = INSIGHT.id; score = 1 }
            scoringTag { tag = PERCEPTION.id; score = 1 }
            scoringTag { tag = MEDICINE.id; score = 1 }
            scoringTag { tag = MARTIAL.id; score = 1 }
        }
        answer {
            id = INEXORABLE_FATE dot ANS_6
            answer = DND_5E_2024 dot Stage.CLASS_TEST dot INEXORABLE_FATE dot ANS_6 dot userPickData.gender!!.toLabel()
            scoringTag { tag = INTELLIGENCE.id; score = 1 }
            scoringTag { tag = INVESTIGATION.id; score = 1 }
            scoringTag { tag = INSIGHT.id; score = 1 }
            scoringTag { tag = PERCEPTION.id; score = 1 }
        }
    }
}.build()