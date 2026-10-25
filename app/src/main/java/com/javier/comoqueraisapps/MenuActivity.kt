package com.javier.comoqueraisapps

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.javier.comoqueraisapps.BoardGamesApp.BoardGamesActivity
import com.javier.comoqueraisapps.HelloApp.MainActivity
import com.javier.comoqueraisapps.IMCApp.IMCActivity
import com.javier.comoqueraisapps.MessageApp.MessageActivity
import com.javier.comoqueraisapps.PaletaColoresApp.PaletaColoresApp

class MenuActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_menu)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val btnHelloApp = findViewById<Button>(R.id.btnHelloApp)
        val btnMessageActivity = findViewById<Button>(R.id.btnMessageApp)
        val btnImcApp = findViewById<Button>(R.id.btnImcApp)
        val btnBoardGamesApp = findViewById<Button>(R.id.btnBoardGameApp)
        val btnPaletaColoresApp = findViewById<Button>(R.id.btnPaletaColoresApp)
        btnHelloApp.setOnClickListener { navigateToHelloApp() }
        btnMessageActivity.setOnClickListener { navigateToMessageActivity() }
        btnImcApp.setOnClickListener { navigateToImcApp() }
        btnBoardGamesApp.setOnClickListener { navigateToBoardGameApp() }
        btnPaletaColoresApp.setOnClickListener { navigateToPaletaColoresApp() }
    }

    private fun navigateToHelloApp() {
        var intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }

    private fun navigateToMessageActivity() {
        var intent = Intent(this, MessageActivity::class.java)
        startActivity(intent)
    }

    private fun navigateToImcApp() {
        var intent = Intent(this, IMCActivity::class.java)
        startActivity(intent)
    }
    private fun navigateToBoardGameApp(){
        var intent = Intent(this, BoardGamesActivity::class.java)
        startActivity(intent)
    }
    private fun navigateToPaletaColoresApp(){
        var intent = Intent(this, PaletaColoresApp::class.java)
        startActivity(intent)
    }
}