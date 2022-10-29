package ir.esen.myapplication.profile.repository

import io.reactivex.Single
import ir.esen.myapplication.profile.dataModel.ResponseAddBookmark

interface AddBookmarkRepository {

    fun addBookmark(
        token: String,
        bookmarkName: String,
        bookmarkLink: String,
        bookmarkImage: String
    ): Single<ResponseAddBookmark>

}