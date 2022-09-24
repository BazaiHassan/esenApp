package ir.esen.myapplication.animations.search

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.widget.addTextChangedListener
import androidx.recyclerview.widget.LinearLayoutManager
import ir.esen.myapplication.R
import ir.esen.myapplication.animations.search.viewModel.SearchAnimViewModel
import ir.esen.myapplication.videoStory.VideoPlayerActivity
import kotlinx.android.synthetic.main.activity_search_anim.*
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf

class SearchAnimActivity : AppCompatActivity() {

    private val searchAnimViewModel: SearchAnimViewModel by viewModel()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search_anim)

        txt_search_an.addTextChangedListener {
            searchAnimViewModel.getSearchResult(txt_search_an.text.toString().trim())
        }

        searchAnimViewModel.searchResultLiveData.observe(this) {
            val adapterSearchList: AdapterSearchAnimList by inject { parametersOf(it) }
            rv_video_list_an.layoutManager =
                LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
            rv_video_list_an.adapter = adapterSearchList

            adapterSearchList.onItemClicked = {
                val intent = Intent(this, VideoPlayerActivity::class.java).apply {
                    putExtra("videoLink",it.videoLink.toString())
                }
                startActivity(intent)
            }
        }
    }
}