package com.example.vaxin

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Surface
import androidx.compose.ui.unit.dp
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.vaxin.ui.add_child.AddChildScreen
import com.example.vaxin.ui.show_detail.ShowDetailScreen
import com.example.vaxin.ui.show_schedule.ShowScheduleScreen
import com.example.vaxin.ui.theme.VaxinTheme
import com.example.vaxin.util.Routes
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            VaxinTheme {
                Surface(tonalElevation = 5.dp) {
                    val TAG = "MAIN_ACTIVITY"
                    val navContoller = rememberNavController()
                    NavHost(
                        navController = navContoller,
                        startDestination = Routes.ADD_CHILD_SCREEN
                    ) {
                        composable(route = Routes.ADD_CHILD_SCREEN) {
                            AddChildScreen(
                                onNavigate = { event ->
                                    Log.d(TAG, "Navigate to schedule screen.")
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
                            val childId =
                                backStackEntry.arguments?.getString("childId") ?: "Balakrishna"
                            ShowScheduleScreen(
                                childId = childId,
                                onNavigate = { event ->
                                    Log.d(TAG, "Navigate to details screen.")
                                    navContoller.navigate(event.route)
                                }
                            )
                        }
                        composable(
                            route = Routes.SHOW_DETAIL_SCREEN + "?vaccineId={vaccineId}",
                            arguments = listOf(
                                navArgument(name = "vaccineId") {
                                    type = NavType.StringType
                                    defaultValue = "Hepatitis B Vaccine (HepB)"
                                }
                            )
                        ) { backStackEntry ->
                            val vaccineId = backStackEntry.arguments?.getString("vaccineId")
                                ?: "Hepatitis B Vaccine (HepB)"
                            ShowDetailScreen()
                        }
                    }  // end NAVHOST
                }  // end SURFACE
            }  // emd VAXIN THEME
        }  // end SET CONTENT
    }  // end ON CREATE
}

