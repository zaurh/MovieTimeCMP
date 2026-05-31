package com.zaurh.movietimenew.util

sealed class Result<T : Any> {
    class Success<T : Any>(val data: T) : Result<T>()
    class Error<T : Any>(
        val code: Int = 0,
        val message: String = ""
    ) : Result<T>()
}

suspend fun <T : Any> Result<T>.onSuccess(
    executable: suspend (T) -> Unit
): Result<T> = apply {
    if (this is Result.Success<T>) {
        executable(data)
    }
}

suspend fun <T : Any> Result<T>.onError(
    executable: suspend (code: Int, message: String) -> Unit
): Result<T> = apply {
    if (this is Result.Error) {
        executable(code, message)
    }
}

