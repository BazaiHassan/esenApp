package ir.esen.myapplication.animations.auth.dataSource

import android.content.SharedPreferences
import com.google.gson.JsonObject
import io.reactivex.Single
import ir.esen.myapplication.animations.auth.dataModel.ResponseCheckUser
import ir.esen.myapplication.helper.TokenContainer

class LocalAuthUserDataSource(private val sharedPreferences: SharedPreferences) : CheckUserDataSource {

    override fun checkUser(userInfo: JsonObject): Single<ResponseCheckUser> {
        TODO("Not yet implemented")
    }

    override fun saveToken(token: String) {
        sharedPreferences.edit().apply{
            putString("token",token)
        }.apply()
    }

    override fun loadToken() {
        TokenContainer.updateToken(sharedPreferences.getString("token",null))
    }

    override fun checkTokenForLogin(): Boolean {
        if (sharedPreferences.getString("token","")!=""){
            return true
        }
        return false
    }

}