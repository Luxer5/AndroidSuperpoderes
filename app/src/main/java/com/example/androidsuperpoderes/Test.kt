import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun BaseComposable(
    content: @Composable () -> Unit
) {
    Column {
        content()
    }
}@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Box(
        modifier = modifier

    ) {
        Box(
            modifier = Modifier
                .background(Color.Green)
                .align(Alignment.CenterStart)
                .height(50.dp)
                .width(50.dp)
        ){
            Box(modifier = Modifier
                .background(Color.Green)
                .align(Alignment.CenterStart)
                .height(50.dp)
                .width(50.dp))
        }
    }

}