package com.yasinkacmaz.jetflix.ui.main.main

import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.compositionLocalOf
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navArgument
import com.yasinkacmaz.jetflix.ui.main.images.ImagesScreen
import com.yasinkacmaz.jetflix.ui.main.moviedetail.MovieDetailScreen
import com.yasinkacmaz.jetflix.ui.main.moviedetail.credits.Person
import com.yasinkacmaz.jetflix.ui.main.moviedetail.image.Image
import com.yasinkacmaz.jetflix.ui.main.moviedetail.person.PeopleGridScreen
import com.yasinkacmaz.jetflix.ui.main.movies.MoviesScreen
import com.yasinkacmaz.jetflix.ui.main.settings.SettingsContent
import com.yasinkacmaz.jetflix.ui.navigation.Route

val LocalNavController = compositionLocalOf<NavHostController> { error("No nav controller") }

@Composable
fun MainContent(
    isDarkTheme: MutableState<Boolean>,
    showSettingsDialog: MutableState<Boolean>
) {
    val navController = LocalNavController.current
    NavHost(navController, startDestination = Route.MOVIES.route) {
        composable(Route.MOVIES.route) { MoviesScreen(isDarkTheme, showSettingsDialog) }

        composable(
            route = "${Route.MOVIE_DETAIL.route}/{movieId}",
            arguments = listOf(navArgument("movieId") { type = NavType.IntType })
        ) { backStackEntry ->
            val movieId = backStackEntry.arguments!!.getInt("movieId")
            MovieDetailScreen(movieId)
        }

        composable(
            route = Route.IMAGES.route,
            arguments = listOf(navArgument("images") { type = NavType.ParcelableArrayType(Image::class.java) })
        ) { backStackEntry ->
            ImagesScreen(backStackEntry.arguments!!.getParcelableArrayList<Image>("images")!!.toList())
        }

        composable(
            route = "${Route.PEOPLE_GRID.route}/{people}",
            arguments = listOf(navArgument("people") { type = NavType.ParcelableArrayType(Person::class.java) })
        ) { backStackEntry ->
            PeopleGridScreen(backStackEntry.arguments!!.getParcelableArrayList<Person>("people")!!.toList())
        }
    }

    if (showSettingsDialog.value) {
        SettingsContent {
            showSettingsDialog.value = false
        }
    }
}
