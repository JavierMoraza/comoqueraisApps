package com.javier.comoqueraisapps.SuperheroApp

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.javier.comoqueraisapps.R

class SuperheroAdapter (var superheroList: List<SuperheroItemResponse> = emptyList()): RecyclerView.Adapter<SuperheroViewHolder>(){
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): SuperheroViewHolder {
        return SuperheroViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_superhero))
    }

    override fun onBindViewHolder(holder: SuperheroViewHolder, position: Int) {
        holder.bind(superheroList[position])
    }

    override fun getItemCount() = superheroList.size
}