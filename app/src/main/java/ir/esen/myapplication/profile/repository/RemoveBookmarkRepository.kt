package ir.esen.myapplication.profile.repository

import io.reactivex.Single
import ir.esen.myapplication.profile.dataModel.ResponseRemoveBookmark

interface RemoveBookmarkRepository {
    fun removeBookmark(story_id:String): Single<ResponseRemoveBookmark>
}