package ir.esen.myapplication.videoStory.search.repository

import io.reactivex.Single
import ir.esen.myapplication.videoStory.search.ResponseSearch

interface SearchRepository {

    fun searchResult(searchKey:String):Single<List<ResponseSearch>>
}