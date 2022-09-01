package ir.esen.myapplication.animations.viewModel

import androidx.lifecycle.MutableLiveData
import io.reactivex.SingleObserver
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import ir.esen.myapplication.animations.dataModel.ResponseAnimation
import ir.esen.myapplication.animations.repository.AnimationRepository
import ir.esen.myapplication.base.BaseViewModel

class AnimationViewModel(private val animationRepository: AnimationRepository):BaseViewModel() {
    val animationLiveData = MutableLiveData<List<ResponseAnimation>>()
    init {
        animationRepository.getAnimations().subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : SingleObserver<List<ResponseAnimation>>{
                override fun onSubscribe(d: Disposable) {
                    compositeDisposable.add(d)
                }

                override fun onSuccess(t: List<ResponseAnimation>) {
                    animationLiveData.value = t
                }

                override fun onError(e: Throwable) {

                }

            })
    }
}