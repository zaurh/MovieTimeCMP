package com.zaurh.movietimenew.presentation.details.components

//@Composable
//fun Trailer(trailerVideoKey: String) {
//    if (trailerVideoKey.isEmpty()) return
//
//    val context = LocalContext.current
//    val lifecycleOwner = LocalLifecycleOwner.current
//
//    var youTubePlayer by remember {
//        mutableStateOf<YouTubePlayer?>(null)
//    }
//
//    val youtubePlayerView = remember {
//        YouTubePlayerView(context).apply {
//            lifecycleOwner.lifecycle.addObserver(this)
//
//            addYouTubePlayerListener(object : AbstractYouTubePlayerListener() {
//
//                override fun onReady(player: YouTubePlayer) {
//                    youTubePlayer = player
//                    player.cueVideo(trailerVideoKey, 0f)
//                }
//            })
//        }
//    }
//
//    DisposableEffect(youtubePlayerView) {
//        onDispose {
//            lifecycleOwner.lifecycle.removeObserver(youtubePlayerView)
//            youtubePlayerView.release()
//        }
//    }
//
//    LaunchedEffect(trailerVideoKey) {
//        youTubePlayer?.cueVideo(trailerVideoKey, 0f)
//    }
//
//    AndroidView(
//        factory = {
//            youtubePlayerView
//        },
//        modifier = Modifier
//            .fillMaxWidth()
//            .padding(horizontal = 4.dp)
//            .aspectRatio(16f / 9f)
//            .clip(RoundedCornerShape(8.dp))
//    )
//}