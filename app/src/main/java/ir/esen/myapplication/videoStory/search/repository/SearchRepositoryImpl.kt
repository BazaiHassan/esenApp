package ir.esen.myapplication.videoStory.search.repository

import io.reactivex.Single
import ir.esen.myapplication.videoStory.search.ResponseSearch
import ir.esen.myapplication.videoStory.search.dataSource.RemoteSearchDataSource

class SearchRepositoryImpl(private val searchRepository:RemoteSearchDataSource):SearchRepository {
    override fun searchResult(searchKey: String): Single<List<ResponseSearch>> {
        return searchRepository.searchResult(searchKey)
    }
}