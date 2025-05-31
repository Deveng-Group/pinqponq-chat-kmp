package pinqponqchat.components

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
public fun ChatMessageItem(
    message: String,
    isSentByUser: Boolean
) {
    Text(
        text = message,
        modifier = Modifier.padding(8.dp),
        color = if (isSentByUser) Color.Blue else Color.Black
    )
}