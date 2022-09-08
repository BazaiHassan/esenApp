package ir.esen.myapplication.animations.auth.dataSource


import com.google.gson.JsonObject
import io.reactivex.Single
import ir.esen.myapplication.animations.auth.dataModel.ResponseCheckUser

interface CheckUserDataSource {

    fun checkUser(phone: String):Single<ResponseCheckUser>

    fun saveToken(token:String)
    fun loadToken()
    fun checkTokenForLogin():Boolean
}