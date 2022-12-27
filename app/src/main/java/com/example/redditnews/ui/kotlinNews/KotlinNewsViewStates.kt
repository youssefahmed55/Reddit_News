package com.example.redditnews.ui.kotlinNews

import com.example.redditnews.pojo.Data

sealed class KotlinNewsViewStates{
    object Loading : KotlinNewsViewStates()
    data class Success(val listOfItems : List<Data>?) : KotlinNewsViewStates()
    data class Error(val error : String) : KotlinNewsViewStates()
}
