package com.example.weatherapp.data.network.util

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import retrofit2.HttpException
import java.io.IOException


suspend fun <T : Any> executeNetworkCall(context: Context, block: suspend () -> T): NetworkResponse<T> {
    if (!isInternetAvailable(context)) {
        return NetworkUnavailable
    }
    return try {
        val networkResult = block.invoke()
        NetworkResult(networkResult)
    } catch (e: IOException) {
        NetworkIOError
    } catch (e: HttpException) {
        NetworkHttpError(e.code())
    }
}

fun isInternetAvailable(context: Context): Boolean {
    val connectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as? ConnectivityManager
    val networkCapabilities = connectivityManager?.activeNetwork ?: return false
    val actNw = connectivityManager.getNetworkCapabilities(networkCapabilities) ?: return false
    return actNw.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) || actNw.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR)
}