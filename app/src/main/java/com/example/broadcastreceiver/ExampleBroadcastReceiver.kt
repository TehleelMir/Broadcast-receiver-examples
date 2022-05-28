package com.example.broadcastreceiver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager
import android.util.Log
import android.widget.Toast

class ExampleBroadcastReceiver: BroadcastReceiver() {

    /*
        This is the method which work like a listener, and listen for the
        event which we have defined for this broad cast.

        There are two ways to add the listener events in this broad caster receiver
        - one is to add it in the manifest file like the below, and its called statically
            <receiver android:name=".ExampleBroadcastReceiver"
                android:exported="true">
                <intent-filter>
                    <action android:name="android.intent.action.BOOT_COMPLETED" />
                    <action android:name="android.net.conn.CONNECTIVITY_CHANGE" />
                </intent-filter>
            </receiver>


        - Second is to add them programmatically, its called dynamically
            dynamically means that we put register the receiver
            directly in the code with a context, and as along as that context is alive
            the broad cast receiver will keep listing for the events.
            If we use application level context and register any event, it will keep
            listing until the app is running.
     */
    override fun onReceive(context: Context?, intent: Intent?) {
        /*
            Intent will contain the action that triggered this broad cast
            since a single broad caste might be listing for more then one events
         */

        if(Intent.ACTION_BOOT_COMPLETED == intent?.action) {
            Toast.makeText(context, "Boot completed from test app", Toast.LENGTH_LONG).show()
            Log.i("here22", "system booted")
        }

        if(ConnectivityManager.CONNECTIVITY_ACTION == intent?.action) {
            Toast.makeText(context, "Connectivity changed", Toast.LENGTH_LONG).show()
        }
    }
}





































