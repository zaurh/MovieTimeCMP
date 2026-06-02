package com.zaurh.movietimenew.presentation.wallpaper.bottomsheet

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.zaurh.movietimenew.presentation.wallpaper.ContentType
import com.zaurh.movietimenew.presentation.wallpaper.ImageType
import com.zaurh.movietimenew.presentation.wallpaper.WallpaperAction
import com.zaurh.movietimenew.presentation.wallpaper.WallpaperUIState
import com.zaurh.movietimenew.ui.theme.MovieTimeTheme
import com.zaurh.movietimenew.util.getOutfitFont

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun WallpaperMoreBottomSheet(
    uiState: WallpaperUIState,
    onAction: (WallpaperAction) -> Unit = {}
) {
    if (uiState.moreBottomSheetEnabled) {
        ModalBottomSheet(
            onDismissRequest = {
                onAction(WallpaperAction.OnMoreBottomSheetDismissed)
            },
            content = {
                Column {
                    if (uiState.contentType != ContentType.PERSON.name){
                        Text(
                            modifier = Modifier.padding(start = 16.dp),
                            text = "Content",
                            fontFamily = getOutfitFont(),
                            fontWeight = FontWeight.SemiBold
                        )
                        Spacer(modifier = Modifier.height(8.dp))
                        LazyRow(
                            contentPadding = PaddingValues(horizontal = 8.dp)
                        ) {
                            items(ImageType.entries) {
                                Button(
                                    modifier = Modifier.padding(horizontal = 4.dp),
                                    onClick = {
                                        onAction(WallpaperAction.OnImageTypeChanged(it))
                                    },
                                    colors = ButtonDefaults.buttonColors(
                                        containerColor = if (it == uiState.imageType)
                                            MaterialTheme.colorScheme.surface else MaterialTheme.colorScheme.background,
                                    )
                                ) {
                                    Text(
                                        text = it.displayName,
                                        color = MaterialTheme.colorScheme.primary,
                                        fontFamily = getOutfitFont()
                                    )
                                }
                            }
                        }
                        Spacer(modifier = Modifier.height(16.dp))
                    }

                    Button(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 8.dp),
                        onClick = {
                            onAction(WallpaperAction.OnSetWallpaperClicked)
                        },
                        colors = ButtonDefaults.buttonColors(
                            containerColor = MaterialTheme.colorScheme.background,
                        )
                    ) {
                        Text(
                            text = "Set as a wallpaper",
                            fontFamily = getOutfitFont(),
                            color = MaterialTheme.colorScheme.primary
                        )
                    }
                    Spacer(modifier = Modifier.height(24.dp))
                }
            }
        )
    }
}

@Preview
@Composable
private fun WallpaperMoreBSPreview() {
    MovieTimeTheme(darkTheme = true) {
        WallpaperMoreBottomSheet(
            uiState = WallpaperUIState(
                moreBottomSheetEnabled = true
            )
        )
    }
}