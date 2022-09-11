package ir.esen.myapplication.profile.repository

import io.reactivex.Single
import ir.esen.myapplication.profile.dataModel.ResponseShowProfile

interface ShowProfileRepository {

    fun showProfile():Single<ResponseShowProfile>
}