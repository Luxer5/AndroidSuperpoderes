import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.androidsuperpoderes.domain.TestDataBuilder
import com.example.androidsuperpoderes.presentation.list.HeroListViewModel
import org.koin.androidx.compose.koinViewModel

@Composable
fun HeroListScreen(
    superHeroListViewModel: HeroListViewModel = koinViewModel()
) {
    val list = TestDataBuilder().withPhotoUrl("https://depor.com/resizer/oPf-2Xij6G_oA4sfJ7Y5DGDQYhM=/580x330/smart/filters:format(jpeg):quality(75)/cloudfront-us-east-1.images.arcpublishing.com/elcomercio/DAYT2F5NUNB7VPAFKUPHNDXVQA.jpg")
        .buildList()

    LazyColumn(horizontalAlignment = Alignment.CenterHorizontally){
        items(list.size){ i ->
            ShowHero(list[i])
        }
    }
}
