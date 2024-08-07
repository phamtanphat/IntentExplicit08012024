package com.example.intentexplicit08012024

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    private var btnSendData : Button? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        btnSendData = findViewById(R.id.button_send_data_by_intent)
        btnSendData?.setOnClickListener {
            val intent = Intent(this@MainActivity, MainActivity2::class.java)
            // 1: String
            // intent.putExtra("string", "Hello")

            // 2: Array
            // intent.putExtra("int_array", IntArray(5) { it })

            // 3: Object
            intent.putParcelableArrayListExtra("object", arrayListOf(User("teo", 3)))

            startActivity(intent)
        }
    }
}