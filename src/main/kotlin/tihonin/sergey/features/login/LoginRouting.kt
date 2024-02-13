package tihonin.sergey.features.login

import io.ktor.server.application.*
import io.ktor.server.routing.*

fun Application.configureLoginRouting() {

    routing {
        post("/login") {
            val loginController = LoginController(call)
            loginController.performLogin()
        }
        post("/logout") {
            val loginController = LoginController(call)
            loginController.performLogout()
        }
    }
}