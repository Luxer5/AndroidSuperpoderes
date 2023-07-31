package com.example.androidsuperpoderes.presentation.detail

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.androidsuperpoderes.R
import com.example.androidsuperpoderes.domain.model.HeroModel
import com.example.androidsuperpoderes.domain.model.LocationModel
import com.example.androidsuperpoderes.domain.useCase.GetDetailUseCase
import com.example.androidsuperpoderes.domain.useCase.GetDistanceFromHeroUseCase
import com.example.androidsuperpoderes.domain.useCase.GetHeroLocationUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.koin.androidx.compose.get
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.FlexibleTypeDeserializer.ThrowException

class DetailViewModel(
    private val context: Context,
    private val getDetailUseCase: GetDetailUseCase,
    private val getHeroLocationUseCase: GetHeroLocationUseCase,
    private val getDistanceFromHeroUseCase: GetDistanceFromHeroUseCase
): ViewModel() {
    //private val hero = getDetailUseCase.invoke()



    private val _heroFlow = MutableStateFlow<HeroDetailState>(HeroDetailState.Idlestate)
    val heroFlow: StateFlow<HeroDetailState> = _heroFlow




    private var userLocation: LocationModel? = null
    private var heroLocation: LocationModel? = null

    private val _errorMessage = MutableLiveData<String?>()
    val error: LiveData<String?> get() =_errorMessage

    fun setUserLocation(lat: Double, long: Double){
        userLocation = LocationModel(
            latitud = lat,
            longitud = long
        )

    }



    fun getData(id:String){
        viewModelScope.launch {
            getHero(id)
            //getLocation(id)
        }
    }

    private fun getLocation(id: String) = viewModelScope.launch {
        try {
            val result = withContext(Dispatchers.IO){
                getHeroLocationUseCase.invoke(id)
            }
            heroLocation = result
        }catch (_: Throwable){} //Error silencioso
    }

    private fun getHero(id: String) = viewModelScope.launch {
            _heroFlow.value = HeroDetailState.Loading
            getDetailUseCase.invoke(id).collect{
                _heroFlow.value =  HeroDetailState.Hero(it)
            }
    }

}