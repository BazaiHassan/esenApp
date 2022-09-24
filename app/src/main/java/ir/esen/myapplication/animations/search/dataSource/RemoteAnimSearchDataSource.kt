package ir.esen.myapplication.animations.search.dataSource

import io.reactivex.Single
import ir.esen.myapplication.animations.search.ResponseSearchAnim
import ir.esen.myapplication.api.ApiService
import ir.esen.myapplication.videoStory.search.ResponseSearch
import ir.esen.myapplication.videoStory.search.dataSource.SearchDataSource

class RemoteAnimSearchDataSource(private val apiService: ApiService) : SearchAnimDataSource {
    override fun searchResult(searchKey: String): Single<List<ResponseSearchAnim>> {
        return apiService.getAnimSearchResults(searchKey)
    }
}