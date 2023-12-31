import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androidsuperpoderes.R

@Composable
fun TestImage() {
    Image(
        painter = painterResource(id = R.drawable.ball),
        modifier = Modifier
            .clip(CircleShape)
            .background(Color.Gray)
            .border(BorderStroke(2.dp, Color.White), shape = CircleShape),
        contentDescription = ""
    )
}

@Preview
@Composable
fun TestImagePreview() {
    TestImage()
}