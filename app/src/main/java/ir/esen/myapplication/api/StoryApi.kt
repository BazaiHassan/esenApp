package ir.esen.myapplication.api

import ir.esen.myapplication.data.ResponseStories
import retrofit2.Response
import retrofit2.http.Field
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface StoryApi {

    @GET("story/backend/video/get_videos.php")
    suspend fun getAllStories(): Response<List<ResponseStories>>

    @POST("story/backend/video/search_video_result.php")
    suspend fun searchStories(
        @Field("search") searchKey: String
    ): Response<List<ResponseStories>>

}