package ir.esen.myapplication.animations


import android.app.Dialog
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.*
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.viewpager2.widget.ViewPager2
import com.bumptech.glide.Glide
import ir.esen.myapplication.R
import ir.esen.myapplication.animations.adapter.AdapterAllAnim
import ir.esen.myapplication.animations.adapter.AdapterAnimation
import ir.esen.myapplication.animations.dataModel.ResponseAnimation
import ir.esen.myapplication.animations.search.SearchAnimActivity
import ir.esen.myapplication.animations.viewModel.AnimationViewModel
import ir.esen.myapplication.base.BaseFragment
import ir.esen.myapplication.helper.TokenContainer
import ir.esen.myapplication.profile.viewModel.AddBookmarkViewModel
import ir.esen.myapplication.videoStory.VideoPlayerActivity
import kotlinx.android.synthetic.main.bottom_sheet_layout.*
import kotlinx.android.synthetic.main.fragment_animation.*
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf


class AnimationFragment : BaseFragment() {

    private val animationView: AnimationViewModel by viewModel()
    private val addBookmarkViewModel: AddBookmarkViewModel by viewModel()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_animation, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        animationView.animationLiveData.observe(viewLifecycleOwner) {
            // Banners in Animation page
            val bannerAdapter: AdapterAnimation by inject { parametersOf(it) }
            rv_anim_banner.adapter = bannerAdapter
            rv_anim_banner.orientation = ViewPager2.ORIENTATION_HORIZONTAL
            dots_indicator.setViewPager2(rv_anim_banner)

            bannerAdapter.onItemClick = { item ->
                showDialog(item)
            }

            // All Animations
            val allAnimAdapter: AdapterAllAnim by inject { parametersOf(it) }
            rv_anim_item.layoutManager =
                GridLayoutManager(requireActivity(), 2, LinearLayoutManager.VERTICAL, false)
            rv_anim_item.adapter = allAnimAdapter

            allAnimAdapter.onItemClick = { item ->
                showDialog(item)
            }

            allAnimAdapter.onItemLongClick = { responseAnimList ->
                addBookmarkViewModel.addBookmark(TokenContainer.token!!,responseAnimList.animName!!,responseAnimList.animLink!!,responseAnimList.animBanner!!)
                addBookmarkViewModel.addBookmarkLiveData.observe(viewLifecycleOwner){
                    Toast.makeText(requireContext(), it.message, Toast.LENGTH_SHORT).show()
                }
            }
        }

        rltv_search.setOnClickListener {
            startActivity(Intent(requireActivity(), SearchAnimActivity::class.java))
        }
    }


    private fun showDialog(item:ResponseAnimation) {
        val dialog = Dialog(requireContext())
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setContentView(R.layout.bottom_sheet_layout)

        dialog.window!!.setLayout(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )
        dialog.window!!.setBackgroundDrawable(ColorDrawable(Color.WHITE))
        dialog.window!!.attributes.windowAnimations = R.style.DialogAnimation
        dialog.window!!.setGravity(Gravity.BOTTOM)

        Glide.with(this).load(item.animBanner).into(dialog.img_anim_banner_bs)
        dialog.txt_anim_description_bs?.text = item.animDescription.toString()

        dialog.show()
        dialog.btn_anim_play.setOnClickListener {
            val intent = Intent(requireActivity(), VideoPlayerActivity::class.java).apply {
                putExtra("videoLink",item.animLink.toString())
            }
            startActivity(intent)
        }
    }


}
