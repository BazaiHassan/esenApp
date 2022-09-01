package ir.esen.myapplication.animations


import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.CompositePageTransformer
import androidx.viewpager2.widget.MarginPageTransformer
import androidx.viewpager2.widget.ViewPager2
import ir.esen.myapplication.R
import ir.esen.myapplication.animations.adapter.AdapterAnimation
import ir.esen.myapplication.animations.dataModel.ResponseAnimation
import ir.esen.myapplication.animations.viewModel.AnimationViewModel
import ir.esen.myapplication.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_audio.*
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf


class AudioFragment : BaseFragment() {

    private val animationView:AnimationViewModel by viewModel()
    val handler = Handler(Looper.myLooper()!!)
    var bannersSlider: List<ResponseAnimation>? = null


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_audio, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        animationView.animationLiveData.observe(viewLifecycleOwner){
            val bannerAdapter :AdapterAnimation by inject { parametersOf(it) }

            //banner_viewPager.adapter = bannerAdapter
            banner_viewPager.setOrientation(ViewPager2.ORIENTATION_HORIZONTAL)
            banner_viewPager.setClipToPadding(false)
            banner_viewPager.setClipChildren(false)
            banner_viewPager.setOffscreenPageLimit(3)
            banner_viewPager.getChildAt(0)!!.setOverScrollMode(RecyclerView.OVER_SCROLL_NEVER)
            val transformer = CompositePageTransformer()
            transformer.addTransformer(MarginPageTransformer(20))
            transformer.addTransformer { page, position ->
                val r = 1 - Math.abs(position)
                page.scaleY = 0.85f + r * 0.1f
            }
            banner_viewPager.setPageTransformer(transformer)
            banner_viewPager.adapter = bannerAdapter
            dots_indicator.setViewPager2(banner_viewPager)

            banner_viewPager.registerOnPageChangeCallback(object :
                ViewPager2.OnPageChangeCallback() {
                override fun onPageSelected(position: Int) {
                    super.onPageSelected(position)
//                    handler.removeCallbacks(sliderRunable)
//                    handler.postDelayed(sliderRunable, 5000)
                }
            })
        }
    }


}
