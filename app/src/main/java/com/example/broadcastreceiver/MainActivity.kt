package com.example.broadcastreceiver

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

/*
    So, broad cast receiver are used to listen for events, which can be both system level and the custom one and only other app can send
    broad cast events as well. And the listener for these events will get triggered event if the app is not running in the background.

    System events like:
    - System boot up
    - New SMS
    - Network connectivity updates and so more.

    Just like intents there are two types of broad caste receivers/events
    - Implicit broad cast: Where we make our broad caste receiver to subscribe any events i.e. we won't be calling it, the publisher will call it.
    - Explicit broad cast: Where we call our broad caste receiver directly by its class name, usually they are custom broad caste receiver which we have defined
    in our app.

    Broad cast receivers will only work or listen to the events, if the user opens the app at lest once until then it won't
    be listing for any events.
 */

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}