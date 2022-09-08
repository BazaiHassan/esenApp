package ir.esen.myapplication.api

import com.google.gson.JsonObject
import io.reactivex.Single
import ir.esen.myapplication.animations.auth.dataModel.ResponseAuthUser
import ir.esen.myapplication.animations.auth.dataModel.ResponseCheckUser
import ir.esen.myapplication.animations.dataModel.ResponseAnimation
import ir.esen.myapplication.helper.TokenContainer
import ir.esen.myapplication.search.ResponseSearch
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.*

interface ApiService {

    @GET("animations/get_anims.php")
    fun getAnimations(): Single<List<ResponseAnimation>>

    @GET("video/get_videos.php")
    fun getVideoStory(): Single<List<ir.esen.myapplication.videoStory.dataModel.ResponseVideoList>>

    @FormUrlEncoded
    @POST("video/search_video_result.php")
    fun getSearchResults(@Field("search") searchKey: String): Single<List<ResponseSearch>>



    @FormUrlEncoded
    @POST("profile/check_user.php")
    fun checkUser(@Field("mobile_phone") phone: String): Single<ResponseCheckUser>



    @FormUrlEncoded
    @POST("profile/auth_user.php")
    fun authUser(@Field("mobile_phone") phone: String): Single<ResponseAuthUser>


}

fun retrofitApi(): ApiService {
// Define Header
    val okHttpClient = OkHttpClient.Builder()
        .addInterceptor {
            val oldRequest = it.request()
            val newRequest = oldRequest.newBuilder()
            if (TokenContainer.token != null) {
                newRequest.addHeader("Authorization", TokenContainer.token!!)
            }
            newRequest.method(oldRequest.method(), oldRequest.body())
            return@addInterceptor it.proceed(newRequest.build())

        }.build()

    val retrofit = Retrofit.Builder()
        .baseUrl("https://ckar.ir/story/backend/")
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .addConverterFactory(GsonConverterFactory.create())
        .client(okHttpClient)
        .build()

    return retrofit.create(ApiService::class.java)
}


