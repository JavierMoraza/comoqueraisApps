package com.javier.comoqueraisapps.BoardGamesApp

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.javier.comoqueraisapps.R

class BoardGamesActivity : AppCompatActivity() {

    private val categories = listOf(GameCategory.Cooperative, GameCategory.LCG, GameCategory.Euro,
        GameCategory.Legacy, GameCategory.Deckbuilding)
    private val games = listOf(
        Game("Frostpunk", GameCategory.Cooperative),
        Game("Hero Realm", GameCategory.Deckbuilding),
        Game("Agricola", GameCategory.Euro),
        Game("Arkham Horror", GameCategory.LCG),
        Game("Gloomhaven", GameCategory.Legacy))
    private lateinit var rvCategories: RecyclerView
    private lateinit var rvGames: RecyclerView
    private lateinit var categoriesAdapter: CategoriesAdapter
    private lateinit var gamesAdapter: GamesAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_board_games)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        initComponents()
        initUI()
    }

    private fun initUI() {
        categoriesAdapter = CategoriesAdapter(categories)
        rvCategories.layoutManager = LinearLayoutManager(
            this,
            LinearLayoutManager.HORIZONTAL,
            false)
        rvCategories.adapter = categoriesAdapter
        //gamesAdapter = GamesAdapter(games)
    }

    private fun initComponents() {
        rvCategories = findViewById(R.id.rvCategories)
        rvGames = findViewById(R.id.rvGames)
    }

}