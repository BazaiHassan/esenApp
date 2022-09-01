package ir.esen.myapplication.animations


import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import ir.esen.myapplication.R
import ir.esen.myapplication.animations.adapter.AdapterAllAnim
import ir.esen.myapplication.animations.adapter.AdapterAnimation
import ir.esen.myapplication.animations.dataModel.ResponseAnimation
import ir.esen.myapplication.animations.viewModel.AnimationViewModel
import ir.esen.myapplication.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_animation.*
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf


class AnimationFragment : BaseFragment() {

    private val animationView:AnimationViewModel by viewModel()
    val handler = Handler(Looper.myLooper()!!)
    var bannersSlider: List<ResponseAnimation>? = null


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_animation, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        animationView.animationLiveData.observe(viewLifecycleOwner){
            // Banners in Animation page
            val bannerAdapter :AdapterAnimation by inject { parametersOf(it) }
            rv_anim_banner.layoutManager = LinearLayoutManager(requireActivity(),RecyclerView.HORIZONTAL, false)
            rv_anim_banner.adapter = bannerAdapter

            // All Animations
            val allAnimAdapter:AdapterAllAnim by inject { parametersOf(it) }
            rv_anim_item.layoutManager = GridLayoutManager(requireActivity(),2,LinearLayoutManager.VERTICAL,false)
            rv_anim_item.adapter = allAnimAdapter
        }
    }


}
