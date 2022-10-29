package ir.esen.myapplication.profile.dataSource

import io.reactivex.Single
import ir.esen.myapplication.api.ApiService
import ir.esen.myapplication.profile.dataModel.ResponseShowProfile

class RemoteShowProfileDataSource(private val apiService: ApiService):ShowProfileDataSource {
    override fun showProfile(token:String): Single<List<ResponseShowProfile>> {
        return apiService.showBookmarks(token)
    }
}