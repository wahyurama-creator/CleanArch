package com.way.cleanarch.data.common.utils

import com.google.gson.annotations.SerializedName

data class WrappedListResponse<T>(
    var code: Int,
    @SerializedName("status")
    var status: Boolean,
    @SerializedName("message")
    var message: String,
    @SerializedName("errors")
    var errors: List<String>? = emptyList(),
    @SerializedName("data")
    var data: List<T>? = emptyList()
)

data class WrappedResponse<T>(
    var code: Int,
    @SerializedName("status")
    var status: Boolean,
    @SerializedName("message")
    var message: String,
    @SerializedName("errors")
    var errors: List<String>? = emptyList(),
    @SerializedName("data")
    var data: T? = null
)