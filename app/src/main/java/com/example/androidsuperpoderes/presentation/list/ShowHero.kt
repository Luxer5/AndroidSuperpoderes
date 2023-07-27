import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.androidsuperpoderes.R
import com.example.androidsuperpoderes.domain.TestDataBuilder
import com.example.androidsuperpoderes.domain.model.HeroModel

//Ejercicio ostrar un Diseño de un Hero

@Composable
fun ShowHero(
    hero: HeroModel,
    onClick: (() -> Unit)? = null
) {
    Row(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth()
            .clickable { onClick?.invoke() }
    ) {
        AsyncImage(
            modifier = Modifier
                .size(100.dp)
                .clip(CircleShape),
            placeholder = painterResource(id = R.drawable.ball),
            error = painterResource(id = R.drawable.ball),
            model = ImageRequest.Builder(LocalContext.current)
                .data(hero.photoUrl)
                .build(),
            contentDescription = ""
        )
        Column(modifier =Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = hero.name, maxLines = 1, overflow = TextOverflow.Ellipsis)

            Text(text = hero.description, maxLines = 4, overflow = TextOverflow.Ellipsis)
        }
    }
}

@Preview
@Composable
fun ShowHeroPreview() {
    ShowHero(TestDataBuilder().buildSingle())
}