package ir.esen.myapplication.profile.repository

import io.reactivex.Single
import ir.esen.myapplication.profile.dataModel.ResponseAddBookmark
import ir.esen.myapplication.profile.dataSource.AddBookmarkDataSource

class AddBookmarkRepositoryImpl(private val addBookmarkDataSource: AddBookmarkDataSource) : AddBookmarkRepository{
    override fun addBookmark(
        token: String,
        bookmarkName: String,
        bookmarkLink: String,
        bookmarkImage: String
    ): Single<ResponseAddBookmark> {
        return addBookmarkDataSource.addBookmark(token,bookmarkName,bookmarkLink,bookmarkImage)
    }
}