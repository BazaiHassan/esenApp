package ir.esen.myapplication.animations.dataModel

import com.google.gson.annotations.SerializedName

data class ResponseAnimation(
	@field:SerializedName("anim_language")
	val animLanguage: String? = null,

	@field:SerializedName("anim_link")
	val animLink: String? = null,

	@field:SerializedName("anim_duration")
	val animDuration: String? = null,

	@field:SerializedName("anim_name")
	val animName: String? = null,

	@field:SerializedName("anim_banner")
	val animBanner: String? = null,

	@field:SerializedName("anim_imdb")
	val animImdb: String? = null,

	@field:SerializedName("id")
	val id: Int? = null,

	@field:SerializedName("anim_thumbnail")
	val animThumbnail: String? = null,

	@field:SerializedName("anim_description")
	val animDescription: String? = null

)
