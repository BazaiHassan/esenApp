package ir.esen.myapplication.animations.repository

import io.reactivex.Single
import ir.esen.myapplication.animations.dataModel.ResponseAnimation

interface AnimationRepository {

    fun getAnimations():Single<List<ResponseAnimation>>
}