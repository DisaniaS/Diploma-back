package tihonin.sergey.features.invite

import kotlinx.serialization.Serializable

@Serializable
data class CreateInviteReceiveRemote(
    val projectid: String
)

@Serializable
data class CreateInviteResponseRemote(
    val code: String
)

@Serializable
data class JoinInviteReceiveRemote(
    val code: String,
    val userid: String
)