package ir.esen.myapplication.api

import io.reactivex.Single
import ir.esen.myapplication.animations.dataModel.ResponseAnimation
import ir.esen.myapplication.search.ResponseSearch
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiService {

    @GET("animations/get_anims.php")
    fun getAnimations():Single<List<ResponseAnimation>>

    @GET("video/get_videos.php")
    fun getVideoStory():Single<List<ir.esen.myapplication.videoStory.dataModel.ResponseVideoList>>

    @FormUrlEncoded
    @POST("video/search_video_result.php")
    fun getSearchResults(@Field("search") searchKey:String):Single<List<ResponseSearch>>


}

fun retrofitApi():ApiService{
    val retrofit = Retrofit.Builder()
        .baseUrl("https://ckar.ir/story/backend/")
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    return retrofit.create(ApiService::class.java)
}
