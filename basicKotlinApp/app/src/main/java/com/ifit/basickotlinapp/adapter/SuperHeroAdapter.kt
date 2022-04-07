package com.ifit.basickotlinapp.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ifit.basickotlinapp.R
import com.ifit.basickotlinapp.SuperHero

class SuperHeroAdapter(private val superheroList: List<SuperHero>) : RecyclerView.Adapter<SuperHeroViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SuperHeroViewHolder {

        val layoutInflater = LayoutInflater.from(parent.context)
        return SuperHeroViewHolder(layoutInflater.inflate(R.layout.item_superhero, parent, false))
    }

    override fun onBindViewHolder(holder: SuperHeroViewHolder, position: Int) {
        holder.render(superheroList[position])
    }

    override fun getItemCount(): Int {
        return superheroList.size
    }

}