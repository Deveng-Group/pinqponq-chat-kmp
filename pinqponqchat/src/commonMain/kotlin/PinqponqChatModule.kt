package pinqponqchat

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import networking.DevengNetworkingConfig
import networking.DevengNetworkingModule
import networking.util.DevengHttpMethod

public object PinqponqChatModule {

    public fun test() {
        println("test")
        DevengNetworkingModule.initDevengNetworkingModule(
            restBaseUrl = "https://api.pinqponq.io",
            config = DevengNetworkingConfig(
                loggingEnabled = true
            )
        )
        GlobalScope.launch {
            try {

                val a = DevengNetworkingModule.sendRequest<Unit, Unit>(
                    endpoint = "v1/chat/messages",
                    requestMethod = DevengHttpMethod.GET,

                    )


            } catch (e: Exception) {
                println("Error: ${e.message}")
            }
        }
    }

}