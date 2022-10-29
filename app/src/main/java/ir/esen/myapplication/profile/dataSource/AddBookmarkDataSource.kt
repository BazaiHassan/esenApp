package ir.esen.myapplication.profile.dataSource

import io.reactivex.Single
import ir.esen.myapplication.profile.dataModel.ResponseAddBookmark
import retrofit2.http.Field

interface AddBookmarkDataSource {
    fun addBookmark(
        token: String,
        bookmarkName: String,
        bookmarkLink: String,
        bookmarkImage: String
    ): Single<ResponseAddBookmark>
}