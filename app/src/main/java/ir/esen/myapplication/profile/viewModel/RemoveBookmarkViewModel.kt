package ir.esen.myapplication.profile.viewModel

import androidx.lifecycle.MutableLiveData
import io.reactivex.SingleObserver
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import ir.esen.myapplication.base.BaseViewModel
import ir.esen.myapplication.profile.dataModel.ResponseRemoveBookmark
import ir.esen.myapplication.profile.repository.RemoveBookmarkRepository

class RemoveBookmarkViewModel(private val removeBookmarkRepository: RemoveBookmarkRepository):BaseViewModel() {
    val removeBookmarkLiveData = MutableLiveData<ResponseRemoveBookmark>()
    fun removeBookmark(story_id:String){
        removeBookmarkRepository.removeBookmark(story_id).subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : SingleObserver<ResponseRemoveBookmark>{
                override fun onSubscribe(d: Disposable) {
                    compositeDisposable.add(d)
                }

                override fun onSuccess(t: ResponseRemoveBookmark) {
                    removeBookmarkLiveData.value = t
                }

                override fun onError(e: Throwable) {

                }

            })
    }
}