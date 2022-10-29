package ir.esen.myapplication.profile

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import ir.esen.myapplication.R
import ir.esen.myapplication.animations.auth.viewModel.CheckUserViewModel
import ir.esen.myapplication.helper.TokenContainer
import ir.esen.myapplication.profile.adapter.AdapterBookmarks
import ir.esen.myapplication.profile.viewModel.RemoveBookmarkViewModel
import ir.esen.myapplication.profile.viewModel.ShowProfileViewModel
import kotlinx.android.synthetic.main.fragment_profile.*
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf


class ProfileFragment : Fragment(){

    private val showProfileViewModel:ShowProfileViewModel by viewModel()
    private val removeBookmarkViewModel:RemoveBookmarkViewModel by viewModel()

        override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_profile, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        showProfileViewModel.showBookmarks(TokenContainer.token!!)
        showProfileViewModel.showProfileLiveData.observe(viewLifecycleOwner){
            val bookmarkAdapter:AdapterBookmarks by inject { parametersOf(it) }

            rv_bookmarks.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL,false)
            rv_bookmarks.adapter = bookmarkAdapter

            bookmarkAdapter.onItemClick = { story_item ->
                removeBookmarkViewModel.removeBookmark(story_item.id!!)
                removeBookmarkViewModel.removeBookmarkLiveData.observe(viewLifecycleOwner){ response ->
                    if (response.message!!.isEmpty()){
                        Toast.makeText(requireContext(),"خطای ارتباط",Toast.LENGTH_SHORT).show()
                    }else{
                        it.drop(bookmarkAdapter.itemIdClicked)
                        Toast.makeText(requireContext(),response.message.toString(),Toast.LENGTH_SHORT).show()
                    }
                    bookmarkAdapter.notifyDataSetChanged()
                }
            }

        }


    }


}