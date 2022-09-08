package ir.esen.myapplication.animations.auth.viewModel

import androidx.lifecycle.MutableLiveData
import com.google.gson.JsonObject
import io.reactivex.SingleObserver
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import ir.esen.myapplication.animations.auth.dataModel.ResponseCheckUser
import ir.esen.myapplication.animations.auth.repository.CheckUserRepository
import ir.esen.myapplication.base.BaseViewModel

class CheckUserViewModel(private val checkUserRepository: CheckUserRepository): BaseViewModel() {

    val checkUserLiveData = MutableLiveData<ResponseCheckUser>()
    val checkUserLogin = MutableLiveData<Boolean>()

    fun checkUserViewModel(userInfo:JsonObject){
        checkUserRepository.checkUser(userInfo).subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : SingleObserver<ResponseCheckUser>{
                override fun onSubscribe(d: Disposable) {
                    compositeDisposable.add(d)
                }

                override fun onSuccess(t: ResponseCheckUser) {
                    checkUserLiveData.value = t
                    //TODO Here I got error find another way to handle this
                }

                override fun onError(e: Throwable) {

                }

            })
    }

    fun checkUserLogin(){
        checkUserLogin.value = checkUserRepository.checkTokenForLogin()
    }


}