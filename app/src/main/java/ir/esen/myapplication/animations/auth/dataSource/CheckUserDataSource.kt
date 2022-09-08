package ir.esen.myapplication.animations.auth.dataSource


import com.google.gson.JsonObject
import io.reactivex.Single
import ir.esen.myapplication.animations.auth.dataModel.ResponseCheckUser

interface CheckUserDataSource {

    fun checkUser(userInfo:JsonObject):Single<ResponseCheckUser>

    fun saveToken(token:String)
    fun loadToken()
    fun checkTokenForLogin():Boolean
}