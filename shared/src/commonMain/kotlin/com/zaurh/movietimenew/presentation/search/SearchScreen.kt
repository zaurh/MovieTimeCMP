package com.zaurh.movietimenew.presentation.search

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import com.zaurh.movietimenew.presentation.search.component.SearchFilterItem
import com.zaurh.movietimenew.presentation.search.component.bottomsheet.SearchFilterBottomSheet
import com.zaurh.movietimenew.presentation.shared.PageSwitcher
import com.zaurh.movietimenew.presentation.shared.SearchBar
import com.zaurh.movietimenew.util.EMPTY
import org.koin.compose.koinInject

@Composable
fun SearchScreen(
    viewModel: SearchViewModel = koinInject(),
    navController: NavController
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()
//    val activity = LocalContext.current as? Activity
    val lazyState = rememberLazyListState()

    LaunchedEffect(Unit) {
        viewModel.sideEffect.collect { effect ->
            when (effect) {
                is SearchSideEffect.NavigateToDetailsScreen -> {
                    navController.navigate("details_screen/${effect.movieId}")
                }

                SearchSideEffect.ScrollToTop -> {
                    if (lazyState.layoutInfo.totalItemsCount > 0) {
                        lazyState.scrollToItem(0)
                    }
                }

                is SearchSideEffect.NavigateToPersonScreen -> {
                    navController.navigate("person_screen/${effect.personId}")
                }

                is SearchSideEffect.NavigateToTvScreen -> {
                    navController.navigate("tv_details_screen/${effect.seriesId}")
                }
            }
        }
    }

    SearchContent(
        uiState = uiState,
        onAction = viewModel::onAction,
        lazyState = lazyState
    )
}

@Composable
fun SearchContent(
    uiState: SearchUIState,
    onAction: (SearchAction) -> Unit = {},
    lazyState: LazyListState
) {
//    val context = LocalContext.current
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.surface),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            SearchBar(
                modifier = Modifier
                    .padding(start = 16.dp)
                    .weight(1f),
                query = uiState.searchQuery,
                onQueryChanged = { query ->
                    onAction(SearchAction.OnSearchQueryChanged(query))
                },
                label = "Search",
                onClearClicked = {
                    onAction(SearchAction.OnSearchQueryChanged(EMPTY))
                }
            )
            SearchFilterItem(onClick = {
                onAction(SearchAction.OnFilterClicked)
            })
        }

        if (uiState.message.isNotEmpty()) {
            Text(
                text = uiState.message,
                modifier = Modifier.padding(12.dp)
            )
        }
        if (uiState.pageSwitcherShown) {
            PageSwitcher(
                currentPage = uiState.page,
                totalPage = uiState.totalPages,
                onPreviousClick = {
                    onAction(SearchAction.OnPreviousPageClicked)
                },
                onNextClick = {
                    onAction(SearchAction.OnNextPageClicked)
                }
            )
        }
//        SearchList(
//            lazyState = lazyState,
//            multi = uiState.searchedMulti,
//            onMultiClick = { id, type ->
//                when (type) {
//                    SearchType.MOVIE.typeName -> onAction(SearchAction.OnMovieClicked(id))
//                    SearchType.PERSON.typeName -> onAction(SearchAction.OnPersonClicked(id))
//                    SearchType.TV.typeName -> onAction(SearchAction.OnTvClicked(id))
//                }
//            },
//            releaseDateShown = uiState.releaseDateShown,
//            trendingTextShown = uiState.trendingTextShown
//        )
    }

    SearchFilterBottomSheet(
        uiState = uiState,
        onAction = onAction
    )
}

@Preview
@Composable
private fun SearchPreview() {
//    fun getMulti(type: String): SearchMultiItem {
//        return SearchMultiItem(
//            title = "Shrek",
//            mediaType = type,
//            overview = "Shrek is green",
//            releaseDate = "2023"
//        )
//    }
//
//    SearchContent(
//        uiState = SearchUIState(
//            searchedMulti = listOf(
//                getMulti("movie"),
//                getMulti("tv"),
//                getMulti("person")
//            ),
//            totalPages = 10,
//            isLoading = true,
//            releaseDateShown = true,
//            pageSwitcherShown = true,
//            trendingTextShown = true
//        ),
//        lazyState = rememberLazyListState()
//    )
}