package com.javier.comoqueraisapps.PaletaColoresApp

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.javier.comoqueraisapps.R

class PaletaColoresApp : AppCompatActivity() {

    private lateinit var rvColores: RecyclerView
    private lateinit var rvAdapter: ColoresAdapter
    private val colores = listOf(
        Color("V1 (20%)", -871890688),
        Color("V2 (35%)", -1509921024),
        Color("V3 (50%)", -1131230976),
        Color("V4 (65%)", -1509883935),
        Color("V5 (80%)", -858717953)
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_paleta_colores_app)
        rvColores = findViewById(R.id.rvColores)
        rvAdapter = ColoresAdapter(colores)

        rvColores.layoutManager = LinearLayoutManager(
            this, LinearLayoutManager.HORIZONTAL, false
        )
        rvColores.adapter = rvAdapter

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}