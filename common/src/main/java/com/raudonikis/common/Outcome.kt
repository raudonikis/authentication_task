package com.raudonikis.common

/**
 * Wrapper for mapping function response state
 * Usage:
 * Returning response state ->
 *
 * if(failed) {
 *  return Outcome.Failure("message")
 * }
 * if(success) {
 *  return Outcome.Success(data)
 * }
 *
 * Handling response state ->
 *
 * outcome
 *  .onSuccess { data ->
 *      //handle success
 *  }
 *  .onFailure { message ->
 *      //handle failure
 *  }
 */
sealed class Outcome<out T> {

    data class Success<out T>(val data: T) : Outcome<T>()
    data class Failure(val message: String? = null) : Outcome<Nothing>()
    object Loading : Outcome<Nothing>()

    inline fun onSuccess(function: (data: T) -> Unit): Outcome<T> {
        if (this is Success) {
            function(data)
        }
        return this
    }

    inline fun onFailure(function: () -> Unit): Outcome<T> {
        if (this is Failure) {
            function()
        }
        return this
    }
}