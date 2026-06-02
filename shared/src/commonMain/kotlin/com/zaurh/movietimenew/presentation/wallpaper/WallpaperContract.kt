package com.zaurh.movietimenew.presentation.wallpaper

import com.zaurh.movietimenew.presentation.model.WallpaperUIModel
import com.zaurh.movietimenew.util.EMPTY

data class WallpaperUIState(
    val contentType: String = EMPTY,
    val images: List<WallpaperUIModel> = listOf(),
    val wallpaperSeen: Boolean? = null,
    val moreBottomSheetEnabled: Boolean = false,
    val imageType: ImageType = ImageType.POSTER,
    val isLoading: Boolean = false
)

sealed interface WallpaperAction {
    data object OnBackClicked : WallpaperAction
    data object OnDownloadClicked : WallpaperAction
    data object OnSetWallpaperClicked : WallpaperAction
    data object OnMoreClicked : WallpaperAction
    data object OnMoreBottomSheetDismissed : WallpaperAction
    data class OnImageTypeChanged(val imageType: ImageType) : WallpaperAction
    data object OnWallpaperSeen: WallpaperAction
}

sealed interface WallpaperSideEffect {
    data object NavigateBack : WallpaperSideEffect
    data object DownloadImage: WallpaperSideEffect
    data object SetAsWallpaper : WallpaperSideEffect
}

enum class ContentType {
    TV, MOVIE, PERSON
}

enum class ImageType(val displayName: String) {
    POSTER("Poster"),
    BACKDROP("Backdrop"),
    LOGO("Logo")
}