package com.yasinkacmaz.jetflix.ui.navigation

enum class Route(val route: String) {
    MOVIES("movies"),
    MOVIE_DETAIL("movie"),
    IMAGES("${MOVIE_DETAIL.route}/images"),
    PEOPLE_GRID("peopleGrid")
}
