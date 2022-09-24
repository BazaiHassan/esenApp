package ir.esen.myapplication.videoStory.search.dataSource

import io.reactivex.Single
import ir.esen.myapplication.animations.search.ResponseSearchAnim
import ir.esen.myapplication.animations.search.dataSource.SearchAnimDataSource
import ir.esen.myapplication.api.ApiService
import ir.esen.myapplication.videoStory.search.ResponseSearch

class RemoteSearchDataSource(private val apiService: ApiService) : SearchDataSource {
    override fun searchResult(searchKey: String): Single<List<ResponseSearch>> {
        return apiService.getSearchResults(searchKey)
    }
}