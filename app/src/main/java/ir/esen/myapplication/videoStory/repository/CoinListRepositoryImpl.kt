package ir.esen.myapplication.videoStory.repository

import io.reactivex.Single
import ir.esen.myapplication.videoStory.dataModel.ResponseVideoList
import ir.esen.myapplication.videoStory.dataSource.VideoListDataSource

class CoinListRepositoryImpl(private val remoteVideoListDataSource: VideoListDataSource):VideoListRepository {
    override fun getVideoList(): Single<List<ResponseVideoList>> = remoteVideoListDataSource.getVideoList()
}