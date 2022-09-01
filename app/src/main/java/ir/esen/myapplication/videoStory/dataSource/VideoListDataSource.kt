package ir.esen.myapplication.videoStory.dataSource

import io.reactivex.Single
import ir.esen.myapplication.videoStory.dataModel.ResponseVideoList

interface VideoListDataSource {

    fun getVideoList():Single<List<ResponseVideoList>>
}