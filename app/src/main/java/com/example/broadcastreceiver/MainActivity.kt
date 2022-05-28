package com.example.broadcastreceiver

import android.content.Intent
import android.content.IntentFilter
import android.net.ConnectivityManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

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

    We can also create our own custom broad caste which we can both trigger and listen.
    and our custom broad cast can be explicit broad cast which mean we define ourself which broad cast receiver we want to trigger
    e.g. we can say that we want to trigger our example broad caste receiver and no other receiver.
    or we can send an implicit broad cast which is same as system broad cast
 */

class MainActivity : AppCompatActivity() {
    private lateinit var exampleBroadcastReceiver: ExampleBroadcastReceiver

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()
    }

    private fun init() {
        exampleBroadcastReceiver = ExampleBroadcastReceiver()
        findViewById<TextView>(R.id.textView)
            .setOnClickListener {
                /*
                    We can also send the below action from another app if we want,
                    and as long as our broad cast is listing, it will get trigger in the same way
                    the below code trigger the broad cast receiver.
                    Even we have to use the same 3 lines in other app as well.

                    We can also use local broad cast receiver, in that way our app will be only
                    one which will receive the broad events no matter if the other app are also listing.
                    By this way we can increase the security of our app

                    watch below video if your not getting it
                    https://www.youtube.com/watch?v=qNocH6Angt0&list=PLrnPJCHvNZuBhmqlWEQfvxbNtY6B_XJ3n&index=7
                 */
                val intent = Intent("com.example.projectname_OUR_ACTION")
                intent.putExtra("key", "hello mf")
                sendBroadcast(intent)
            }
    }

    override fun onStart() {
        super.onStart()
        val intentFilter = IntentFilter()
        intentFilter.addAction("com.example.projectname_OUR_ACTION")
        // can add more then one like we do in the manifest file
        registerReceiver(exampleBroadcastReceiver, intentFilter)
    }

    override fun onStop() {
        super.onStop()
        unregisterReceiver(exampleBroadcastReceiver)
    }
}

































