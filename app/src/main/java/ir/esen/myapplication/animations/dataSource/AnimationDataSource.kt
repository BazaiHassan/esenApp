package ir.esen.myapplication.animations.dataSource

import io.reactivex.Single
import ir.esen.myapplication.animations.dataModel.ResponseAnimation

interface AnimationDataSource {

    fun getAnimations():Single<List<ResponseAnimation>>

}