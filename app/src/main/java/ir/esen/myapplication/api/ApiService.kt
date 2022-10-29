package ir.esen.myapplication.api

import io.reactivex.Single
import ir.esen.myapplication.animations.auth.dataModel.ResponseAuthUser
import ir.esen.myapplication.animations.auth.dataModel.ResponseCheckUser
import ir.esen.myapplication.animations.dataModel.ResponseAnimation
import ir.esen.myapplication.animations.search.ResponseSearchAnim
import ir.esen.myapplication.helper.TokenContainer
import ir.esen.myapplication.profile.dataModel.ResponseAddBookmark
import ir.esen.myapplication.profile.dataModel.ResponseRemoveBookmark
import ir.esen.myapplication.profile.dataModel.ResponseShowProfile
import ir.esen.myapplication.videoStory.dataModel.ResponseVideoList
import ir.esen.myapplication.videoStory.search.ResponseSearch
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.*

interface ApiService {

    @GET("animations/get_anims.php")
    fun getAnimations(): Single<List<ResponseAnimation>>

    @GET("video/get_videos.php")
    fun getVideoStory(): Single<List<ResponseVideoList>>

    @FormUrlEncoded
    @POST("video/search_video_result.php")
    fun getSearchResults(@Field("search") searchKey: String): Single<List<ResponseSearch>>


    @FormUrlEncoded
    @POST("animations/search_animation_result.php")
    fun getAnimSearchResults(@Field("search") searchKey: String): Single<List<ResponseSearchAnim>>


    @FormUrlEncoded
    @POST("profile/check_user.php")
    fun checkUser(@Field("mobile_phone") phone: String): Single<ResponseCheckUser>


    @FormUrlEncoded
    @POST("profile/auth_user.php")
    fun authUser(@Field("mobile_phone") phone: String): Single<ResponseAuthUser>


    @FormUrlEncoded
    @POST("profile/show_bookmarks.php")
    fun showBookmarks(@Field("token") token: String): Single<List<ResponseShowProfile>>

    @FormUrlEncoded
    @POST("profile/add_bookmarks.php")
    fun addBookmark(
        @Field("token") token:String,
        @Field("b_name") bookmarkName:String,
        @Field("b_link") bookmarkLink:String,
        @Field("b_image") bookmarkImage:String
    ) : Single<ResponseAddBookmark>

    @FormUrlEncoded
    @POST("profile/remove_bookmark.php")
    fun removeBookmark(@Field("id") story_id: String):Single<ResponseRemoveBookmark>


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


