package ir.esen.myapplication.animations.auth.dataSource

import com.google.gson.JsonObject
import io.reactivex.Single
import ir.esen.myapplication.animations.auth.dataModel.ResponseAuthUser
import ir.esen.myapplication.api.ApiService

class RemoteAuthUserDataSource(private val apiService: ApiService) : AuthUserDataSource {
    override fun authUser(userPhone: String): Single<ResponseAuthUser> =
        apiService.authUser(userPhone)


}