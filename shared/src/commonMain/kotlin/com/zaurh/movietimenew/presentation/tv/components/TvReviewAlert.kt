//package com.zaurh.movieappintern2.presentation.tv.components
//
//import androidx.compose.foundation.layout.Arrangement
//import androidx.compose.foundation.layout.Column
//import androidx.compose.foundation.layout.Row
//import androidx.compose.foundation.layout.Spacer
//import androidx.compose.foundation.layout.fillMaxWidth
//import androidx.compose.foundation.layout.padding
//import androidx.compose.foundation.layout.size
//import androidx.compose.foundation.layout.width
//import androidx.compose.foundation.shape.RoundedCornerShape
//import androidx.compose.material3.AlertDialog
//import androidx.compose.material3.Button
//import androidx.compose.material3.ButtonDefaults
//import androidx.compose.material3.Icon
//import androidx.compose.material3.IconButton
//import androidx.compose.material3.IconButtonDefaults
//import androidx.compose.material3.MaterialTheme
//import androidx.compose.material3.Text
//import androidx.compose.material3.TextField
//import androidx.compose.material3.TextFieldDefaults
//import androidx.compose.runtime.Composable
//import androidx.compose.ui.Alignment
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.draw.clip
//import androidx.compose.ui.graphics.Color
//import androidx.compose.ui.res.painterResource
//import androidx.compose.ui.res.stringResource
//import androidx.compose.ui.unit.dp
//import com.zaurh.movieappintern2.R
//import com.zaurh.movieappintern2.data.models.firebase.reviews.Rate
//
//@Composable
//fun TvReviewAlert(
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
//                Text(text = stringResource(R.string.movie_details_rate_movie), color = MaterialTheme.colorScheme.primary)
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
//                                color = MaterialTheme.colorScheme.primary.copy(0.5f)
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
//                    enabled = !isLoading && (reviewValue.isNotEmpty() || rate != Rate.NONE),
//                    colors = ButtonDefaults.buttonColors(
//                        containerColor = MaterialTheme.colorScheme.background
//                    ), onClick = {
//                        onSend()
//                    }) {
//                    Text(
//                        text = if (isLoading) stringResource(R.string.movie_details_sending) else stringResource(
//                            R.string.movie_details_send_review
//                        ),
//                        color = MaterialTheme.colorScheme.primary
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
//                    Text(text = stringResource(R.string.movie_details_cancel), color = MaterialTheme.colorScheme.primary)
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
//        Text(text = stringResource(rate.displayNameRes), color = MaterialTheme.colorScheme.primary)
//    }
//
//}
