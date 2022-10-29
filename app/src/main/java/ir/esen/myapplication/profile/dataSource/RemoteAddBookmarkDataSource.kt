package ir.esen.myapplication.profile.dataSource

import io.reactivex.Single
import ir.esen.myapplication.api.ApiService
import ir.esen.myapplication.profile.dataModel.ResponseAddBookmark

class RemoteAddBookmarkDataSource(private val apiService: ApiService):AddBookmarkDataSource {
    override fun addBookmark(
        token: String,
        bookmarkName: String,
        bookmarkLink: String,
        bookmarkImage: String
    ): Single<ResponseAddBookmark> {
        return apiService.addBookmark(token,bookmarkName,bookmarkLink,bookmarkImage)
    }
}