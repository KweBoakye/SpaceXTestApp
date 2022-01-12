package com.kweboakye.spacextestapp.shared.domain.model

sealed class ResultOrError<T> {
    data class Success<T>(val value: T) : ResultOrError<T>()
    data class Failure<T>(val errors: List<Exception>) : ResultOrError<T>() {

        constructor(error: Exception) : this(listOf(error))
    }
}

fun <T, R> ResultOrError.Failure<T>.toFailure(): ResultOrError.Failure<R> {
    return ResultOrError.Failure(errors)
}

fun <T> Exception.toResultOrErrorFailure(): ResultOrError.Failure<T> {
    return ResultOrError.Failure(this)
}

fun <T> List<Exception>.toResultOrErrorFailure(): ResultOrError<T> {
    return ResultOrError.Failure(this)
}

fun <T> T.toResultOrErrorSuccess(): ResultOrError.Success<T> {
    return ResultOrError.Success(this)
}

fun <T> List<T>.toResultOrErrorSuccess(): ResultOrError.Success<List<T>> {
    return ResultOrError.Success(this)
}
