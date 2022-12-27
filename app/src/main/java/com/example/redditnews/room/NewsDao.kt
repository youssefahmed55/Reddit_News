package com.example.redditnews.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.redditnews.pojo.Data


@Dao
interface NewsDao {
    //Get List Of Data From DataBase
    @Query("SELECT * FROM newsTable")
    suspend fun getAllNews(): List<Data>

    //Insert List Of Data In DataBase
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllNews(listOfNews : List<Data>)

    //Delete All Data From Table
    @Query("DELETE FROM newsTable")
    suspend fun deleteAllNews()
}