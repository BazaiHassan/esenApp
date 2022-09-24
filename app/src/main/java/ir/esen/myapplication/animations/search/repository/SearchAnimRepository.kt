package ir.esen.myapplication.animations.search.repository

import io.reactivex.Single
import ir.esen.myapplication.animations.search.ResponseSearchAnim
import ir.esen.myapplication.videoStory.search.ResponseSearch

interface SearchAnimRepository {

    fun searchResult(searchKey:String):Single<List<ResponseSearchAnim>>
}