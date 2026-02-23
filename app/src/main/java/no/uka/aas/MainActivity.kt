package no.uka.aas

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import no.uka.aas.ui.theme.UKAiAsTheme
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import android.util.Log
import androidx.compose.runtime.LaunchedEffect
import com.google.firebase.messaging.FirebaseMessaging
import com.google.firebase.FirebaseApp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        installSplashScreen()
        super.onCreate(savedInstanceState)

        setContent {
            LaunchedEffect(Unit) {
                FirebaseMessaging.getInstance().token.addOnCompleteListener { task ->
                    if (!task.isSuccessful) return@addOnCompleteListener
                    Log.d("FCM", "FCM token: ${task.result}")
                }
            }
            UKAiAsTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    var screen by remember { mutableStateOf("intro") }

                    when (screen) {
                        "intro" -> IntroView(onNext = { screen = "countdown" })
                        "countdown" -> CountdownView(onNext = { screen = "main" })
                        "main" -> MainScaffold()
                    }
                }
            }
        }
    }
}


