/*
 * Created by [Jan Rabe](https://about.me/janrabe)
 */

package net.kibotu.bloodhound.internal.firebase

import android.app.Activity
import android.app.Application
import android.os.Bundle
import androidx.annotation.RequiresPermission
import androidx.annotation.Size
import com.google.firebase.analytics.FirebaseAnalytics
import net.kibotu.bloodhound.BloodHound
import net.kibotu.bloodhound.internal.AnalyticsTracker
import net.kibotu.bloodhound.toBundle

internal class FirebaseAnalyticsTracker : AnalyticsTracker {

    companion object {
        @RequiresPermission(allOf = ["android.permission.INTERNET", "android.permission.ACCESS_NETWORK_STATE", "android.permission.WAKE_LOCK"])
        fun create(context: Application, options: FirebaseOptions? = null): FirebaseAnalyticsTracker = FirebaseAnalyticsTracker().apply {
            analytics = FirebaseAnalytics.getInstance(context)
            configure(options)
        }
    }

    lateinit var analytics: FirebaseAnalytics

    override fun reportActivityStart(activity: Activity?) {
    }

    override fun reportActivityStop(activity: Activity?) {
    }

    override fun reset() {
    }

    fun track(screenName: String, @Size(min = 1L, max = 40L) event: String? = null, arguments: Map<String, String>? = null) {
        analytics.setCurrentScreen(BloodHound.activity ?: return, screenName, null)
        analytics.logEvent(event ?: FirebaseAnalytics.Event.VIEW_ITEM, arguments?.toBundle() ?: Bundle())
        BloodHound.log("[ $screenName | ${event ?: FirebaseAnalytics.Event.VIEW_ITEM} | ${arguments ?: "no arguments"} ]")
    }

    private fun configure(options: FirebaseOptions?) {
    }
}