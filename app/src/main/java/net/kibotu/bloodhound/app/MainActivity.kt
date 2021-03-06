package net.kibotu.bloodhound.app

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import net.kibotu.bloodhound.BloodHound
import java.util.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // tracking screen
        BloodHound.screen("main_screen", MainActivity::class.java.simpleName)

        // firebase tracking events

        BloodHound.track("user_event", mapOf("user" to UUID.randomUUID().toString()))

        // google analytics tracking events

        BloodHound.track("category", "action", "app_start", mapOf("user" to UUID.randomUUID().toString()))

        // reset, e.g.: logout
        BloodHound.reset()
    }
}