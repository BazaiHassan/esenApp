package ir.esen.myapplication.profile.repository

import io.reactivex.Single
import ir.esen.myapplication.profile.dataModel.ResponseShowProfile
import ir.esen.myapplication.profile.dataSource.ShowProfileDataSource

class ShowProfileRepositoryImpl(private val showProfileDataSource: ShowProfileDataSource):ShowProfileRepository {
    override fun showProfile(token:String): Single<List<ResponseShowProfile>> {
        return showProfileDataSource.showProfile(token)
    }

}