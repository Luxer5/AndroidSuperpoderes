import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun Ejercicio1() {
    Box(
        modifier = Modifier
            .size(200.dp)
            .background(Color.Green)
    ) {
        Box(
            modifier = Modifier
                .background(Color.Red)
                .size(150.dp)
                .align(Alignment.Center)
        ) {
            Box(
                modifier = Modifier
                    .size(40.dp)
                    .background(Color.Blue)
                    .align(Alignment.CenterEnd)
            )
            Box(
                modifier = Modifier
                    .size(20.dp)
                    .background(Color.White)
                    .align(Alignment.TopStart)
            )
        }

        Box(
            modifier = Modifier
                .background(Color.Gray)
                .size(40.dp, 180.dp)
                .align(Alignment.Center)
        )

        Box(
            modifier = Modifier
                .background(Color.Black)
                .size(50.dp)
                .align(Alignment.BottomStart)
        )
    }
}