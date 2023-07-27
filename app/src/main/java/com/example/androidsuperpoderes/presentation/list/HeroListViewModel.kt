package com.example.androidsuperpoderes.presentation.list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.androidsuperpoderes.domain.model.HeroModel
import com.example.androidsuperpoderes.domain.useCase.GetHeroListUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class HeroListViewModel (private val getHeroListUseCase: GetHeroListUseCase) : ViewModel(){
    val testString = "Test"

    private val _heroList = MutableLiveData<List<HeroModel>>()
    val heros: LiveData<List<HeroModel>> get() = _heroList

    private val _errorMessage = MutableLiveData<String>()
    val error: LiveData<String> get() = _errorMessage

    fun getData() {

        viewModelScope.launch {
            //Capturamos las excepciones
            try {
                val result = withContext(Dispatchers.IO) {
                    getHeroListUseCase.invoke()

                }
                _heroList.value = result
                _errorMessage.value = ""
            } catch (t: Throwable) {
                //para resolver un string necesito un contexto
            }

        }

    }
}