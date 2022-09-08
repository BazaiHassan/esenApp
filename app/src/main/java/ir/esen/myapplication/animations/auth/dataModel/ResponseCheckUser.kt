package ir.esen.myapplication.animations.auth.dataModel

import com.google.gson.annotations.SerializedName

data class ResponseCheckUser(

	@field:SerializedName("name_family")
	val nameFamily: String? = null,

	@field:SerializedName("phone")
	val phone: String? = null,

	@field:SerializedName("message")
	val message: String? = null,

	@field:SerializedName("token")
	val token: String? = null
)
