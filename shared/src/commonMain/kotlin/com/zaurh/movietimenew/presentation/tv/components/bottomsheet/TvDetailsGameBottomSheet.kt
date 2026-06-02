package com.zaurh.movietimenew.presentation.tv.components.bottomsheet

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.zaurh.movietimenew.presentation.tv.TvDetailsAction
import com.zaurh.movietimenew.presentation.tv.TvDetailsUIState
import com.zaurh.movietimenew.util.getOutfitFont
import movietimenew.shared.generated.resources.Res
import movietimenew.shared.generated.resources.ic_eye_game
import movietimenew.shared.generated.resources.ic_pop_hair
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.painterResource

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TvDetailsGameBottomSheet(
    uiState: TvDetailsUIState,
    onAction: (TvDetailsAction) -> Unit = {}
) {
    if (uiState.gameBottomSheetEnabled) {
        ModalBottomSheet(
            onDismissRequest = {
                onAction(TvDetailsAction.OnGameBottomSheetDismissed)
            },
            content = {
                Column {
                    GameItem(
                        title = "Pop Eyes",
                        image = Res.drawable.ic_eye_game,
                        desc = "Find casts by their eyes"
                    ) {
//                        onAction(DetailsAction.OnGameModeClicked(FacePart.EYES.name))
                    }

                    GameItem(
                        title = "Pop Hair",
                        image = Res.drawable.ic_pop_hair,
                        desc = "Find casts by their hair"
                    ) {
//                        onAction(DetailsAction.OnGameModeClicked(FacePart.HAIR.name))
                    }
                }
            }
        )
    }
}

@Composable
private fun GameItem(
    image: DrawableResource,
    title: String,
    desc: String,
    onClicked: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable {
                onClicked()
            }
            .padding(16.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                modifier = Modifier
                    .clip(RoundedCornerShape(10.dp))
                    .background(Color.Blue),
                painter = painterResource(image),
                contentDescription = null,
                contentScale = ContentScale.Crop
            )
            Spacer(modifier = Modifier.width(8.dp))
            Column {
                Text(
                    text = title,
                    fontFamily = getOutfitFont(),
                    fontWeight = FontWeight.SemiBold,
                    color = MaterialTheme.colorScheme.primary
                )
                Text(text = desc, fontFamily = getOutfitFont(), color = Color.Gray)
            }
        }

//        Icon(
//            imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight,
//            contentDescription = null
//        )
    }
}