package ir.esen.myapplication.animations.repository

import io.reactivex.Single
import ir.esen.myapplication.animations.dataModel.ResponseAnimation
import ir.esen.myapplication.animations.dataSource.AnimationDataSource

class AnimationRepositoryImpl(private val animationDataSource:AnimationDataSource):AnimationRepository {
    override fun getAnimations(): Single<List<ResponseAnimation>> {
        return animationDataSource.getAnimations()
    }
}