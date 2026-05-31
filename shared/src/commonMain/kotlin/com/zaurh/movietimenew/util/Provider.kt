package com.zaurh.movietimenew.util

//import android.net.Uri
//import com.zaurh.movieappintern2.R

//object Provider {
//    fun buildProviderUrl(providerId: Int, movieTitle: String): String {
//        val encodedTitle = Uri.encode(movieTitle)
//
//        return when (providerId) {
//
//            8 -> { // Netflix
//                "https://www.netflix.com/search?q=$encodedTitle"
//            }
//
//            119 -> { // Amazon Prime Video
//                "https://www.primevideo.com/search/ref=atv_nb_sr?phrase=$encodedTitle"
//            }
//
//            192 -> { // YouTube
//                "https://www.youtube.com/results?search_query=$encodedTitle"
//            }
//
//            2 -> { // Apple TV
//                "https://tv.apple.com/search?term=$encodedTitle"
//            }
//
//            3 -> { // Google Play Movies
//                "https://play.google.com/store/search?q=$encodedTitle&c=movies"
//            }
//
//            1899 -> { // HBO Max / Max
//                "https://play.max.com/search?q=$encodedTitle"
//            }
//
//            337 -> { // Disney Plus
//                "https://www.disneyplus.com/search/$encodedTitle"
//            }
//
//            531 -> { // Paramount Plus
//                "https://www.paramountplus.com/search/?q=$encodedTitle"
//            }
//
//            else -> EMPTY
//        }
//    }
//
//    fun getProviderLogo(providerId: Int): Int? {
//        return providerLogoMap[providerId]
//    }
//
//    private val providerLogoMap = mapOf(
//        8 to R.drawable.logo_netflix,
//        337 to R.drawable.logo_disney,
//        192 to R.drawable.logo_youtube,
//        1899 to R.drawable.logo_hbomax,
//        119 to R.drawable.logo_prime,
//        531 to R.drawable.logo_paramount
//    )
//}