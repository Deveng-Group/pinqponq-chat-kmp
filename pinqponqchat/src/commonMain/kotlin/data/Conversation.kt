package pinqponqchat.data

import global.deveng.pinqponqchat.generated.resources.Res
import global.deveng.pinqponqchat.generated.resources.ic_cyclone
import global.deveng.pinqponqchat.generated.resources.ic_rotate_right
import org.jetbrains.compose.resources.DrawableResource

internal data class Conversation(
    val sender: String,
    val image: DrawableResource,
    val amILastSender: Boolean,
    val message: String,
    val time: String,
    val unread: Boolean,
)

internal val listOfConversations = listOf(
    Conversation(
        sender = "Janet Fowler",
        image = Res.drawable.ic_rotate_right,
        amILastSender = false,
        message = "I'm going to San Francisco for a few days. I'll be back on Monday.",
        time = "now",
        unread = true,
    ),
    Conversation(
        sender = "Jason Boyd",
        image = Res.drawable.ic_cyclone,
        amILastSender = true,
        message = "Sounds good!",
        time = "16:23",
        unread = false,
    ),
    Conversation(
        sender = "Nicolas Dunn",
        image = Res.drawable.ic_cyclone,
        amILastSender = false,
        message = "See you there.",
        time = "16:22",
        unread = true,
    ),
    Conversation(
        sender = "Carol Clark",
        image = Res.drawable.ic_cyclone,
        amILastSender = false,
        message = "Are you going to the party tonight?",
        time = "15:30",
        unread = false,
    ),
    Conversation(
        sender = "Ann Carroll",
        image = Res.drawable.ic_cyclone,
        amILastSender = false,
        message = "Dinner tonight?",
        time = "Mon",
        unread = false,
    )
)