package ir.esen.myapplication.animations.auth.repository


import com.google.gson.JsonObject
import io.reactivex.Single
import ir.esen.myapplication.animations.auth.dataModel.ResponseAuthUser

interface AuthUserRepository {
    fun authUser(userPhone:String):Single<ResponseAuthUser>

}