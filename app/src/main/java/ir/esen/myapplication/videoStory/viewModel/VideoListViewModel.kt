package ir.esen.myapplication.videoStory.viewModel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import io.reactivex.SingleObserver
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import ir.esen.myapplication.base.BaseViewModel
import ir.esen.myapplication.videoStory.dataModel.ResponseVideoList
import ir.esen.myapplication.videoStory.repository.VideoListRepository

class VideoListViewModel(private val videoListRepository: VideoListRepository) : BaseViewModel() {

    val videoListLiveData = MutableLiveData<List<ResponseVideoList>>()

    init {

        videoListRepository.getVideoList().subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : SingleObserver<List<ResponseVideoList>>{
                override fun onSubscribe(d: Disposable) {
                    compositeDisposable.add(d)
                }

                override fun onSuccess(t: List<ResponseVideoList>) {
                    videoListLiveData.value = t
                }

                override fun onError(e: Throwable) {
                    Log.i("TAG_ERROR", "onError: ${e.message}")
                }

            })

    }

}