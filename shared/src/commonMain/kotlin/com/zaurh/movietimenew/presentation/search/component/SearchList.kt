package com.zaurh.movietimenew.presentation.search.component

//@Composable
//fun SearchList(
//    lazyState: LazyListState,
//    multi: List<SearchMultiItem>,
//    onMultiClick: (Long, String) -> Unit,
//    releaseDateShown: Boolean,
//    trendingTextShown: Boolean
//) {
//    LazyColumn(
//        modifier = Modifier.fillMaxWidth(),
//        state = lazyState,
//        contentPadding = PaddingValues(bottom = 64.dp)
//    ) {
//        item {
//            if (trendingTextShown) {
//                Text(
//                    text = stringResource(R.string.search_trending),
//                    fontFamily = outfitFamily,
//                    fontWeight = FontWeight.SemiBold,
//                    color = MaterialTheme.colorScheme.primary,
//                    modifier = Modifier.padding(12.dp),
//                    fontSize = 20.sp
//                )
//            }
//        }
//        items(multi) {
//            SearchItem(
//                multiItem = it,
//                onMultiClick = { id, type -> onMultiClick(id, type) },
//                releaseDateShown = releaseDateShown
//            )
//        }
//    }
//}
//
//@Composable
//private fun SearchItem(
//    multiItem: SearchMultiItem,
//    onMultiClick: (Long, String) -> Unit,
//    releaseDateShown: Boolean
//) {
//    Row(
//        modifier = Modifier
//            .fillMaxWidth()
//            .clickable { onMultiClick(multiItem.id, multiItem.mediaType) }
//            .padding(12.dp),
//        verticalAlignment = Alignment.CenterVertically
//    ) {
//        val imagePath = multiItem.posterPath.ifBlank { multiItem.profilePath }
//
//        AsyncImage(
//            modifier = Modifier
//                .size(100.dp)
//                .clip(RoundedCornerShape(10)),
//            model = imagePath.ifEmpty { EMPTY_IMAGE_URL },
//            contentDescription = null,
//            contentScale = ContentScale.Crop
//        )
//        Spacer(Modifier.size(8.dp))
//        Column {
//            val title = multiItem.title.ifBlank { multiItem.name }
//            val releaseDate = multiItem.releaseDate.take(4)
//            val releaseDateText = if (releaseDate.isNotEmpty()) "($releaseDate)" else EMPTY
//
//            val titleText = if (releaseDateShown) "$title $releaseDateText" else title
//            val typeColor = when (multiItem.mediaType) {
//                SearchType.MOVIE.typeName -> colorResource(R.color.movieType)
//                SearchType.PERSON.typeName -> colorResource(R.color.personType)
//                else -> colorResource(R.color.tvType)
//            }
//            val mediaTypeText = when (multiItem.mediaType) {
//                SearchType.MOVIE.typeName -> SearchType.MOVIE.displayNameRes
//                SearchType.PERSON.typeName -> SearchType.PERSON.displayNameRes
//                else -> SearchType.TV.displayNameRes
//            }
//            val mediaTypeIcon = when (multiItem.mediaType) {
//                SearchType.MOVIE.typeName -> R.drawable.ic_movie
//                SearchType.PERSON.typeName -> R.drawable.ic_person
//                else -> R.drawable.ic_tv
//            }
//
//            Text(
//                text = titleText,
//                color = MaterialTheme.colorScheme.primary,
//                fontFamily = outfitFamily,
//                fontWeight = FontWeight.SemiBold
//            )
//            Row(
//                modifier = Modifier
//                    .clip(RoundedCornerShape(8.dp))
//                    .background(typeColor)
//                    .padding(horizontal = 4.dp),
//                verticalAlignment = Alignment.CenterVertically
//            ) {
//                Icon(
//                    painter = painterResource(mediaTypeIcon),
//                    contentDescription = null,
//                    tint = Color.White,
//                    modifier = Modifier.size(16.dp)
//                )
//                Spacer(Modifier.width(4.dp))
//                Text(
//                    text = stringResource(mediaTypeText),
//                    color = Color.White,
//                    fontFamily = outfitFamily,
//                    fontSize = 12.sp
//                )
//            }
//
//            if (multiItem.overview.isNotEmpty()) {
//                Spacer(Modifier.size(4.dp))
//                Text(
//                    text = multiItem.overview,
//                    maxLines = 3,
//                    overflow = TextOverflow.Ellipsis,
//                    color = MaterialTheme.colorScheme.primary.copy(alpha = 0.5f),
//                    fontFamily = outfitFamily
//                )
//            }
//        }
//    }
//}