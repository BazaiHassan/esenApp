package ir.esen.myapplication.profile.dataSource

import io.reactivex.Single
import ir.esen.myapplication.profile.dataModel.ResponseShowProfile

interface ShowProfileDataSource {

    fun showProfile(token:String):Single<List<ResponseShowProfile>>
}