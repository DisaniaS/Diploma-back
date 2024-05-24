package tihonin.sergey

import io.ktor.server.application.*
import io.ktor.server.cio.*
import io.ktor.server.engine.*
import org.jetbrains.exposed.sql.Database
import tihonin.sergey.features.invite.configureInviteRouting
import tihonin.sergey.features.project.configureProjectRouting
import tihonin.sergey.features.login.configureLoginRouting
import tihonin.sergey.features.participant.configureParticipantsRouting
import tihonin.sergey.features.graph.configureGraphRouting
import tihonin.sergey.features.register.configureRegisterRouting
import tihonin.sergey.features.task.configureTaskRouting
import tihonin.sergey.plugins.*

fun main() {
    Database.connect(
        url = "jdbc:postgresql://localhost:5432/diploma",postgresql://192.168.0.4:5432/default_db
        driver = "org.postgresql.Driver",
        user = "gen_user",
        password = "i0iTB%40_%7C(cYrF%3B"
    )

    embeddedServer(CIO, port = 8080, host = "0.0.0.0", module = Application::module)
        .start(wait = true)
}

fun Application.module() {
    configureSecurity()
    configureGraphRouting()
    configureParticipantsRouting()
    configureTaskRouting()
    configureProjectRouting()
    configureLoginRouting()
    configureRegisterRouting()
    configureInviteRouting()
    configureCORS()
    configureSerialization()
    configureRouting()
}
