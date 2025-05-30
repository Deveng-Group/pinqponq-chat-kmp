import androidx.compose.ui.window.ComposeUIViewController
import io.pinqponq.chat.App
import platform.UIKit.UIViewController

fun MainViewController(): UIViewController = ComposeUIViewController { App() }
