import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun TestList() {
    Box(modifier = Modifier
        .fillMaxSize()
        .background(Color.White)) {
        LazyColumn(horizontalAlignment = Alignment.CenterHorizontally) {
            item { Text(text = "SampleItem") }

            items(40) {
                Text(modifier = Modifier.height(30.dp), text = "Element $it")
            }
        }
    }
}

@Preview
@Composable
fun TestListPreview() {
    TestList()
}