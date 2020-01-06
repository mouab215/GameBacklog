package com.mourad.notepad.ui

import android.app.Application
import android.provider.ContactsContract
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.mourad.gamebacklog.entity.Game
import com.mourad.gamebacklog.repository.GameRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class AddActivityViewModel(application: Application) : AndroidViewModel(application) {

    private val gameRepository = GameRepository(application.applicationContext)
    private val mainScope = CoroutineScope(Dispatchers.Main)

    val game = MutableLiveData<Game?>()
    val error = MutableLiveData<String?>()
    val success = MutableLiveData<Boolean>()

    fun insertGame() {
        if (isNoteValid()) {
            mainScope.launch {
                withContext(Dispatchers.IO) {
                    gameRepository.insertGame(game.value!!)
                }
                success.value = true
            }
        }
    }

    private fun isNoteValid(): Boolean {
        return when {
            game.value == null -> {
                error.value = "Game must not be null"
                false
            }
            game.value!!.title.isBlank() -> {
                error.value = "Title must not be empty"
                false
            }
            else -> true
        }
    }

}

