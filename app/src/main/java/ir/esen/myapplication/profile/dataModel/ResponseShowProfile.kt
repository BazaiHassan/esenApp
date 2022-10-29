package ir.esen.myapplication.profile.dataModel

import com.google.gson.annotations.SerializedName

data class ResponseShowProfile(

	@field:SerializedName("id")
	val id: String? = null,

	@field:SerializedName("b_name")
	val b_name: String? = null,

	@field:SerializedName("b_image")
	val b_image: String? = null,

	@field:SerializedName("b_link")
	val b_link: String? = null,

)
