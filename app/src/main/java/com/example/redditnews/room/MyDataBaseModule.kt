package com.example.redditnews.room

import android.app.Application
import androidx.room.Room
import com.example.redditnews.Constants.DATABASE_NAME
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object MyDataBaseModule {

    @Provides
    @Singleton
    @Synchronized
    fun provideDatabase(application: Application?): AppDatabase {
        return Room.databaseBuilder(application!!, AppDatabase::class.java, DATABASE_NAME)
            .fallbackToDestructiveMigration()
            .build()
    }

    @Provides
    @Singleton
    @Synchronized
    fun provideProductModelDao(myDatabase: AppDatabase): NewsDao {
        return myDatabase.newsDao()
    }

}