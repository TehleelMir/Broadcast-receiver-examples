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
                    First we could define these action statically in the manifest file in that way
                    if our app was not running it used to still receive the events from from android O
                    that's not the use. Now we have to define implicit broadcast dynamically other wise they
                    won't work.

                    Below is the example of explicit broad cast receiver where we define directly what
                    broad cast to was to trigger and like implicit broad cast it can get triggered even if the
                    app is not in the background and also if any second app tried to call this broad cast directly it will
                    still start if the app was not running in the background. we have to also add it in the manifest file

                    see below video for more info:
                    https://youtu.be/a8DaHJLHBfI?list=PLrnPJCHvNZuBhmqlWEQfvxbNtY6B_XJ3n
                 */

                val intent = Intent(this, ExampleBroadcastReceiver2::class.java)

                /*
                    When ever we want to send a broad cast we use the
                    sendBroadcast() method, which is good, but it will send broadcast to all the
                    listeners in an unordered manner. But we want to configure this order we can use
                    sendOrderBroadcast(), where each broad cast is sent Sequential order, and we can also define the order ourself as well. And we can also
                    update the data which is going to be send from one broad cast to another and we can even aboard the next broad cast.

                    https://youtu.be/Eyuez4D-qLg?list=PLrnPJCHvNZuBhmqlWEQfvxbNtY6B_XJ3n
                 */

                sendBroadcast(intent)
            }
    }
}

































