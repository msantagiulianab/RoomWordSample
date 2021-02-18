package com.example.android.roomwordsample.network.apiNews

import com.example.android.roomwordsample.util.Constants.Companion.API_KEY_NEWS
import com.example.android.roomwordsample.util.Constants.Companion.apiKey
import com.example.android.roomwordsample.util.Constants.Companion.baseUrl
import com.example.android.roomwordsample.util.Constants.Companion.category
import com.example.android.roomwordsample.util.Constants.Companion.country
import com.example.android.roomwordsample.util.Constants.Companion.pageSize
import com.example.android.roomwordsample.util.Constants.Companion.sortBy
import com.example.android.roomwordsample.util.Constants.Companion.topHeadlines
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiInterface {

    companion object {
        operator fun invoke(): ApiInterface {
            return Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(ApiInterface::class.java)
        }
    }


//    @GET("$topHeadlines$country=in&$pageSize=100&$apiKey")
//    fun getArticlesModel() : Call<ArticlesModel>

    @GET("$topHeadlines$country=uk&$pageSize=100&$sortBy=publishedAt&$apiKey")
    suspend fun getTopHeadlines(): Response<ArticlesModel>

//    @GET("$topHeadlines$category=technology&$country=uk&$pageSize=100&$apiKey")
//    fun getPreferences() : Call<ArticlesModel>

    @GET("$topHeadlines$category=technology&$country=uk&$pageSize=100&$sortBy=publishedAt&$apiKey")
    suspend fun getArticles(): Response<ArticlesModel>

    @GET("$topHeadlines$category=technology&$country=uk&$pageSize=100&$sortBy=publishedAt&$apiKey")
    suspend fun getTechnology(): Response<ArticlesModel>

//    @GET("$topHeadlines$category=entertainment&$country=in&$pageSize=100&$apiKey")
//    fun getEntertainmaent() : Call<ArticlesModel>

    @GET("$topHeadlines$category=entertainment&$country=uk&$pageSize=100&$sortBy=publishedAt&$apiKey")
    suspend fun getEntertainment(): Response<ArticlesModel>

    @GET("$topHeadlines$category=business&$country=uk&$pageSize=100&$sortBy=publishedAt&$apiKey")
    suspend fun getBusiness(): Response<ArticlesModel>

//    @GET("$topHeadlines$category=general&$country=in&$pageSize=100&$apiKey")
//    fun getGeneral() : Call<ArticlesModel>

    @GET("$topHeadlines$category=health&$country=uk&$pageSize=100&$sortBy=publishedAt&$apiKey")
    suspend fun getHealth(): Response<ArticlesModel>

    @GET("$topHeadlines$category=science&$country=uk&$pageSize=100&$sortBy=publishedAt&$apiKey")
    suspend fun getScience(): Response<ArticlesModel>

    @GET("$topHeadlines$category=sports&$country=uk&$pageSize=100&$sortBy=publishedAt&$apiKey")
    suspend fun getSports(): Response<ArticlesModel>

    //    @GET("$everything$language=en&q=international&$pageSize=100&$sortBy=publishedAt&$apiKey")
//    suspend fun getInternational(searchWord: String): Response<ArticlesModel>
    @GET("everything")
    suspend fun getInternational(
        @Query("language") language: String = "en",
        @Query("q") q: String = "international",
        @Query("pageSize") pageSize: String = "100",
        @Query("sortBy") sortBy: String = "publishedAt",
        @Query("apiKey") apiKey: String = API_KEY_NEWS
    ): Response<ArticlesModel>

}