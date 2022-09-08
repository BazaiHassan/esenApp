package ir.esen.myapplication.animations.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import ir.esen.myapplication.R
import ir.esen.myapplication.animations.dataModel.ResponseAnimation
import kotlinx.android.synthetic.main.item_anim_banner.view.*
const val BANNER_COUNT = 2
class AdapterAnimation(private val animBanners:List<ResponseAnimation>):RecyclerView.Adapter<AdapterAnimation.AnimationViewHolder>() {

    var onItemClick: ((ResponseAnimation) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AnimationViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_anim_banner,parent,false)
        return AnimationViewHolder(view)
    }

    override fun onBindViewHolder(holder: AnimationViewHolder, position: Int) {
        val itemBanners = animBanners[position]
        Glide.with(holder.itemView).load(itemBanners.animBanner).into(holder.imgBannerAnimation)

        holder.itemView.setOnClickListener {
            onItemClick?.invoke(itemBanners)

        }
    }

    override fun getItemCount(): Int {
        return BANNER_COUNT
    }

    inner class AnimationViewHolder(itemView:View):RecyclerView.ViewHolder(itemView){
        val imgBannerAnimation: ImageView = itemView.img_item_banner
    }
}