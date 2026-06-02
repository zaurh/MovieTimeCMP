//package com.zaurh.movieappintern2.presentation.tv.components
//
//import androidx.compose.foundation.layout.aspectRatio
//import androidx.compose.foundation.layout.fillMaxWidth
//import androidx.compose.foundation.layout.padding
//import androidx.compose.foundation.shape.RoundedCornerShape
//import androidx.compose.runtime.Composable
//import androidx.compose.runtime.getValue
//import androidx.compose.runtime.mutableStateOf
//import androidx.compose.runtime.remember
//import androidx.compose.runtime.setValue
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.draw.clip
//import androidx.compose.ui.unit.dp
//import androidx.compose.ui.viewinterop.AndroidView
//import androidx.lifecycle.compose.LocalLifecycleOwner
//import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer
//import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener
//import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView
//
//@Composable
//fun TvTrailer(trailerVideoKey: String) {
//    if (trailerVideoKey.isEmpty()) return
//    val lifecycleOwner = LocalLifecycleOwner.current
//
//    var youTubePlayer: YouTubePlayer? by remember { mutableStateOf(null) }
//
//    AndroidView(
//        factory = { context ->
//            YouTubePlayerView(context).apply {
//                lifecycleOwner.lifecycle.addObserver(this)
//
//                addYouTubePlayerListener(object : AbstractYouTubePlayerListener() {
//                    override fun onReady(player: YouTubePlayer) {
//                        youTubePlayer = player
//
//                        if (trailerVideoKey.isNotBlank()) {
//                            player.cueVideo(trailerVideoKey, 0f)
//                        }
//                    }
//                })
//            }
//        },
//        update = {
//            if (trailerVideoKey.isNotBlank()) {
//                youTubePlayer?.cueVideo(trailerVideoKey, 0f)
//            }
//        },
//        modifier = Modifier
//            .fillMaxWidth()
//            .padding(horizontal = 4.dp)
//            .aspectRatio(16f / 9f)
//            .clip(RoundedCornerShape(8.dp))
//    )
//}