package com.raudonikis.common

sealed class Result<out T> {

    data class Success<out T>(val data: T) : Result<T>()
    data class Failure(val message: String? = null) : Result<Nothing>()
    object Loading : Result<Nothing>()

    inline fun onSuccess(function: (data: T) -> Unit): Result<T> {
        if (this is Success) {
            function(data)
        }
        return this
    }

    inline fun onFailure(function: () -> Unit): Result<T> {
        if (this is Failure) {
            function()
        }
        return this
    }
}