package com.tc.virginmoney.ui.rooms.data


import com.google.gson.annotations.SerializedName

data class RoomsItemModel(
    @SerializedName("createdAt")
    val createdAt: String? = "",
    @SerializedName("id")
    val id: String? = "",
    @SerializedName("isOccupied")
    val isOccupied: Boolean? = false,
    @SerializedName("maxOccupancy")
    val maxOccupancy: Int? = 0
)