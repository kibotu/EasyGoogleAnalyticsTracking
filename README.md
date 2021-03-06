[![Donation](https://img.shields.io/badge/donate-please-brightgreen.svg)](https://www.paypal.me/janrabe) [![About Jan Rabe](https://img.shields.io/badge/about-me-green.svg)](https://about.me/janrabe) 
# BloodHoud [![Android Arsenal](https://img.shields.io/badge/Android%20Arsenal-BloodHound-green.svg?style=true)](https://android-arsenal.com/details/1/3559) [![](https://jitpack.io/v/kibotu/BloodHound.svg)](https://jitpack.io/#kibotu/BloodHound)  [![Javadoc](https://img.shields.io/badge/javadoc-SNAPSHOT-green.svg)](https://jitpack.io/com/github/kibotu/BloodHound/master-SNAPSHOT/javadoc/index.html) [![Build Status](https://travis-ci.org/kibotu/BloodHound.svg)](https://travis-ci.org/kibotu/BloodHound)  [![API](https://img.shields.io/badge/API-15%2B-brightgreen.svg?style=flat)](https://android-arsenal.com/api?level=15) [![API](https://img.shields.io/badge/com.google.android.gms-16.0.0-brightgreen.svg)](https://developers.google.com/android/guides/setup) [![API](https://img.shields.io/badge/com.google.firebase-16.0.6-brightgreen.svg)](https://firebase.google.com/docs/analytics/android/start) [![Gradle Version](https://img.shields.io/badge/gradle-5.1.1-green.svg)](https://docs.gradle.org/current/release-notes) [![GitHub license](https://img.shields.io/badge/license-Apache%202-blue.svg)](https://raw.githubusercontent.com/kibotu/BloodHound/master/LICENSE) [![Kotlin](https://img.shields.io/badge/kotlin-1.3.20-green.svg)](https://github.com/JetBrains/kotlin) [![Android Studio Canary](https://img.shields.io/badge/Android%20Studio%20Canary-latest-green.svg)](https://developer.android.com/studio/preview/)

Tiny library for tracking screens and events with google analytics and / or firebase analytics.

### How to install
	
	repositories {
	    maven {
	        url "https://jitpack.io"
	    }
	}
		
	dependencies {
            implement 'com.github.kibotu:BloodHound:-SNAPSHOT'

            // for google analytics
            implement "com.google.android.gms:play-services-gcm:16.0.0"
            implement "com.google.android.gms:play-services-analytics:16.0.6"

            // for firebase
            implement "com.google.firebase:firebase-core:16.0.6"
    }

### How to use

#### Google Analytics

0. Add gms version to manifest

        <application>
            <meta-data
                android:name="com.google.android.gms.version"
                android:value="@integer/google_play_services_version" />
        </application>

1. Initialize
    
        BloodHound.with(context, "trackingId")

2. Track Screens

        BloodHound.screen("main_screen")

3. Track Events

       BloodHound.track("category", "action", "app_start",
            mapOf("user" to UUID.randomUUID().toString()) // (optional) parameters
       )

4. (optional) Reset client

    	BloodHound.reset()

### Firebase

1. Initialize

        BloodHound.with(context)

2. Track Screens

        BloodHound.screen("main_screen")

        // with screen class
        // BloodHound.screen("main_screen", MainActivity::class.java.simpleName)

3. Track Events

        BloodHound.track("main_screen", "user_event",
            mapOf("user" to UUID.randomUUID().toString()) // (optional) parameters
        )

4. (optional) Reset client

    	BloodHound.reset()
    
### GoogleAnalyitcsOptions (defaults)
    
    BloodHound.with(this, "trackingId", GoogleAnalyitcsOptions(
        enableDebugging = false,
        enableLogging = false,
        exceptionReporting = false,
        advertisingIdCollection = true,
        autoActivityTracking = false,
        sessionTimeout = 300,
        sampleRate = 100.0,
        sessionLimit = 500,
        dryRun = false,
        anonymizeIp = true
    ))

### FirebaseOptions (defaults)

    BloodHound.with(this, FirebaseOptions(
        enableDebugging = false,
        enableLogging = false
    ))
            
### License
<pre>
Copyright 2019 Jan Rabe

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

   http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
</pre>