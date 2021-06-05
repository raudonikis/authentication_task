package com.raudonikis.common

sealed class Result {
    object Success : Result()
    object Failure : Result()

    inline fun onSuccess(function: () -> Unit): Result {
        if (this is Success) {
            function()
        }
        return this
    }

    inline fun onFailure(function: () -> Unit): Result {
        if (this is Failure) {
            function()
        }
        return this
    }
}