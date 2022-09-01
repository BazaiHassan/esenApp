package ir.esen.myapplication.helper

object VariableContainer {
    var likeState:Boolean = false
    var bookmarkState:Boolean = false

    fun updateLikeState(likeState:Boolean){
        this.likeState = likeState
    }

    fun updateBookmarkState(bookmarkState:Boolean){
        this.bookmarkState = bookmarkState
    }
}