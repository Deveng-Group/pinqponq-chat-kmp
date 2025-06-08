package pinqponqchat.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import pinqponqchat.data.listOfMessages

@Composable
public fun ChatPage() {
    Column {
        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
            ,
            reverseLayout = true,
        ) {
            items(listOfMessages) { message ->
                MessageBox(message = message)
            }
        }

        MessageInputField()
    }

}
