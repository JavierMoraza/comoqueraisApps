package com.javier.comoqueraisapps.BoardGamesApp

import android.app.Dialog
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.javier.comoqueraisapps.R

class BoardGamesActivity : AppCompatActivity() {

    private val categories = listOf(GameCategory.Cooperative, GameCategory.LCG, GameCategory.Euro,
        GameCategory.Legacy, GameCategory.Deckbuilding)
    private val games = mutableListOf(
        Game("Frostpunk", GameCategory.Cooperative),
        Game("Hero Realm", GameCategory.Deckbuilding),
        Game("Agricola", GameCategory.Euro),
        Game("Arkham Horror", GameCategory.LCG),
        Game("Gloomhaven", GameCategory.Legacy))
    private lateinit var rvCategories: RecyclerView
    private lateinit var rvGames: RecyclerView
    private lateinit var categoriesAdapter: CategoriesAdapter
    private lateinit var gamesAdapter: GamesAdapter
    private lateinit var fabAddGame: FloatingActionButton

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
        initListeners()
    }
    private fun onGameSelected(position: Int) {
        games[position].isSelected = !games[position].isSelected
        updateGames()
    }
    private fun initUI() {
        categoriesAdapter = CategoriesAdapter(categories)
        rvCategories.layoutManager = LinearLayoutManager(this,
            LinearLayoutManager.HORIZONTAL,
            false)
        rvCategories.adapter = categoriesAdapter

        gamesAdapter = GamesAdapter(games) {position -> onGameSelected(position)}
        rvGames.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false)
        rvGames.adapter = gamesAdapter
    }

    private fun initComponents() {
        rvCategories = findViewById(R.id.rvCategories)
        rvGames = findViewById(R.id.rvGames)
        fabAddGame = findViewById(R.id.fabAddGame)
    }
    private fun initListeners() {
        fabAddGame.setOnClickListener{ showDialog() }
    }

    private fun showDialog() {
        val dialog = Dialog(this)
        dialog.setContentView(R.layout.dialog_game)

        val etGame: EditText = dialog.findViewById(R.id.etGame)
        val rgCategories: RadioGroup = dialog.findViewById(R.id.rgCategories)
        val btnAddGame: Button = dialog.findViewById(R.id.btnAddGame)

        btnAddGame.setOnClickListener {
            val currentGame = etGame.text.toString()
            if (currentGame.isNotEmpty()){
                val selectedId = rgCategories.checkedRadioButtonId
                val selectedRadioButton: RadioButton = rgCategories.findViewById(selectedId)
                val currentCategory: GameCategory = when(selectedRadioButton.text){
                    getString(R.string.bgapp_cooperative_category) -> GameCategory.Cooperative
                    getString(R.string.bgapp_deckbuilding_category) -> GameCategory.Deckbuilding
                    getString(R.string.bgapp_eurogames_category) -> GameCategory.Euro
                    getString(R.string.bgapp_lcg_category) -> GameCategory.LCG
                    else -> GameCategory.Legacy
                }
                games.add(Game(currentGame, currentCategory))
                updateGames()
                dialog.hide()
            }
        }
        dialog.show()
    }

    private fun updateGames(){
        gamesAdapter.notifyDataSetChanged()
    }
}