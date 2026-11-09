package com.javier.comoqueraisapps.PaletaColoresApp

import android.app.Dialog
import android.os.Bundle
import android.widget.Button
import android.widget.RadioGroup
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.javier.comoqueraisapps.R

class PaletaColoresApp : AppCompatActivity() {

    private lateinit var rvColores: RecyclerView
    private lateinit var rvAdapter: ColoresAdapter
    private lateinit var viewBoton: CardView
    private lateinit var cvH1: CardView
    private lateinit var cvH2: CardView
    private lateinit var cvH3: CardView
    private val colores = listOf(
        Color("V1 (20%)", R.color.amarillo_20),
        Color("V2 (35%)", R.color.naranja_35),
        Color("V3 (50%)", R.color.amarillo_50),
        Color("V4 (65%)", R.color.cian_65),
        Color("V5 (80%)", R.color.violeta_80)
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
        initComponents()
        initListeners()
    }

    private fun initComponents() {
        viewBoton = findViewById(R.id.viewBoton)
        cvH1 = findViewById(R.id.viewH1)
        cvH2 = findViewById(R.id.viewH2)
        cvH3 = findViewById(R.id.viewH3)
    }

    private fun initListeners() {
        viewBoton.setOnClickListener {showDialog()}
    }
    private fun showDialog() {
        val dialog = Dialog(this)
        dialog.setContentView(R.layout.dialog_colors)

        val rgBarras = dialog.findViewById<RadioGroup>(R.id.rgBarras)
        val rgColores = dialog.findViewById<RadioGroup>(R.id.rgColores)
        val btnAplicar = dialog.findViewById<Button>(R.id.btnAplicar)

        btnAplicar.setOnClickListener {
            val idBarra = rgBarras.checkedRadioButtonId
            val idColor = rgColores.checkedRadioButtonId

            if (idBarra != -1 && idColor != -1) {
                val idResourceColor = obtenerColor(idBarra, idColor)

                when (idBarra) {
                    R.id.rbH1 -> cvH1.setCardBackgroundColor(ContextCompat.getColor(this, idResourceColor))
                    R.id.rbH2 -> cvH2.setCardBackgroundColor(ContextCompat.getColor(this, idResourceColor))
                    R.id.rbH3 -> cvH3.setCardBackgroundColor(ContextCompat.getColor(this, idResourceColor))
                    R.id.rbV1 -> actualizarItemRv(0, idResourceColor)
                    R.id.rbV2 -> actualizarItemRv(1, idResourceColor)
                    R.id.rbV3 -> actualizarItemRv(2, idResourceColor)
                    R.id.rbV4 -> actualizarItemRv(3, idResourceColor)
                    R.id.rbV5 -> actualizarItemRv(4, idResourceColor)
                }

                dialog.dismiss()
            }
        }

        dialog.show()
    }
    private fun actualizarItemRv(posicion: Int, colorNuevo: Int) {
        colores[posicion].color = colorNuevo
        rvAdapter.notifyDataSetChanged()
    }
    private fun obtenerColor(idBarra: Int, idColor: Int): Int {
        val porcentaje = when (idBarra) {
            R.id.rbH1, R.id.rbV1 -> 20
            R.id.rbV2 -> 35
            R.id.rbH2, R.id.rbV3 -> 50
            R.id.rbV4 -> 65
            R.id.rbH3, R.id.rbV5 -> 80
            else -> 80
        }

        return when (idColor) {
            R.id.rbBlanco -> when (porcentaje) {
                20 -> R.color.blanco_20
                35 -> R.color.blanco_35
                50 -> R.color.blanco_50
                65 -> R.color.blanco_65
                else -> R.color.blanco_80
            }
            R.id.rbRojo -> when (porcentaje) {
                20 -> R.color.rojo_20
                35 -> R.color.rojo_35
                50 -> R.color.rojo_50
                65 -> R.color.rojo_65
                else -> R.color.rojo_80
            }
            R.id.rbNaranja -> when (porcentaje) {
                20 -> R.color.naranja_20
                35 -> R.color.naranja_35
                50 -> R.color.naranja_50
                65 -> R.color.naranja_65
                else -> R.color.naranja_80
            }
            R.id.rbAmarillo -> when (porcentaje) {
                20 -> R.color.amarillo_20
                35 -> R.color.amarillo_35
                50 -> R.color.amarillo_50
                65 -> R.color.amarillo_65
                else -> R.color.amarillo_80
            }
            R.id.rbVerde -> when (porcentaje) {
                20 -> R.color.verde_20
                35 -> R.color.verde_35
                50 -> R.color.verde_50
                65 -> R.color.verde_65
                else -> R.color.verde_80
            }
            R.id.rbCian -> when (porcentaje) {
                20 -> R.color.cian_20
                35 -> R.color.cian_35
                50 -> R.color.cian_50
                65 -> R.color.cian_65
                else -> R.color.cian_80
            }
            R.id.rbAzul -> when (porcentaje) {
                20 -> R.color.azul_20
                35 -> R.color.azul_35
                50 -> R.color.azul_50
                65 -> R.color.azul_65
                else -> R.color.azul_80
            }
            R.id.rbVioleta -> when (porcentaje) {
                20 -> R.color.violeta_20
                35 -> R.color.violeta_35
                50 -> R.color.violeta_50
                65 -> R.color.violeta_65
                else -> R.color.violeta_80
            }
            R.id.rbNegro -> when (porcentaje) {
                20 -> R.color.negro_20
                35 -> R.color.negro_35
                50 -> R.color.negro_50
                65 -> R.color.negro_65
                else -> R.color.negro_80
            }
            else -> R.color.blanco_80
        }
    }
}