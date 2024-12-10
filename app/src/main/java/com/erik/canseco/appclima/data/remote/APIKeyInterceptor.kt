package com.erik.canseco.appclima.data.remote

import com.erik.canseco.appclima.util.Constant.API_KEY
import com.erik.canseco.appclima.util.Constant.CNT
import com.erik.canseco.appclima.util.Constant.LANG
import com.erik.canseco.appclima.util.Constant.UNITS
import okhttp3.Interceptor
import okhttp3.Response

class APIKeyInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val originalRequest = chain.request()
        val newUrl = originalRequest.url.newBuilder()
            .addQueryParameter("appid", API_KEY)
            .addQueryParameter("units", UNITS)
            .addQueryParameter("lang", LANG)
            .addQueryParameter("cnt", CNT )
        val currentRequest = originalRequest.newBuilder()
        val newRequest = currentRequest.url(newUrl.build()).build()
        return chain.proceed(newRequest)
    }

}