package pinqponqchat.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import global.deveng.pinqponqchat.generated.resources.IndieFlower_Regular
import global.deveng.pinqponqchat.generated.resources.Res
import global.deveng.pinqponqchat.generated.resources.ic_cyclone
import global.deveng.pinqponqchat.generated.resources.ic_dark_mode
import org.jetbrains.compose.resources.Font
import org.jetbrains.compose.resources.painterResource

@Composable
internal fun MessageInputField() {
    val message = remember { mutableStateOf("") }

    TextField(
        value = message.value,
        onValueChange = {
            message.value = it
        },
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 16.dp)
            .navigationBarsPadding()
            .imePadding(),
        textStyle = TextStyle(
            color = Color(0xFFCCCCCC),
            fontSize = 16.sp,
            fontFamily = FontFamily(Font(Res.font.IndieFlower_Regular))
        ),
        placeholder = {
            Text(
                text = "Type a message...",
                style = TextStyle(
                    color = Color(0xFFCCCCCC),
                    fontSize = 16.sp,
                    fontFamily = FontFamily(Font(Res.font.IndieFlower_Regular))
                )
            )
        },
        leadingIcon = {
            IconButton(
                onClick = { },
                colors = IconButtonDefaults.iconButtonColors(
                    contentColor = Color(0xFFCCCCCC)
                )
            ) {
                Icon(
                    painter = painterResource(Res.drawable.ic_dark_mode),
                    contentDescription = null
                )
            }
        },
        trailingIcon = {
            IconButton(
                onClick = { /*TODO*/ },
                colors = IconButtonDefaults.iconButtonColors(
                    contentColor = Color(0xFFCCCCCC)
                )
            ) {
                Image(
                    painter = painterResource(Res.drawable.ic_cyclone),
                    contentDescription = null,
                )
            }
        },
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Text,
            imeAction = ImeAction.Done
        ),
        shape = RoundedCornerShape(50),

        )
}