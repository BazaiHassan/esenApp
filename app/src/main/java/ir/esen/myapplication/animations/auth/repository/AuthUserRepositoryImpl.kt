package ir.esen.myapplication.animations.auth.repository


import com.google.gson.JsonObject
import io.reactivex.Single
import ir.esen.myapplication.animations.auth.dataModel.ResponseAuthUser
import ir.esen.myapplication.animations.auth.dataSource.AuthUserDataSource

class AuthUserRepositoryImpl(
    private val remoteAuthUserDataSource: AuthUserDataSource
) :
    AuthUserRepository {
    override fun authUser(userPhone:String): Single<ResponseAuthUser> {
        return remoteAuthUserDataSource.authUser(userPhone)
    }


}