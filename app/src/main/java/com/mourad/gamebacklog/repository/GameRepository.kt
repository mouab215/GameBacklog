package com.mourad.gamebacklog.repository

import android.content.Context
import androidx.lifecycle.LiveData
import com.mourad.gamebacklog.dao.GameDao
import com.mourad.gamebacklog.entity.Game
import com.mourad.gamebacklog.room.GameRoomDatabase

class GameRepository(context: Context) {

    private var gameDao: GameDao

    init {
        val gameRoomDatabase= GameRoomDatabase.getDatabase(context)
        gameDao = gameRoomDatabase!!.gameDao()
    }

    fun getAllGames(): LiveData<List<Game>> {
        return gameDao.getAllGames()
    }

    fun insertGame(game: Game) {
        gameDao.insertGame(game)
    }

    fun deleteGame(game: Game) {
        gameDao.deleteGame(game)
    }

    fun deleteAllGames() {
        gameDao.deleteAllGames()
    }

    fun updateGame(game: Game) {
        gameDao.updateGame(game)
    }

}
