package ir.esen.myapplication.search.repository

import io.reactivex.Single
import ir.esen.myapplication.search.ResponseSearch
import ir.esen.myapplication.search.dataSource.RemoteSearchDataSource

class SearchRepositoryImpl(private val searchRepository:RemoteSearchDataSource):SearchRepository {
    override fun searchResult(searchKey: String): Single<List<ResponseSearch>> {
        return searchRepository.searchResult(searchKey)
    }
}