package ir.esen.myapplication.videoStory.repository

import io.reactivex.Single
import ir.esen.myapplication.videoStory.dataModel.ResponseVideoList

interface VideoListRepository {

    fun getVideoList():Single<List<ResponseVideoList>>
}