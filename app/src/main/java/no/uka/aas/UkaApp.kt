package no.uka.aas

import android.app.Application
import android.util.Log
import com.google.firebase.FirebaseApp

class UkaApp : Application() {
    override fun onCreate() {
        super.onCreate()
        Log.d("UKAAPP", "UkaApp onCreate() running")
        FirebaseApp.initializeApp(this)
    }
}
