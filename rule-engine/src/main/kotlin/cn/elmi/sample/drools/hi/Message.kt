package cn.elmi.sample.drools.hi

data class Message(
    val message: String,
    var status: MessageStatus
)

enum class MessageStatus {
    HI, BYE
}