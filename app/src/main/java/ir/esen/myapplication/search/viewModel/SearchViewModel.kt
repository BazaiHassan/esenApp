package ir.esen.myapplication.search.viewModel

import androidx.lifecycle.MutableLiveData
import io.reactivex.SingleObserver
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import ir.esen.myapplication.base.BaseViewModel
import ir.esen.myapplication.search.ResponseSearch
import ir.esen.myapplication.search.repository.SearchRepository

class SearchViewModel(private val searchRepository: SearchRepository):BaseViewModel() {

    val searchResultLiveData = MutableLiveData<List<ResponseSearch>>()

    fun getSearchResult(searchKey:String){
        searchRepository.searchResult(searchKey).subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : SingleObserver<List<ResponseSearch>>{
                override fun onSubscribe(d: Disposable) {
                    compositeDisposable.add(d)
                }

                override fun onSuccess(t: List<ResponseSearch>) {
                    searchResultLiveData.value = t
                }

                override fun onError(e: Throwable) {

                }

            })
    }

}