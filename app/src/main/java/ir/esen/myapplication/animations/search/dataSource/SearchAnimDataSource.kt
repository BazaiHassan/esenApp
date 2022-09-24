package ir.esen.myapplication.animations.search.dataSource

import io.reactivex.Single
import ir.esen.myapplication.animations.search.ResponseSearchAnim
import ir.esen.myapplication.videoStory.search.ResponseSearch

interface SearchAnimDataSource {
    fun searchResult(searchKey:String):Single<List<ResponseSearchAnim>>
}