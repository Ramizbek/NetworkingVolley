package ramizbek.aliyev.networkingvolley.utils

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Build

fun isNetworkConnected(context: Context): Boolean {
    // SDK 23 >= shu ishledi bomasam if else
    val connectivityManager =
        context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager

     if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
        val activeNetwork = connectivityManager.activeNetwork

        val networkCapability = connectivityManager.getNetworkCapabilities(activeNetwork)
        return networkCapability != null && networkCapability.hasCapability(NetworkCapabilities.NET_CAPABILITY_INTERNET)

    } else {
        val connectInfo = connectivityManager.activeNetworkInfo

         return  connectInfo != null && connectInfo.isConnected
    }

}