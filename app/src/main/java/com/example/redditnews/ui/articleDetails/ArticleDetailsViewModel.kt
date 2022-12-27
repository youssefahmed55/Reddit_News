package com.example.redditnews.ui.articleDetails

import androidx.lifecycle.*
import com.example.redditnews.Constants.DATA_OF_ARTICLE
import com.example.redditnews.pojo.Data
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ArticleDetailsViewModel @Inject constructor(savedStateHandle: SavedStateHandle) : ViewModel() {

    private val _mutableLiveDataArticleData = MutableLiveData<Data>()
    val articleData : LiveData<Data> get() = _mutableLiveDataArticleData

    init {
       val data = savedStateHandle.get<Data>(DATA_OF_ARTICLE)!!
        _mutableLiveDataArticleData.value = data
    }



}