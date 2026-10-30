package com.javier.comoqueraisapps.PaletaColoresApp

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.javier.comoqueraisapps.BoardGamesApp.CategoriesViewHolder
import com.javier.comoqueraisapps.BoardGamesApp.GameCategory
import com.javier.comoqueraisapps.R

class ColoresAdapter (private val colores: List<Color>):RecyclerView.Adapter<ColoresViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ColoresViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.color, parent, false)
        return ColoresViewHolder(view)
    }

    override fun onBindViewHolder(holder: ColoresViewHolder, position: Int) {
        holder.pintarViews(colores[position])
    }

    override fun getItemCount() = colores.size
}