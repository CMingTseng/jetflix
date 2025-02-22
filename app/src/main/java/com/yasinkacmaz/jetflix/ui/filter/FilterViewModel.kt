package com.yasinkacmaz.jetflix.ui.filter

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.yasinkacmaz.jetflix.service.MovieService
import com.yasinkacmaz.jetflix.ui.filter.genres.GenreUiModelMapper
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import javax.inject.Inject

@HiltViewModel
class FilterViewModel @Inject constructor(
    private val filterDataStore: FilterDataStore,
    private val movieService: MovieService,
    private val genreUiModelMapper: GenreUiModelMapper
) : ViewModel() {
    val filterState: StateFlow<FilterState> by lazy { buildFilterStateFlow() }

    private fun buildFilterStateFlow() = runBlocking {
        val genresAsync = async {
            try {
                movieService.fetchGenres().genres.map(genreUiModelMapper::map)
            } catch (exception: Exception) {
                emptyList()
            }
        }
        filterDataStore.filterState
            .combine(flowOf(genresAsync.await())) { filterState, genres ->
                filterState.copy(genres = genres)
            }
            .stateIn(viewModelScope)
    }

    fun onResetClicked() {
        viewModelScope.launch(Dispatchers.IO) {
            filterDataStore.resetFilterState()
        }
    }

    fun onFilterStateChanged(filterState: FilterState) {
        viewModelScope.launch(Dispatchers.IO) {
            filterDataStore.onFilterStateChanged(filterState)
        }
    }
}
