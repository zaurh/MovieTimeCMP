package com.zaurh.movietimenew.di

import androidx.lifecycle.SavedStateHandle
import com.zaurh.movietimenew.data.repository.DiscoverRepoImpl
import com.zaurh.movietimenew.data.repository.GenreRepoImpl
import com.zaurh.movietimenew.data.repository.MovieRepoImpl
import com.zaurh.movietimenew.data.repository.SearchRepoImpl
import com.zaurh.movietimenew.data.service.DiscoverApi
import com.zaurh.movietimenew.data.service.GenreApi
import com.zaurh.movietimenew.data.service.MovieApi
import com.zaurh.movietimenew.data.service.SearchApi
import com.zaurh.movietimenew.domain.repository.DiscoverRepository
import com.zaurh.movietimenew.domain.repository.GenreRepository
import com.zaurh.movietimenew.domain.repository.MovieRepository
import com.zaurh.movietimenew.domain.repository.SearchRepository
import com.zaurh.movietimenew.presentation.details.MovieDetailsViewModel
import com.zaurh.movietimenew.presentation.discover.DiscoverViewModel
import com.zaurh.movietimenew.presentation.main.MainViewModel
import com.zaurh.movietimenew.presentation.search.SearchViewModel
import com.zaurh.movietimenew.util.Constants.API_KEY_V4
import io.ktor.client.HttpClient
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.defaultRequest
import io.ktor.client.request.header
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import org.koin.core.context.startKoin
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    single {
        HttpClient {
            install(ContentNegotiation) {
                json(
                    Json {
                        ignoreUnknownKeys = true
                        isLenient = true
                    }
                )
            }

            defaultRequest {
                url("https://api.themoviedb.org/3/")
                header("Authorization", "Bearer $API_KEY_V4")
                header("accept", "application/json")
            }
        }
    }

    single { MovieApi(get()) }
    single { GenreApi(get()) }
    single { DiscoverApi(get()) }
    single { SearchApi(get()) }

    single<MovieRepository> {
        MovieRepoImpl(get())
    }
    single<GenreRepository> {
        GenreRepoImpl(get())
    }
    single<DiscoverRepository> {
        DiscoverRepoImpl(get())
    }
    single<SearchRepository> {
        SearchRepoImpl(get())
    }

    single { MainViewModel(movieRepository = get(), genreRepository = get()) }

    single { SearchViewModel(get()) }

    viewModel { (handle: SavedStateHandle) ->
        MovieDetailsViewModel(get(), handle)
    }

    viewModel { (handle: SavedStateHandle) ->
        DiscoverViewModel(get(), handle)
    }
}


fun initKoin() {
    startKoin {
        modules(appModule)
    }
}