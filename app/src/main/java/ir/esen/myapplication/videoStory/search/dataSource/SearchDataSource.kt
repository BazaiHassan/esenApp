package ir.esen.myapplication.videoStory.search.dataSource

import io.reactivex.Single
import ir.esen.myapplication.videoStory.search.ResponseSearch

interface SearchDataSource {
    fun searchResult(searchKey:String):Single<List<ResponseSearch>>
}