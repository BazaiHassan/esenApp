package ir.esen.myapplication.profile.dataModel

import com.google.gson.annotations.SerializedName

data class ResponseShowProfile(

	@field:SerializedName("date")
	val date: String? = null,

	@field:SerializedName("name_family")
	val nameFamily: String? = null,

	@field:SerializedName("user_image")
	val userImage: String? = null,

	@field:SerializedName("mobile_phone")
	val mobilePhone: String? = null,

	@field:SerializedName("email")
	val email: String? = null
)
