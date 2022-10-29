package ir.esen.myapplication.profile.dataSource

import io.reactivex.Single
import ir.esen.myapplication.api.ApiService
import ir.esen.myapplication.profile.dataModel.ResponseRemoveBookmark

class RemoteRemoveBookmarkDataSource(private val apiService: ApiService ):RemoveBookmarkDataSource {
    override fun removeBookmark(story_id: String): Single<ResponseRemoveBookmark> {
        return apiService.removeBookmark(story_id)
    }
}