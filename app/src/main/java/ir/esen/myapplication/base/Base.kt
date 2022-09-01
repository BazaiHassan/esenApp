package ir.esen.myapplication.base

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.coordinatorlayout.widget.CoordinatorLayout
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import io.reactivex.disposables.CompositeDisposable
import ir.esen.myapplication.R

// In this class we define all of things that are mutual in every part of the application
// Like -> Progress bars, Toasts, and so on

abstract class BaseActivity : AppCompatActivity(), BaseTools {
    override val rootView: CoordinatorLayout?
        get() = window.decorView.rootView as CoordinatorLayout

    override val myContext: Context?
        get() = this

}

abstract class BaseFragment : Fragment(), BaseTools {
    override val rootView: CoordinatorLayout?
        get() = view as CoordinatorLayout

    override val myContext: Context?
        get() = context

}

abstract class BaseViewModel : ViewModel() {
    val compositeDisposable = CompositeDisposable()
    override fun onCleared() {
        compositeDisposable.clear()
        super.onCleared()
    }
}

interface BaseTools {
    val rootView: CoordinatorLayout?
    val myContext: Context?
    fun setProgressBar(progress: Boolean) {

        myContext?.let {
            rootView?.let { rootView ->
                var progressView = rootView.findViewById<View>(R.id.frame_progress)
                if (progressView == null && progress) {
                    progressView = LayoutInflater.from(myContext)
                        .inflate(R.layout.progress_view, rootView, false)
                    rootView.addView(progressView)
                }
                progressView?.visibility = if (progress) View.VISIBLE else View.GONE
            }
        }

    }
}