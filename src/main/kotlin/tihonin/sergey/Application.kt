package tihonin.sergey

import io.ktor.server.application.*
import io.ktor.server.cio.*
import io.ktor.server.engine.*
import org.jetbrains.exposed.sql.Database
import tihonin.sergey.features.invite.configureInviteRouting
import tihonin.sergey.features.project.configureProjectRouting
import tihonin.sergey.features.login.configureLoginRouting
import tihonin.sergey.features.participant.configureParticipantsRouting
import tihonin.sergey.features.projecttree.configureProjecttreeRouting
import tihonin.sergey.features.register.configureRegisterRouting
import tihonin.sergey.features.task.configureTaskRouting
import tihonin.sergey.plugins.*

fun main() {
    Database.connect(
        url = "jdbc:postgresql://localhost:5432/diploma",
        driver = "org.postgresql.Driver",
        user = "postgres",
        password = "root"
    )

    embeddedServer(CIO, port = 8080, host = "0.0.0.0", module = Application::module)
        .start(wait = true)
}

fun Application.module() {
    configureSecurity()
    configureParticipantsRouting()
    configureProjecttreeRouting()
    configureTaskRouting()
    configureProjectRouting()
    configureLoginRouting()
    configureRegisterRouting()
    configureInviteRouting()
    configureCORS()
    configureSerialization()
    configureRouting()
}
