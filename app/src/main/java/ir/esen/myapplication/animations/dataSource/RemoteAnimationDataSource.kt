package ir.esen.myapplication.animations.dataSource

import io.reactivex.Single
import ir.esen.myapplication.api.ApiService
import ir.esen.myapplication.animations.dataModel.ResponseAnimation

class RemoteAnimationDataSource(private val apiService: ApiService):AnimationDataSource {
    override fun getAnimations(): Single<List<ResponseAnimation>> {
        return apiService.getAnimations()
    }
}