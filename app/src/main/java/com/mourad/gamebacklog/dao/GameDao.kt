package com.mourad.gamebacklog.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.mourad.gamebacklog.entity.Game

@Dao
interface GameDao {

    @Query("SELECT * FROM gameTable ORDER BY releaseDate ASC")
    fun getAllGames(): LiveData<List<Game>>

    @Insert
    fun insertGame(game: Game)

    @Delete
    fun deleteGame(game: Game)

    @Query("DELETE FROM gameTable")
    fun deleteAllGames()

    @Update
    fun updateGame(game: Game)

}
