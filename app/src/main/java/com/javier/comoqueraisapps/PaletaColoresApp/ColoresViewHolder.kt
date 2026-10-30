package com.javier.comoqueraisapps.PaletaColoresApp

import android.view.View
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import androidx.core.content.ContextCompat.getColor
import androidx.recyclerview.widget.RecyclerView
import com.javier.comoqueraisapps.BoardGamesApp.GameCategory
import com.javier.comoqueraisapps.R

class ColoresViewHolder (view: View): RecyclerView.ViewHolder(view){
    private val tvColor: TextView = view.findViewById(R.id.tvColor)

    fun pintarViews(color: Color){
        //tvColor.text = color.text
        //tvColor.setTextColor(color.colorTexto)
    }

}