package ir.esen.myapplication.base

import android.app.Application
import android.content.SharedPreferences
import ir.esen.myapplication.animations.adapter.AdapterAllAnim
import ir.esen.myapplication.animations.adapter.AdapterAnimation
import ir.esen.myapplication.animations.auth.dataSource.LocalAuthUserDataSource
import ir.esen.myapplication.animations.auth.dataSource.RemoteAuthUserDataSource
import ir.esen.myapplication.animations.auth.dataSource.RemoteCheckUserDataSource
import ir.esen.myapplication.animations.auth.repository.AuthUserRepository
import ir.esen.myapplication.animations.auth.repository.AuthUserRepositoryImpl
import ir.esen.myapplication.animations.auth.repository.CheckUserRepository
import ir.esen.myapplication.animations.auth.repository.CheckUserRepositoryImpl
import ir.esen.myapplication.animations.auth.viewModel.AuthUserViewModel
import ir.esen.myapplication.animations.auth.viewModel.CheckUserViewModel
import ir.esen.myapplication.animations.dataModel.ResponseAnimation
import ir.esen.myapplication.api.*
import ir.esen.myapplication.animations.dataSource.RemoteAnimationDataSource
import ir.esen.myapplication.videoStory.AdapterVideoList
import ir.esen.myapplication.videoStory.dataSource.RemoteVideoListDataSource
import ir.esen.myapplication.videoStory.repository.VideoListRepository
import ir.esen.myapplication.videoStory.repository.CoinListRepositoryImpl
import ir.esen.myapplication.videoStory.viewModel.VideoListViewModel
import ir.esen.myapplication.animations.repository.AnimationRepository
import ir.esen.myapplication.animations.repository.AnimationRepositoryImpl
import ir.esen.myapplication.animations.search.AdapterSearchAnimList
import ir.esen.myapplication.animations.search.ResponseSearchAnim
import ir.esen.myapplication.animations.search.dataSource.RemoteAnimSearchDataSource
import ir.esen.myapplication.animations.search.repository.SearchAnimRepository
import ir.esen.myapplication.animations.search.repository.SearchAnimRepositoryImpl
import ir.esen.myapplication.animations.search.viewModel.SearchAnimViewModel
import ir.esen.myapplication.animations.viewModel.AnimationViewModel
import ir.esen.myapplication.profile.adapter.AdapterBookmarks
import ir.esen.myapplication.profile.dataModel.ResponseShowProfile
import ir.esen.myapplication.profile.dataSource.RemoteAddBookmarkDataSource
import ir.esen.myapplication.profile.dataSource.RemoteRemoveBookmarkDataSource
import ir.esen.myapplication.profile.dataSource.RemoteShowProfileDataSource
import ir.esen.myapplication.profile.repository.*
import ir.esen.myapplication.profile.viewModel.AddBookmarkViewModel
import ir.esen.myapplication.profile.viewModel.RemoveBookmarkViewModel
import ir.esen.myapplication.profile.viewModel.ShowProfileViewModel
import ir.esen.myapplication.videoStory.search.ResponseSearch
import ir.esen.myapplication.videoStory.search.dataSource.RemoteSearchDataSource
import ir.esen.myapplication.videoStory.search.repository.SearchRepository
import ir.esen.myapplication.videoStory.search.repository.SearchRepositoryImpl
import ir.esen.myapplication.videoStory.search.viewModel.SearchViewModel
import ir.esen.myapplication.videoStory.dataModel.ResponseVideoList
import ir.esen.myapplication.videoStory.search.AdapterSearchList
import org.koin.android.ext.android.get
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.context.startKoin
import org.koin.dsl.module

class App : Application() {
    override fun onCreate() {
        super.onCreate()

        //App Signature for fill the otp automatically
        // val appSignatureHashHelper = AppSignatureHashHelper(this)
        //Log.i("T_HASH", "hashKey: " + appSignatureHashHelper.appSignatures[0])

        val myModule = module {

            single<ApiService> { retrofitApi() }
            single<SharedPreferences> { this@App.getSharedPreferences("userToken", MODE_PRIVATE) }

            factory<VideoListRepository> { CoinListRepositoryImpl(RemoteVideoListDataSource(get())) }
            viewModel { VideoListViewModel(get()) }
            factory { (videoList: List<ResponseVideoList>) -> AdapterVideoList(videoList) }

            factory<AnimationRepository> { AnimationRepositoryImpl(RemoteAnimationDataSource(get())) }
            viewModel { AnimationViewModel(get()) }
            factory { (animationList: List<ResponseAnimation>) -> AdapterAnimation(animationList) }
            factory { (allAnim: List<ResponseAnimation>) -> AdapterAllAnim(allAnim) }

            factory<SearchRepository> { SearchRepositoryImpl(RemoteSearchDataSource(get())) }
            viewModel { SearchViewModel(get()) }
            factory { (searchList: List<ResponseSearch>) -> AdapterSearchList(searchList) }

            // User Authentication operation
            factory<AuthUserRepository> {
                AuthUserRepositoryImpl(
                    RemoteAuthUserDataSource(get())
                )
            }
            viewModel { AuthUserViewModel(get()) }

            // Check User for login or registration
            factory<CheckUserRepository> {
                CheckUserRepositoryImpl(
                    RemoteCheckUserDataSource(get()),
                    LocalAuthUserDataSource(get())
                )
            }
            viewModel { CheckUserViewModel(get()) }

            // Show Bookmarks
            factory<ShowProfileRepository> {
                ShowProfileRepositoryImpl(
                    RemoteShowProfileDataSource(
                        get()
                    )
                )
            }
            viewModel { ShowProfileViewModel(get()) }
            factory { (bookmarkList: List<ResponseShowProfile>) -> AdapterBookmarks(bookmarkList) }

            // Search in animations
            factory<SearchAnimRepository> { SearchAnimRepositoryImpl(RemoteAnimSearchDataSource(get())) }
            viewModel { SearchAnimViewModel(get()) }
            factory { (searchList: List<ResponseSearchAnim>) -> AdapterSearchAnimList(searchList) }

            // Add Bookmarks
            factory<AddBookmarkRepository> { AddBookmarkRepositoryImpl(RemoteAddBookmarkDataSource(get())) }
            viewModel {AddBookmarkViewModel(get())}

            // Remove Bookmark
            factory<RemoveBookmarkRepository> { RemoveBookmarkRepositoryImpl(RemoteRemoveBookmarkDataSource(get())) }
            viewModel { RemoveBookmarkViewModel(get()) }


        }

        startKoin {
            androidContext(this@App)
            modules(myModule)
        }

        val checkUserRepository: CheckUserRepository = get()
        checkUserRepository.loadToken()
    }


}