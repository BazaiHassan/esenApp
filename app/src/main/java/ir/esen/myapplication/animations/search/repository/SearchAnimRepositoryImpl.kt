package ir.esen.myapplication.animations.search.repository

import io.reactivex.Single
import ir.esen.myapplication.animations.search.ResponseSearchAnim
import ir.esen.myapplication.animations.search.dataSource.RemoteAnimSearchDataSource
import ir.esen.myapplication.animations.search.repository.SearchAnimRepository
import ir.esen.myapplication.videoStory.search.ResponseSearch
import ir.esen.myapplication.videoStory.search.dataSource.RemoteSearchDataSource

class SearchAnimRepositoryImpl(private val searchRepository: RemoteAnimSearchDataSource):
    SearchAnimRepository {
    override fun searchResult(searchKey: String): Single<List<ResponseSearchAnim>> {
        return searchRepository.searchResult(searchKey)
    }
}