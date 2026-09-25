package com.javier.comoqueraisapps.MessageApp

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.javier.comoqueraisapps.R

class ResponseActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_response)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val tvHello = findViewById<TextView>(R.id.mensajePantalla)
        var message = intent.extras?.getString("extra_message").orEmpty()
        tvHello.text = "$message"

        val btnSend = findViewById<Button>(R.id.botonEnviar)
        val etMessage = findViewById<EditText>(R.id.eTxtMensaje)
        btnSend.setOnClickListener {
            var message: String = etMessage.text.toString()
            if (message.isNotEmpty()){
                var intent = Intent(this, MessageActivity::class.java)
                intent.putExtra("extra_message", message)
                startActivity(intent)
            }
            Log.i("Javier", "Sending")
        }
    }
}