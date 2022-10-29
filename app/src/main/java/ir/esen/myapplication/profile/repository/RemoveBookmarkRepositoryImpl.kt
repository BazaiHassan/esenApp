package ir.esen.myapplication.profile.repository

import io.reactivex.Single
import ir.esen.myapplication.profile.dataModel.ResponseRemoveBookmark
import ir.esen.myapplication.profile.dataSource.RemoveBookmarkDataSource

class RemoveBookmarkRepositoryImpl(private val removeBookmarkDataSource: RemoveBookmarkDataSource):RemoveBookmarkRepository {
    override fun removeBookmark(story_id: String): Single<ResponseRemoveBookmark> {
        return removeBookmarkDataSource.removeBookmark(story_id)
    }
}