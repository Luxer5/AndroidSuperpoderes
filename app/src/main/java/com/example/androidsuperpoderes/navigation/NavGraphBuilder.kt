import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.androidsuperpoderes.navigation.Screen
import com.example.androidsuperpoderes.presentation.login.LoginScreen
import com.keepcoding.androidsuperpoderesprofe.presentation.detail.HeroDetailScreen

fun NavGraphBuilder.addLoginScreen(navController: NavController){
    composable(Screen.LoginScreen.route){
        LoginScreen( onLoginSuccess = {navController.navigate(Screen.HeroListScreen.route)}

        , onForgotPassword = {navController.navigate(Screen.ForgotPassWordScreen.route)})
    }
}

fun NavGraphBuilder.addForgotPasswordScreen(navController: NavController){
    composable(Screen.ForgotPassWordScreen.route){
        ForgotPasswordScreen()
    }
}

fun NavGraphBuilder.addHeroListScreen(navController: NavController){
    composable(Screen.HeroListScreen.route){
        HeroListScreen{heroId ->
            navController.navigate("${Screen.HeroDetailsScreen.route}/$heroId")
        }
    }
}
fun NavGraphBuilder.addHeroDetailScreen(){
    composable(
        route = Screen.HeroDetailsScreen.route + "/{heroId}",
        arguments = Screen.HeroDetailsScreen.arguments
    ){navBackStackEntry ->
        val id = navBackStackEntry.arguments?.getString("heroId") ?: ""
        HeroDetailScreen(id = id)


    }
}