package com.example.androidsuperpoderes.presentation.list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.androidsuperpoderes.domain.model.HeroModel
import com.example.androidsuperpoderes.domain.useCase.GetHeroListUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class HeroListViewModel (private val getHeroListUseCase: GetHeroListUseCase) : ViewModel(){
    val testString = "Test"

    private val _heroList = MutableLiveData<List<HeroModel>>()
    val heroList: LiveData<List<HeroModel>> get() = _heroList

    private val _heroListFlow = MutableStateFlow<HeroListState>(HeroListState.Idlestate)
    val heroListFlow : StateFlow<HeroListState> = _heroListFlow

    private val _errorMessage = MutableLiveData<String?>()
    val error: LiveData<String?> get() =_errorMessage

    val examples = FlowExamples()

    init {
        getData()
    }

    fun getData() {

        viewModelScope.launch {
            //Capturamos las excepciones
            //examples.exampleFold()
            try {
                _heroListFlow.value = HeroListState.Loading
                _errorMessage.value = null
                withContext(Dispatchers.IO) {
                    getHeroListUseCase.invoke().collect{ list ->
                        _heroListFlow.value = HeroListState.ListHero(list)
                    }

                }

            } catch (t: Throwable) {
                _errorMessage.value = "Seha priducido un error"
            }

        }

    }
}