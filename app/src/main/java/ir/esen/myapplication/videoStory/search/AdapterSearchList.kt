package ir.esen.myapplication.videoStory.search


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import ir.esen.myapplication.R
import kotlinx.android.synthetic.main.item_search.view.*

class AdapterSearchList(private val searchList: List<ResponseSearch>) :
    RecyclerView.Adapter<AdapterSearchList.SearchListViewHolder>() {

    var onItemClicked: ((ResponseSearch) -> Unit)? = null

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
        val videoImage = itemView.img_item_search
        val videoName = itemView.txt_item_name_search

    }


}