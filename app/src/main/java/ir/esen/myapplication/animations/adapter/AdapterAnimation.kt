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

class AdapterAnimation(private val animBanners:List<ResponseAnimation>):RecyclerView.Adapter<AdapterAnimation.AnimationViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AnimationViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_anim_banner,parent,false)
        return AnimationViewHolder(view)
    }

    override fun onBindViewHolder(holder: AnimationViewHolder, position: Int) {
        val itemBanners = animBanners[position]
        Glide.with(holder.itemView).load(itemBanners.animBanner).into(holder.imgBannerAnimation)
    }

    override fun getItemCount(): Int {
        return animBanners.size
    }

    class AnimationViewHolder(itemView:View):RecyclerView.ViewHolder(itemView){
        val imgBannerAnimation: ImageView = itemView.img_item_banner
    }
}