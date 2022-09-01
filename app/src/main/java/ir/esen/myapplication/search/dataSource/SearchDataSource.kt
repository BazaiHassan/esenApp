package ir.esen.myapplication.search.dataSource

import io.reactivex.Single
import ir.esen.myapplication.search.ResponseSearch

interface SearchDataSource {
    fun searchResult(searchKey:String):Single<List<ResponseSearch>>
}