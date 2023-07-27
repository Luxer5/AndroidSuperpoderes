import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.example.androidsuperpoderes.navigation.Screen

@Composable
fun NavigationGraph(){
    val navController = rememberNavController()

    NavHost( //FRagment container view
        navController = navController,
        startDestination = Screen.LoginScreen.route, //igual que el start Destination
    ){
        addLoginScreen(navController)
        addForgotPasswordScreen(navController)
        addHeroListScreen(navController)
    }
}