package com.example.intentexplicit08012024

import android.os.Build
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main2)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Get data intent

        // 1: String
        // val textData = intent.getStringExtra("string")

        // 2: Int array
        // val intArrayData = intent.getIntArrayExtra("int_array")

        // 3: Object
        val objectData = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            intent.getSerializableExtra("object", User::class.java)
        } else {
            intent.getSerializableExtra("object") as User
        }

        Toast.makeText(this, objectData?.name, Toast.LENGTH_LONG).show()
    }
}