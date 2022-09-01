package ir.esen.myapplication.videoStory.dataModel

import com.google.gson.annotations.SerializedName

data class ResponseVideoList(

	@field:SerializedName("video_name")
	val videoName: String? = null,

	@field:SerializedName("video_image")
	val videoImage: String? = null,

	@field:SerializedName("video_duration")
	val videoDuration: String? = null,

	@field:SerializedName("video_link")
	val videoLink: String? = null,

	@field:SerializedName("id")
	val id: Int? = null,

	@field:SerializedName("video_language")
	val videoLanguage: String? = null
)
