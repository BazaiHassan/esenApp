package ir.esen.myapplication.videoStory


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import ir.esen.myapplication.R
import ir.esen.myapplication.helper.VariableContainer
import ir.esen.myapplication.videoStory.dataModel.ResponseVideoList
import kotlinx.android.synthetic.main.item_video_list.view.*

class AdapterVideoList(private val videoList: List<ResponseVideoList>) :
    RecyclerView.Adapter<AdapterVideoList.VideoListViewHolder>() {

    var onItemClicked: ((ResponseVideoList) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VideoListViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_video_list, parent, false)
        return VideoListViewHolder(view)
    }

    override fun onBindViewHolder(holder: VideoListViewHolder, position: Int) {
        val itemVideo = videoList[position]
        holder.videoName.text = itemVideo.videoName
        Glide.with(holder.itemView).load(itemVideo.videoImage).into(holder.videoImage)

        holder.itemView.setOnClickListener {
            onItemClicked?.invoke(itemVideo)
        }

        holder.bookmark.setOnClickListener {
            if (VariableContainer.bookmarkState){
                holder.bookmark.setImageDrawable(null)
                holder.bookmark.setBackgroundResource(R.drawable.ic_unbookmark)
                VariableContainer.updateBookmarkState(false)
            }else{
                holder.bookmark.setImageDrawable(null)
                holder.bookmark.setBackgroundResource(R.drawable.ic_bookmark)
                VariableContainer.updateBookmarkState(true)
            }

        }

        holder.like.setOnClickListener {
            if (VariableContainer.likeState){
                holder.like.setImageDrawable(null)
                holder.like.setBackgroundResource(R.drawable.ic_dislike)
                VariableContainer.updateLikeState(false)
            }else{
                holder.like.setImageDrawable(null)
                holder.like.setBackgroundResource(R.drawable.ic_like)
                VariableContainer.updateLikeState(true)
            }
        }

    }

    override fun getItemCount(): Int = videoList.size

    class VideoListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val videoImage = itemView.imageViewMoviePoster
        val videoName = itemView.textMoviePoster
        val bookmark = itemView.bookmark
        val like = itemView.like

    }


}