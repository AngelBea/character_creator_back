package dnd.extensions

import dnd.dtos.UserPickData
import dnd.managers.Stage

fun UserPickData.toLabelId(stage: Stage): String = listOfNotNull(
    rules, stage.id, gender, characterClass, background
).joinToString(".")