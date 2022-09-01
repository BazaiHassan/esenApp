package ir.esen.myapplication.search

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.widget.addTextChangedListener
import androidx.recyclerview.widget.LinearLayoutManager
import ir.esen.myapplication.R
import ir.esen.myapplication.search.viewModel.SearchViewModel
import ir.esen.myapplication.videoStory.VideoPlayerActivity
import kotlinx.android.synthetic.main.activity_search.*
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf

class SearchActivity : AppCompatActivity() {

    private val searchViewModel: SearchViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search)

        txt_search_sa.addTextChangedListener {
            searchViewModel.getSearchResult(txt_search_sa.text.toString().trim())
        }


        searchViewModel.searchResultLiveData.observe(this) {
            val adapterSearchList: AdapterSearchList by inject { parametersOf(it) }
            rv_video_list_sa.layoutManager =
                LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
            rv_video_list_sa.adapter = adapterSearchList

            adapterSearchList.onItemClicked = {
                val intent = Intent(this, VideoPlayerActivity::class.java).apply {
                    putExtra("videoLink",it.videoLink.toString())
                }
                startActivity(intent)
            }
        }

    }
}