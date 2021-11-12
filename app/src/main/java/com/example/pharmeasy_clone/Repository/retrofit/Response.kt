package com.example.pharmeasy_clone.view

import com.google.gson.annotations.SerializedName

data class Response(

	@field:SerializedName("medical")
	val medical: List<MedicalItem?>? = null
)

data class MedicalItem(

	@field:SerializedName("id")
	val id: String? = null,

	@field:SerializedName("hotel_image_url")
	val hotelImageUrl: String? = null
)
