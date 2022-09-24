package ir.esen.myapplication.animations.search.viewModel

import androidx.lifecycle.MutableLiveData
import io.reactivex.SingleObserver
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import ir.esen.myapplication.animations.search.ResponseSearchAnim
import ir.esen.myapplication.animations.search.repository.SearchAnimRepository
import ir.esen.myapplication.base.BaseViewModel
import ir.esen.myapplication.videoStory.search.ResponseSearch
import ir.esen.myapplication.videoStory.search.repository.SearchRepository

class SearchAnimViewModel(private val searchAnimRepository: SearchAnimRepository):BaseViewModel() {

    val searchResultLiveData = MutableLiveData<List<ResponseSearchAnim>>()

    fun getSearchResult(searchKey:String){
        searchAnimRepository.searchResult(searchKey).subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : SingleObserver<List<ResponseSearchAnim>>{
                override fun onSubscribe(d: Disposable) {
                    compositeDisposable.add(d)
                }

                override fun onSuccess(t: List<ResponseSearchAnim>) {
                    searchResultLiveData.value = t
                }

                override fun onError(e: Throwable) {

                }

            })
    }

}