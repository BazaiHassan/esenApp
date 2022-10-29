package ir.esen.myapplication.profile.viewModel

import androidx.lifecycle.MutableLiveData
import io.reactivex.SingleObserver
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import ir.esen.myapplication.base.BaseViewModel
import ir.esen.myapplication.profile.dataModel.ResponseAddBookmark
import ir.esen.myapplication.profile.repository.AddBookmarkRepository

class AddBookmarkViewModel(private val addBookmarkRepository: AddBookmarkRepository):BaseViewModel() {
    val addBookmarkLiveData = MutableLiveData<ResponseAddBookmark>()
    fun addBookmark(
        token: String,
        bookmarkName: String,
        bookmarkLink: String,
        bookmarkImage: String
    ) {
        addBookmarkRepository.addBookmark(token, bookmarkName, bookmarkLink, bookmarkImage)
            .subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : SingleObserver<ResponseAddBookmark> {
                override fun onSubscribe(d: Disposable) {
                    compositeDisposable.add(d)
                }

                override fun onSuccess(t: ResponseAddBookmark) {
                    addBookmarkLiveData.value = t
                }

                override fun onError(e: Throwable) {

                }

            })
    }
}