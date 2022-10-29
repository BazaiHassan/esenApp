package ir.esen.myapplication.profile.dataSource

import io.reactivex.Single
import ir.esen.myapplication.profile.dataModel.ResponseRemoveBookmark

interface RemoveBookmarkDataSource {
    fun removeBookmark(story_id:String):Single<ResponseRemoveBookmark>
}