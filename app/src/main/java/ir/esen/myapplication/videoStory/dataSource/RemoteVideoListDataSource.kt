package ir.esen.myapplication.videoStory.dataSource

import io.reactivex.Single
import ir.esen.myapplication.api.ApiService
import ir.esen.myapplication.videoStory.dataModel.ResponseVideoList

class RemoteVideoListDataSource(private val apiService: ApiService):VideoListDataSource {
    override fun getVideoList(): Single<List<ResponseVideoList>> = apiService.getVideoStory()
}