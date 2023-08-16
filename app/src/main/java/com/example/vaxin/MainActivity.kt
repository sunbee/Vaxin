package com.example.vaxin

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavArgument
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.vaxin.ui.add_child.AddChildScreen
import com.example.vaxin.ui.show_schedule.ShowScheduleScreen
import com.example.vaxin.ui.theme.VaxinTheme
import com.example.vaxin.util.Routes
import com.example.vaxin.util.UiEvent
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            VaxinTheme {
                val navContoller = rememberNavController()
                NavHost(
                    navController = navContoller,
                    startDestination = Routes.ADD_CHILD_SCREEN
                ) {
                    composable(route = Routes.ADD_CHILD_SCREEN) {
                        AddChildScreen(
                            onNavigate = { event ->
                                Log.d("REFACTOR", "Navigate to main display.")
                                navContoller.navigate(event.route)
                            }
                        )
                    }
                    composable(
                        route = Routes.SHOW_SCHEDULE_SCREEN + "?childId={childId}",
                        arguments = listOf(
                            navArgument(name = "childId") {
                                type = NavType.StringType
                                defaultValue = "Balakrishna"
                            }
                        )
                    ) { backStackEntry ->
                        val childId = backStackEntry.arguments?.getString("childId") ?: "Balakrishna"
                        ShowScheduleScreen(childId = childId)
                    }
                    composable(
                        route = Routes.SHOW_DETAIL_SCREEN + "?vaccineId={vaccineId}",
                        arguments = listOf(
                            navArgument(name = "vaccineId") {
                                type = NavType.StringType
                                defaultValue = "Hepatitis B Vaccine (HepB)"
                            }
                        )
                    ) {
                        TODO("ShowDetailScreen")
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    VaxinTheme {
        Greeting("Android")
    }
}