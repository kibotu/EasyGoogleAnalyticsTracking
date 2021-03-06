/*
 * Created by [Jan Rabe](https://about.me/janrabe)
 */

package net.kibotu.bloodhound.internal.gms

data class GoogleAnalyitcsOptions(
        var enableDebugging: Boolean = false,
        var enableLogging: Boolean = false,
        var exceptionReporting: Boolean = false,
        var advertisingIdCollection: Boolean = true,
        var autoActivityTracking: Boolean = false,
        var sessionTimeout: Long = 300,
        var sampleRate: Double = 100.0,
        var sessionLimit: Int = 500,
        var dryRun: Boolean = false,
        var anonymizeIp: Boolean = true
)