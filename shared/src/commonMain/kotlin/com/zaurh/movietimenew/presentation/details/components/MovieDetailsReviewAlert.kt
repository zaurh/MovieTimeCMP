package com.zaurh.movietimenew.presentation.details.components

//@Composable
//fun MovieDetailsReviewAlert(
//    enabled: Boolean,
//    isLoading: Boolean,
//    reviewValue: String,
//    rate: Rate,
//    onReviewValueChange: (String) -> Unit,
//    onDismiss: () -> Unit,
//    onSend: () -> Unit,
//    onThumbClick: (Rate) -> Unit
//) {
//    if (enabled) {
//        AlertDialog(
//            title = {
//                Text(
//                    text = stringResource(R.string.movie_details_rate_movie),
//                    color = MaterialTheme.colorScheme.primary,
//                    fontFamily = outfitFamily
//                )
//            },
//            text = {
//                Column {
//                    Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
//                        ThumbButton(
//                            rate = Rate.DISLIKE,
//                            icon = R.drawable.dislike_ic,
//                            selected = rate == Rate.DISLIKE,
//                            onClick = {
//                                onThumbClick(it)
//                            }
//                        )
//                        Spacer(Modifier.width(8.dp))
//                        ThumbButton(
//                            rate = Rate.LIKE,
//                            icon = R.drawable.like_ic,
//                            selected = rate == Rate.LIKE,
//                            onClick = {
//                                onThumbClick(it)
//                            }
//                        )
//                    }
//                    Spacer(Modifier.size(8.dp))
//                    TextField(
//                        modifier = Modifier.clip(RoundedCornerShape(20)),
//                        value = reviewValue,
//                        onValueChange = onReviewValueChange,
//                        colors = TextFieldDefaults.colors(
//                            unfocusedContainerColor = MaterialTheme.colorScheme.background,
//                            focusedContainerColor = MaterialTheme.colorScheme.background,
//                            focusedIndicatorColor = Color.Transparent,
//                            unfocusedIndicatorColor = Color.Transparent
//                        ),
//                        placeholder = {
//                            Text(
//                                text = stringResource(R.string.movie_details_write_review),
//                                color = MaterialTheme.colorScheme.primary.copy(0.5f),
//                                fontFamily = outfitFamily
//                            )
//                        },
//                        maxLines = 6
//                    )
//                }
//            },
//            onDismissRequest = {
//                onDismiss()
//            },
//            confirmButton = {
//                Button(
//                    enabled = !isLoading && (reviewValue.trim().isNotEmpty() || rate != Rate.NONE),
//                    colors = ButtonDefaults.buttonColors(
//                        containerColor = MaterialTheme.colorScheme.background
//                    ), onClick = {
//                        onSend()
//                    }) {
//                    Text(
//                        text = if (isLoading) stringResource(R.string.movie_details_sending) else stringResource(
//                            R.string.movie_details_send_review
//                        ),
//                        color = MaterialTheme.colorScheme.primary,
//                        fontFamily = outfitFamily
//                    )
//                }
//            },
//            dismissButton = {
//                Button(
//                    colors = ButtonDefaults.buttonColors(
//                        containerColor = MaterialTheme.colorScheme.background
//                    ), onClick = {
//                        onDismiss()
//                    }) {
//                    Text(
//                        text = stringResource(R.string.movie_details_cancel),
//                        color = MaterialTheme.colorScheme.primary,
//                        fontFamily = outfitFamily
//                    )
//                }
//            }
//        )
//    }
//
//}
//
//@Composable
//fun ThumbButton(
//    rate: Rate,
//    icon: Int,
//    selected: Boolean,
//    onClick: (Rate) -> Unit
//) {
//    Column(
//        horizontalAlignment = Alignment.CenterHorizontally
//    ) {
//        IconButton(
//            colors = IconButtonDefaults.iconButtonColors(
//                containerColor =
//                    if (selected && rate == Rate.LIKE) Color.Green.copy(0.5f)
//                    else if (selected && rate == Rate.DISLIKE) Color.Red.copy(alpha = 0.5f)
//                    else MaterialTheme.colorScheme.primary.copy(0.2f)
//            ),
//            onClick = {
//                onClick(rate)
//            }
//        ) {
//            Icon(
//                modifier = Modifier
//                    .size(42.dp)
//                    .padding(4.dp),
//                painter = painterResource(icon),
//                contentDescription = "",
//                tint = Color.White
//            )
//        }
//        Text(
//            text = stringResource(rate.displayNameRes),
//            color = MaterialTheme.colorScheme.primary,
//            fontFamily = outfitFamily
//        )
//    }
//}
