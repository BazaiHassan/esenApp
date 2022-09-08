package ir.esen.myapplication.animations.auth.repository

import com.google.gson.JsonObject
import io.reactivex.Single
import ir.esen.myapplication.animations.auth.dataModel.ResponseCheckUser

interface CheckUserRepository {

    fun checkUser(userInfo:JsonObject):Single<ResponseCheckUser>

    fun loadToken()
    fun checkTokenForLogin():Boolean

}