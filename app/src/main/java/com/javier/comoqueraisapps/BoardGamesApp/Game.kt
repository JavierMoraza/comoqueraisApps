package com.javier.comoqueraisapps.BoardGamesApp

data class Game(val name: String, val categoria: GameCategory, var isSelected: Boolean =  true)
