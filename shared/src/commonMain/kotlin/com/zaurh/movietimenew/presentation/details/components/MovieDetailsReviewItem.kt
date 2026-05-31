package com.zaurh.movietimenew.presentation.details.components

//@Composable
//fun MovieDetailsReviewItem(
//    reviewData: ReviewData
//) {
//    Row(
//        Modifier
//            .fillMaxWidth()
//            .background(Color.White.copy(0.1f)),
//        horizontalArrangement = Arrangement.SpaceBetween,
//        verticalAlignment = Alignment.CenterVertically
//    ) {
//        Column(
//            modifier = Modifier
//                .padding(8.dp)
//                .weight(8f)
//        ) {
//            Text(
//                text = reviewData.author?.username ?: stringResource(R.string.movie_details_unknown_user),
//                fontWeight = FontWeight.Bold,
//                color = MaterialTheme.colorScheme.primary, fontFamily = outfitFamily
//            )
//            var opinionIsExpanded by remember { mutableStateOf(false) }
//            Text(
//                text = reviewData.opinion.ifEmpty { stringResource(R.string.reviews_no_review) },
//                color = if (reviewData.opinion.isEmpty()) MaterialTheme.colorScheme.primary.copy(
//                    alpha = 0.5f
//                ) else MaterialTheme.colorScheme.primary,
//                maxLines = if (opinionIsExpanded) Int.MAX_VALUE else 3,
//                overflow = TextOverflow.Ellipsis,
//                modifier = Modifier.clickable {
//                    opinionIsExpanded = !opinionIsExpanded
//                }, fontFamily = outfitFamily
//            )
//            Text(
//                text = formatTimestamp(reviewData.timestamp),
//                color = MaterialTheme.colorScheme.primary.copy(alpha = 0.5f),
//                fontSize = 12.sp, fontFamily = outfitFamily
//            )
//        }
//        LikeDislikeThumbs(
//            modifier = Modifier.weight(2f),
//            reviewData = reviewData
//        )
//    }
//}