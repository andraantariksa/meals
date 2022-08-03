package io.github.andraantariksa.meal.core.util

sealed class Resource<T> {
    class Success<T>(val data: T) : Resource<T>()
    class Loading<T> : Resource<T>()
    class Idle<T> : Resource<T>()
    class Error<T>(val error: Throwable) : Resource<T>()
}