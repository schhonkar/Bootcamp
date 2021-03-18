package com.example.webservices.Q2.Retrofit

import com.example.webservices.Q2.MyApplication
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import okhttp3.Cache
import okhttp3.CacheControl
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object ApiClint {


    private val BASE_URL = "https://storage.googleapis.com/network-security-conf-codelab.appspot.com/"
    private const val HEADER_CACHE_CONTROL = "Cache-Control"
    private const val HEADER_PRAGMA = "Pragma"
    private const val TAG = "APIClient"
    private const val cacheSize = (5 * 1024 * 1024).toLong()

    val getClient: ApiInterface
        get() {
            return retrofit().create(
                ApiInterface::
                class.java
            )
        }
    private fun retrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(client())
            .addConverterFactory(GsonConverterFactory.create(gson()))
            .build()
    }
    private fun client(): OkHttpClient {
        return OkHttpClient.Builder()
            .cache(myCache())
            .addInterceptor(httpLoggingInterceptor())
            .addInterceptor(offlineInterceptor())
            .addInterceptor(networkInterceptor())
            .build()
    }
    private fun gson(): Gson {
        return GsonBuilder()
            .setLenient()
            .create()
    }
    private fun offlineInterceptor(): Interceptor {
        return Interceptor { chain ->
            var request = chain.request()

            if (!MyApplication().hasNetwork()) {
                val cacheControl = CacheControl.Builder()
                    .maxStale(7, TimeUnit.DAYS)
                    .build()

                request = request.newBuilder()
                    .removeHeader(HEADER_CACHE_CONTROL)
                    .removeHeader(HEADER_PRAGMA)
                    .cacheControl(cacheControl)
                    .build()
            }
            chain.proceed(request)
        }
    }
    private fun networkInterceptor(): Interceptor {
        return Interceptor { chain ->
            val response = chain.proceed(chain.request())

            val cacheControl = CacheControl.Builder()
                .maxAge(5, TimeUnit.SECONDS)
                .build()

            response.newBuilder()
                .removeHeader(HEADER_CACHE_CONTROL)
                .header(HEADER_CACHE_CONTROL, cacheControl.toString())
                .removeHeader(HEADER_PRAGMA)
                .build()
        }
    }

    private fun myCache(): Cache {
        return Cache(MyApplication.instance!!.cacheDir, cacheSize)
    }

    private fun httpLoggingInterceptor(): Interceptor {
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY
        return interceptor
    }

}