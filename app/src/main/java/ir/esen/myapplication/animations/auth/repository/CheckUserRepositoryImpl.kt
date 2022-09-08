package ir.esen.myapplication.animations.auth.repository

import com.google.gson.JsonObject
import io.reactivex.Single
import ir.esen.myapplication.animations.auth.dataModel.ResponseCheckUser
import ir.esen.myapplication.animations.auth.dataSource.CheckUserDataSource
import ir.esen.myapplication.animations.auth.dataSource.LocalAuthUserDataSource
import ir.esen.myapplication.helper.TokenContainer


class CheckUserRepositoryImpl(private val remoteCheckUserDataSource: CheckUserDataSource, private val localAuthUserDataSource: LocalAuthUserDataSource):
    CheckUserRepository {
    override fun checkUser(phone: String): Single<ResponseCheckUser> {
        return remoteCheckUserDataSource.checkUser(phone).doOnSuccess {
            TokenContainer.updateToken(it.token)
            localAuthUserDataSource.saveToken(it.token!!)
        }
    }

    override fun loadToken() {
        localAuthUserDataSource.loadToken()
    }

    override fun checkTokenForLogin(): Boolean {
        return localAuthUserDataSource.checkTokenForLogin()
    }

}