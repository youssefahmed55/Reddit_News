package com.example.redditnews.ui.kotlinNews

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class KotlinNewsViewModel @Inject constructor(private val kotlinNewsRepo: KotlinNewsRepo) : ViewModel() {

    private val _mutableStateFlowNews = MutableStateFlow<KotlinNewsViewStates>(KotlinNewsViewStates.Loading)
    val states : StateFlow<KotlinNewsViewStates> get() = _mutableStateFlowNews

    val mutableStateFlowIsRefreshing = MutableStateFlow(false)

    private val handler = CoroutineExceptionHandler { _, throwable -> _mutableStateFlowNews.value = KotlinNewsViewStates.Error(throwable.message!!) }

    init {
       getNewsItems()
    }

    private fun getNewsItems(){
        viewModelScope.launch(handler) {
                kotlinNewsRepo.insertNewsToDataBase(kotlinNewsRepo.getNewsListData())
                _mutableStateFlowNews.value = KotlinNewsViewStates.Success(kotlinNewsRepo.getNewsFromDataBase())
        }
    }

    fun getNewsFromDataBase(){
        viewModelScope.launch(handler) {
            _mutableStateFlowNews.value = KotlinNewsViewStates.Success(kotlinNewsRepo.getNewsFromDataBase())
        }
    }

    fun onRefresh(){
        mutableStateFlowIsRefreshing.value = true
        getNewsItems()
        mutableStateFlowIsRefreshing.value = false
    }

}