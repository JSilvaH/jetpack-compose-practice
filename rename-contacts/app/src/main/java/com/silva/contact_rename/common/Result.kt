package com.silva.contact_rename.common

sealed class Result<T>(val data: T?, val message: String?= null){
    class Loading<T>(data: T?= null): Result<T>(data)
    class Success<T>(data: T?): Result<T>(data)
    class Error<T>(message: String? = null, data: T? = null): Result<T>(data, message)

}
