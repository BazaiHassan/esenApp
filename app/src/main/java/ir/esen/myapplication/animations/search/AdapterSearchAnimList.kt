package ir.esen.myapplication.animations.search


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import ir.esen.myapplication.R
import ir.esen.myapplication.videoStory.search.AdapterSearchList
import ir.esen.myapplication.videoStory.search.ResponseSearch
import kotlinx.android.synthetic.main.item_search.view.*

class AdapterSearchAnimList(private val searchList: List<ResponseSearchAnim>) :
    RecyclerView.Adapter<AdapterSearchAnimList.SearchListViewHolder>() {

    var onItemClicked: ((ResponseSearchAnim) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchListViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_search, parent, false)
        return SearchListViewHolder(view)
    }

    override fun onBindViewHolder(holder: SearchListViewHolder, position: Int) {
        val itemSearch = searchList[position]
        holder.videoName.text = itemSearch.videoName
        Glide.with(holder.itemView).load(itemSearch.videoImage).into(holder.videoImage)

        holder.itemView.setOnClickListener {
            onItemClicked?.invoke(itemSearch)
        }


    }

    override fun getItemCount(): Int = searchList.size

    class SearchListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val videoImage: ImageView = itemView.img_item_search
        val videoName: TextView = itemView.txt_item_name_search

    }


}