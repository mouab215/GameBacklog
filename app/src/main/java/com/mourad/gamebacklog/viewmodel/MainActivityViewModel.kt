package com.mourad.gamebacklog.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.mourad.gamebacklog.entity.Game
import com.mourad.gamebacklog.repository.GameRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivityViewModel(application: Application) : AndroidViewModel(application) {


    private val gameRepository = GameRepository(application.applicationContext)
    private val mainScope = CoroutineScope(Dispatchers.Main)

    val game = MutableLiveData<Game?>()
    val games = gameRepository.getAllGames()

    fun deleteGame() {
        mainScope.launch {
            withContext(Dispatchers.IO) {
                gameRepository.deleteGame(game.value!!)
            }
        }
    }

    fun deleteAllGames() {
        mainScope.launch {
            withContext(Dispatchers.IO) {
                gameRepository.deleteAllGames()
            }
        }
    }

}
