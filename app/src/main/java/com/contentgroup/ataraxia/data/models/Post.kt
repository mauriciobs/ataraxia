package com.contentgroup.ataraxia.data.models

import com.google.gson.annotations.SerializedName

data class Post (
    @SerializedName("id")
    var id: Int,

    @SerializedName("title")
    var title: String,

    @SerializedName("estado")
    var estado: String,

    @SerializedName("content")
    var content: String
)