package ir.esen.myapplication.search.repository

import io.reactivex.Single
import ir.esen.myapplication.search.ResponseSearch

interface SearchRepository {

    fun searchResult(searchKey:String):Single<List<ResponseSearch>>
}