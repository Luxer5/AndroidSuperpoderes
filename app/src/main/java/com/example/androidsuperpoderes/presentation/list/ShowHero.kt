import android.text.BoringLayout
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.androidsuperpoderes.R
import com.example.androidsuperpoderes.componentes.StartComponent
import com.example.androidsuperpoderes.domain.TestDataBuilder
import com.example.androidsuperpoderes.domain.model.HeroModel

//Ejercicio ostrar un Diseño de un Hero

@Composable
fun ShowHero(
    hero: HeroModel,
    descripVisibility: Boolean = false,
    onClick: (() -> Unit)? = null
) {
    var starred by remember {
        mutableStateOf(false)
    }

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
        Row(modifier = Modifier.fillMaxWidth()) {
            Column(
                modifier = Modifier.weight(1f),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(text = hero.name, maxLines = 1, overflow = TextOverflow.Ellipsis)
                if (descripVisibility) {
                    Text(text = hero.description, maxLines = 4, overflow = TextOverflow.Ellipsis)
                }

            }
            AndroidView(modifier = Modifier.clickable {
                val newState = !starred
                starred = newState
            },
                factory = { context ->
                    StartComponent(context = context).apply {
                        checked = starred
                    }
                },
                update = {
                    it.checked = starred
                }
            )
        }
    }
}

@Preview
@Composable
fun ShowHeroPreview() {
    ShowHero(TestDataBuilder().buildSingle())
}