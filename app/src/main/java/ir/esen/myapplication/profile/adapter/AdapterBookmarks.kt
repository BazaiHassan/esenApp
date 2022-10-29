package ir.esen.myapplication.profile.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import ir.esen.myapplication.R
import ir.esen.myapplication.profile.dataModel.ResponseShowProfile
import kotlinx.android.synthetic.main.item_bookmark.view.*

class AdapterBookmarks(private val bookmarkList: List<ResponseShowProfile>) :
    RecyclerView.Adapter<AdapterBookmarks.AdapterBookmarkViewHolder>() {

    var onItemClick: ((ResponseShowProfile) -> Unit)? = null
    var itemIdClicked: Int = 0
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdapterBookmarkViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_bookmark, parent, false)
        return AdapterBookmarkViewHolder(view)
    }

    override fun onBindViewHolder(holder: AdapterBookmarkViewHolder, position: Int) {
        val itemBookmark = bookmarkList[position]
        Glide.with(holder.itemView).load(itemBookmark.b_image).into(holder.imgVideoBookmarked)
        holder.setIsRecyclable(false)

        holder.itemView.remove_bookmark.setOnClickListener {
            onItemClick?.invoke(itemBookmark)
            itemIdClicked = it.id
        }
    }

    override fun getItemCount(): Int {
        return bookmarkList.size
    }

    inner class AdapterBookmarkViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val imgVideoBookmarked: ImageView = itemView.img_bookmark
        val imgRemoveBookmark: ImageView = itemView.remove_bookmark
    }

}