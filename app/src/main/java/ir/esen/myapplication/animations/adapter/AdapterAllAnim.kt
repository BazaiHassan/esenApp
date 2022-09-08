package ir.esen.myapplication.animations.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import ir.esen.myapplication.R
import ir.esen.myapplication.animations.dataModel.ResponseAnimation
import kotlinx.android.synthetic.main.item_anim_banner.view.*
import kotlinx.android.synthetic.main.item_video_list.view.*

class AdapterAllAnim(private val animList:List<ResponseAnimation>):RecyclerView.Adapter<AdapterAllAnim.AllAnimViewHolder>() {

    var onItemClick: ((ResponseAnimation) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AllAnimViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_video_list,parent,false)
        return AdapterAllAnim.AllAnimViewHolder(view)
    }

    override fun onBindViewHolder(holder: AllAnimViewHolder, position: Int) {
        val itemAnim = animList[position]
        Glide.with(holder.itemView).load(itemAnim.animBanner).into(holder.imgThumbnailAnimation)
        holder.txtAnimName.text = itemAnim.animName

        holder.itemView.setOnClickListener {
            onItemClick?.invoke(itemAnim)

        }
    }

    override fun getItemCount(): Int {
        return animList.size
    }

    class AllAnimViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val imgThumbnailAnimation: ImageView = itemView.imageViewMoviePoster
        val txtAnimName:TextView = itemView.textMoviePoster
    }
}