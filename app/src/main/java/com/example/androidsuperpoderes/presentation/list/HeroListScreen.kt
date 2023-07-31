import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.androidsuperpoderes.domain.TestDataBuilder
import com.example.androidsuperpoderes.presentation.list.HeroListState
import com.example.androidsuperpoderes.presentation.list.HeroListViewModel
import org.koin.androidx.compose.koinViewModel

@Composable
fun HeroListScreen(
    superHeroListViewModel: HeroListViewModel = koinViewModel(),
    onItemClick: (String) -> Unit
) {
    val heroListState = superHeroListViewModel.heroListFlow.collectAsStateWithLifecycle()
    val errorState = superHeroListViewModel.error.observeAsState()

    //superHeroListViewModel.getData()

    if(errorState.value?.isNotEmpty() ==true){
        val error =errorState.value
        Box(modifier = Modifier.fillMaxSize()){
            Text(text = error ?: "")
        }
    }

    when(heroListState.value){
        is HeroListState.Idlestate -> {}
        is HeroListState.Loading -> {
            //A;adimos Loading
        }
        is HeroListState.ListHero -> {
            LazyColumn(horizontalAlignment = Alignment.CenterHorizontally) {
                val heroList = (heroListState.value as HeroListState.ListHero).listHero
                items(heroList?.size ?: 0) {i ->

                    heroList?.get(i)?.let { hero ->
                        ShowHero(hero = hero, descripVisibility = false) {
                            onItemClick.invoke(hero.id)
                        }
                    }
                }
            }
        }

    }


}
