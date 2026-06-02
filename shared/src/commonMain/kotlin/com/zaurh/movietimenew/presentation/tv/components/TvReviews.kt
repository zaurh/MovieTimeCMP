//package com.zaurh.movieappintern2.presentation.tv.components
//
//import androidx.compose.foundation.layout.fillMaxWidth
//import androidx.compose.foundation.layout.padding
//import androidx.compose.material3.MaterialTheme
//import androidx.compose.material3.Text
//import androidx.compose.runtime.Composable
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.text.style.TextAlign
//import androidx.compose.ui.unit.dp
//import com.zaurh.movieappintern2.data.models.firebase.reviews.ReviewData
//
//@Composable
//fun TvReviews(
//    reviews: List<ReviewData>,
//    errorMessage: String
//) {
//    if (errorMessage.isNotEmpty()){
//        Text(
//            modifier = Modifier.fillMaxWidth().padding(12.dp),
//            textAlign = TextAlign.Center,
//            text = errorMessage,
//            color = MaterialTheme.colorScheme.primary
//        )
//    }
//
//    reviews.forEach {
//        TvReviewItem(it)
//    }
//}