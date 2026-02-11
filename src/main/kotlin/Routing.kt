package dnd


import dnd.dtos.UserPickData
import dnd.managers.Managers
import dnd.managers.StageManagerDTO
import io.ktor.serialization.kotlinx.json.*
import io.ktor.server.application.*
import io.ktor.server.plugins.contentnegotiation.*
import io.ktor.server.request.receive
import io.ktor.server.response.*
import io.ktor.server.routing.*
import java.util.UUID

fun Application.configureRouting() {
    routing {
        get("v1/creator/start") {
            val userSession = call.request.cookies["USER_SESSION"] ?: UUID.randomUUID().toString()
            if (call.request.cookies["USER_SESSION"] == null){
                call.response.cookies.append("USER_SESSION", userSession, httpOnly = true, maxAge = 60 * 60)
            }
            val manager = Managers.getManager(userSession)
            call.respond<StageManagerDTO>(manager.toDto())
        }

        post("v1/creator/next") {
            val userSession = call.request.cookies["USER_SESSION"]!!
            println(userSession)
            val userPicks = call.receive<UserPickData>()
            val manager = Managers.getManager(userSession).nextStage(userPicks)

            call.respond<StageManagerDTO>(manager.toDto())
        }

        post("v1/creator/previous") {
            val userSession = call.request.cookies["USER_SESSION"]!!
            val userPicks = call.receive<UserPickData>()
            val manager = Managers.getManager(userSession).previousStage(userPicks)

            call.respond<StageManagerDTO>(manager.toDto())
        }
    }
}
