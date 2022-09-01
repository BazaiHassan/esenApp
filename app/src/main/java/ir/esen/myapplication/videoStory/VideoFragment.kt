package ir.esen.myapplication.videoStory

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.addTextChangedListener
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import ir.esen.myapplication.R
import ir.esen.myapplication.base.BaseFragment
import ir.esen.myapplication.search.SearchActivity
import ir.esen.myapplication.videoStory.viewModel.VideoListViewModel
import kotlinx.android.synthetic.main.fragment_video.*
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf


class VideoFragment : BaseFragment() {

    private val videoListViewModel: VideoListViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_video, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setProgressBar(true)

        ll_search.setOnClickListener {
            startActivity(Intent(requireActivity(),SearchActivity::class.java))
        }

        videoListViewModel.videoListLiveData.observe(viewLifecycleOwner) {
            val adapterVideo: AdapterVideoList by inject { parametersOf(it) }

            rv_video_list.layoutManager =
                GridLayoutManager(requireActivity(), 2, LinearLayoutManager.VERTICAL, false)
            rv_video_list.adapter = adapterVideo

            setProgressBar(false)

            adapterVideo.onItemClicked = {
                 val intent = Intent(requireActivity(), VideoPlayerActivity::class.java).apply {
                     putExtra("videoLink",it.videoLink.toString())
                 }
                startActivity(intent)
            }
        }

    }
}