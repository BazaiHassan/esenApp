package ir.esen.myapplication.animations.auth.dataSource

import com.google.gson.JsonObject
import io.reactivex.Single
import ir.esen.myapplication.animations.auth.dataModel.ResponseAuthUser

interface AuthUserDataSource {

    fun authUser(userPhone: String):Single<ResponseAuthUser>

}