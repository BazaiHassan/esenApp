package ir.esen.myapplication.animations.auth.dataSource

import com.google.gson.JsonObject
import io.reactivex.Single
import ir.esen.myapplication.animations.auth.dataModel.ResponseCheckUser
import ir.esen.myapplication.api.ApiService

class RemoteCheckUserDataSource(private val apiService: ApiService): CheckUserDataSource {
    override fun checkUser(phone: String): Single<ResponseCheckUser> {
        return apiService.checkUser(phone)
    }

    override fun saveToken(token: String) {
        TODO("Not yet implemented")
    }

    override fun loadToken() {
        TODO("Not yet implemented")
    }

    override fun checkTokenForLogin(): Boolean {
        TODO("Not yet implemented")
    }

}