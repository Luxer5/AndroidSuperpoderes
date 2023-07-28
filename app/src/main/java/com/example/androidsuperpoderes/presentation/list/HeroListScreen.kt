import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.androidsuperpoderes.domain.TestDataBuilder
import com.example.androidsuperpoderes.presentation.list.HeroListViewModel
import org.koin.androidx.compose.koinViewModel

@Composable
fun HeroListScreen(
    superHeroListViewModel: HeroListViewModel = koinViewModel(),
    onItemClick: (String) -> Unit
) {
    val state = superHeroListViewModel.heroList.observeAsState()
    val errorState = superHeroListViewModel.error.observeAsState()

    //superHeroListViewModel.getData()

    if(errorState.value?.isNotEmpty() ==true){
        val error =errorState.value
        Box(modifier = Modifier.fillMaxSize()){
            Text(text = error ?: "")
        }
    }

    LazyColumn(horizontalAlignment = Alignment.CenterHorizontally) {
        val heroList = state.value
        items(heroList?.size ?: 0) {i ->

            heroList?.get(i)?.let { hero ->
                ShowHero(hero = hero, descripVisibility = false) {
                    onItemClick.invoke(hero.id)
                }
            }
        }
    }
}
