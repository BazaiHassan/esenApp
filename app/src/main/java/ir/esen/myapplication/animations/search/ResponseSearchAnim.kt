package ir.esen.myapplication.animations.search

import com.google.gson.annotations.SerializedName

data class ResponseSearchAnim(

	@field:SerializedName("anim_name")
	val videoName: String? = null,

	@field:SerializedName("anim_thumbnail")
	val videoImage: String? = null,

	@field:SerializedName("anim_duration")
	val videoDuration: String? = null,

	@field:SerializedName("anim_link")
	val videoLink: String? = null,

	@field:SerializedName("id")
	val id: Int? = null,

	@field:SerializedName("anim_language")
	val videoLanguage: String? = null
)

