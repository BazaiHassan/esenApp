package ir.esen.myapplication.profile.viewModel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import io.reactivex.SingleObserver
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import ir.esen.myapplication.base.BaseViewModel
import ir.esen.myapplication.profile.dataModel.ResponseShowProfile
import ir.esen.myapplication.profile.repository.ShowProfileRepository

class ShowProfileViewModel(private val showProfileRepository: ShowProfileRepository):BaseViewModel() {
    val showProfileLiveData = MutableLiveData<ResponseShowProfile>()
    init {
        showProfileRepository.showProfile().subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : SingleObserver<ResponseShowProfile> {
                override fun onSubscribe(d: Disposable) {
                    compositeDisposable.add(d)
                }

                override fun onSuccess(t: ResponseShowProfile) {
                    showProfileLiveData.value = t
                    //Log.d("TAG_SHOW_PROFILE_INFO", "onSuccess:${t} ")
                }

                override fun onError(e: Throwable) {

                    //Log.d("TAG_SHOW_PROFILE_ERROR", "onSuccess:${e.message} ")

                }

            })
    }
}