package com.ifit.basickotlinapp.adapter

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.ifit.basickotlinapp.R
import com.ifit.basickotlinapp.SuperHero

class SuperHeroViewHolder(view: View): RecyclerView.ViewHolder(view) {
    val superHero = view.findViewById<TextView>(R.id.tvSuperHeroName)
    val realName = view.findViewById<TextView>(R.id.tvPublisher)
    val photo = view.findViewById<ImageView>(R.id.ivSuperhero)

    fun render(superHeroModel: SuperHero){
        superHero.text = superHeroModel.superhero
        realName.text = superHeroModel.realName
        Glide.with(photo.context).load(superHeroModel.photo).into(photo)
    }
}