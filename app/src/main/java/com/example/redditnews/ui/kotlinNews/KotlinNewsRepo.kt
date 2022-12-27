package com.example.redditnews.ui.kotlinNews

import com.example.redditnews.pojo.Data
import com.example.redditnews.restApi.NewsApiInterface
import com.example.redditnews.room.NewsDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class KotlinNewsRepo @Inject constructor(private val newsApiInterface: NewsApiInterface, private val newsDao: NewsDao) {
    //NetWork
    //Get List Of Data
    suspend fun getNewsListData() : List<Data> = withContext(Dispatchers.IO){
        val mutableList = mutableListOf<Data>()
        newsApiInterface.getNewsRequest().data?.children?.forEach {
            mutableList.add(it?.data!!)
        }
        return@withContext mutableList
    }

    //Room
    //Insert List Of Data To Room DataBase
    suspend fun insertNewsToDataBase(listOfNews : List<Data>) = withContext(Dispatchers.IO){
        newsDao.deleteAllNews()  //Delete All Data From Room DataBase
        newsDao.insertAllNews(listOfNews)
    }
    //Get List Of Data From Room DataBase
    suspend fun getNewsFromDataBase() : List<Data> = withContext(Dispatchers.IO){
        return@withContext newsDao.getAllNews()
    }

}