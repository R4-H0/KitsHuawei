package com.example.kitshuawei


import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

var tvToken: TextView? = null
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tvToken = findViewById(R.id.mensaje);


        val receiver = MyReceiver()
        val filter = IntentFilter()
        filter.addAction("com.huawei.codelabpush.ON_NEW_TOKEN")
        this@MainActivity.registerReceiver(receiver, filter)


    }

    class MyReceiver : BroadcastReceiver() {
        override fun onReceive(context: Context?, intent: Intent) {
            if ("com.huawei.codelabpush.ON_NEW_TOKEN" == intent.action) {
                val token = intent.getStringExtra("token")
                tvToken?.setText(token)
            }
        }
    }

}