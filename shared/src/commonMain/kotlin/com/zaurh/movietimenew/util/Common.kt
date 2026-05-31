package com.zaurh.movietimenew.util


import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight

import com.zaurh.movietimenew.util.Constants.IMAGE_URL
import movietimenew.shared.generated.resources.Res
import movietimenew.shared.generated.resources.outfit_bold
import movietimenew.shared.generated.resources.outfit_regular
import org.jetbrains.compose.resources.Font


fun time(runtime: Int): String {
    val hours = runtime / 60
    val minutes = runtime % 60
    return "${hours}h ${minutes}m"
}

//fun formatTimer(seconds: Int): String {
//    val minutes = seconds / 60
//    val remainingSeconds = seconds % 60
//    return "%02d:%02d".format(minutes, remainingSeconds)
//}

//fun formatTimestamp(timestamp: Timestamp): String {
//    val date = timestamp.toDate()
//    val formatter = SimpleDateFormat("HH:mm • MMM dd, yyyy", Locale.getDefault())
//    return formatter.format(date)
//}
//
//@RequiresApi(Build.VERSION_CODES.O)
//fun formatDate(input: String): String {
//    if (input.isEmpty()) return EMPTY
//    val inputFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd")
//    val outputFormatter = DateTimeFormatter.ofPattern("MMMM d yyyy", Locale.ENGLISH)
//
//    val date = LocalDate.parse(input, inputFormatter)
//    return date.format(outputFormatter)
//}

fun generateImagePath(path: String?): String {
    return if (path.isNullOrEmpty()) {
        EMPTY
    } else {
        "$IMAGE_URL/$path"
    }
}

fun Int?.orZero(): Int {
    return this ?: 0
}

fun Double?.orZero(): Double {
    return this ?: 0.0
}

fun Long?.orZero(): Long {
    return this ?: 0L
}

fun Boolean?.orFalse(): Boolean {
    return this ?: false
}

const val EMPTY = ""
const val ZERO = 0
const val ZERO_LONG = 0L
const val ZERO_DOUBLE = 0.0


@Composable
fun ToggleLoading(isLoading: Boolean) {
    if (isLoading) {
        Box(
            modifier = Modifier
                .fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            CircularProgressIndicator()
        }
    }
}

//@Parcelize
//sealed class UIText: Parcelable {
//    data class DynamicString(val value: String) : UIText()
//    data class StringResource(val resId: Int, val formatArgs: Array<CharSequence> = emptyArray()) : UIText()
//
//    fun asString(context: Context): String {
//        return when (this) {
//            is DynamicString -> value
//            is StringResource -> context.getString(resId, *formatArgs)
//        }
//    }
//}
//
//suspend fun Context.downloadImage(
//    imageUrl: String,
//    fileName: String = "movieTime_${System.currentTimeMillis()}.jpg"
//): Result<Unit> {
//    return try {
//        val loader = ImageLoader(this)
//
//        val request = ImageRequest.Builder(this)
//            .data(imageUrl)
//            .allowHardware(false)
//            .build()
//
//        val result = loader.execute(request)
//
//        val bitmap = (result.drawable as BitmapDrawable).bitmap
//
//        val values = ContentValues().apply {
//            put(MediaStore.Images.Media.DISPLAY_NAME, fileName)
//            put(MediaStore.Images.Media.MIME_TYPE, "image/jpeg")
//            put(
//                MediaStore.Images.Media.RELATIVE_PATH,
//                Environment.DIRECTORY_PICTURES
//            )
//        }
//
//        val uri = contentResolver.insert(
//            MediaStore.Images.Media.EXTERNAL_CONTENT_URI,
//            values
//        ) ?: throw Exception("Failed to create media store entry")
//
//        contentResolver.openOutputStream(uri)?.use { output ->
//            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, output)
//        }
//
//        Result.Success(Unit)
//
//    } catch (e: Exception) {
//        e.printStackTrace()
//        Result.Error(message = e.message ?: "Unknown error occurred")
//    }
//}
//
//suspend fun Context.setWallpaper(
//    imageUrl: String
//): Result<Unit> {
//    return try {
//
//        val loader = ImageLoader(this)
//
//        val request = ImageRequest.Builder(this)
//            .data(imageUrl)
//            .allowHardware(false)
//            .build()
//
//        val result = loader.execute(request)
//
//        val bitmap = (result.drawable as BitmapDrawable).bitmap
//
//        val wallpaperManager = WallpaperManager.getInstance(this)
//
//        wallpaperManager.setBitmap(bitmap)
//
//        Result.Success(Unit)
//
//    } catch (e: Exception) {
//
//        e.printStackTrace()
//
//        Result.Error(message = e.localizedMessage.orEmpty())
//    }
//}

@Composable
fun getOutfitFont(): FontFamily {
    return FontFamily(
        Font(
            resource = Res.font.outfit_regular,
            weight = FontWeight.Normal
        ),
        Font(
            resource = Res.font.outfit_bold,
            weight = FontWeight.Bold
        )
    )
}