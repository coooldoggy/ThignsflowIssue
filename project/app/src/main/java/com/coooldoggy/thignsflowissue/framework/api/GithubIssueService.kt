package com.coooldoggy.thignsflowissue.framework.api

import android.util.Log
import com.coooldoggy.thignsflowissue.BuildConfig
import com.coooldoggy.thignsflowissue.framework.data.GITHUB_BASE_URL
import com.coooldoggy.thignsflowissue.framework.model.IssueData
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface GithubIssueService {

    @GET("/repos/{owner}/{org}/issues")
    suspend fun queryIssues(
        @Query("owner") owner: String,
        @Query("org") org: String
    ): Response<IssueData>

    companion object{
        fun <S> createService(serviceClass: Class<S>): S {
            return buildRetrofitApi().create(serviceClass)
        }

        private fun buildRetrofitApi(): Retrofit {
            return Retrofit.Builder()
                .baseUrl(GITHUB_BASE_URL)
                .client(provideOkHttpClient(provideLoggingInterceptor()))
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }

        private fun provideOkHttpClient(interceptor: HttpLoggingInterceptor): OkHttpClient {
            val builder = OkHttpClient.Builder()
            builder.addInterceptor(interceptor)
            return builder.build()
        }

        private fun provideLoggingInterceptor(): HttpLoggingInterceptor {
            val interceptor = HttpLoggingInterceptor {
                Log.d("GithubIssueService", it)
            }
            interceptor.level = if (BuildConfig.DEBUG) {
                HttpLoggingInterceptor.Level.BODY
            }else{
                HttpLoggingInterceptor.Level.NONE
            }
            return interceptor
        }
    }
}