package com.ifit.basickotlinapp

class SuperHeroProvider {
    companion object {
        val superHeroList = listOf<SuperHero>(
            SuperHero("Spiderman", "Marvel", "Peter parker", "https://randomuser.me/api/portraits/women/86.jpg"),
            SuperHero("Batman", "No se", "No se2", "https://randomuser.me/api/portraits/women/81.jpg")
        )
    }
}