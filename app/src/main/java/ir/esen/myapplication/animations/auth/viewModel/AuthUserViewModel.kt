package ir.esen.myapplication.animations.auth.viewModel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.google.gson.JsonObject
import io.reactivex.SingleObserver
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import ir.esen.myapplication.animations.auth.dataModel.ResponseAuthUser
import ir.esen.myapplication.animations.auth.repository.AuthUserRepository
import ir.esen.myapplication.base.BaseViewModel

class AuthUserViewModel(private val authUserRepository: AuthUserRepository) : BaseViewModel() {

    val authUserLiveData = MutableLiveData<ResponseAuthUser>()

    fun authUserViewModel(userPhone:String){
        authUserRepository.authUser(userPhone).subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe( object : SingleObserver<ResponseAuthUser>{
                override fun onSubscribe(d: Disposable) {
                    compositeDisposable.add(d)
                }

                override fun onSuccess(t: ResponseAuthUser) {
                    authUserLiveData.value = t
                }

                override fun onError(e: Throwable) {
                    //TODO Need to be Handled
                    Log.d("TAG_Server_Res", "onError:${e.message} ")
                }

            } )
    }

}