package ir.esen.myapplication.search.dataSource

import io.reactivex.Single
import ir.esen.myapplication.api.ApiService
import ir.esen.myapplication.search.ResponseSearch

class RemoteSearchDataSource(private val apiService: ApiService) : SearchDataSource {
    override fun searchResult(searchKey: String): Single<List<ResponseSearch>> {
        return apiService.getSearchResults(searchKey)
    }
}