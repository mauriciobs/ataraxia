package com.contentgroup.ataraxia.data.responses

import com.contentgroup.ataraxia.data.models.Post
import com.google.gson.annotations.SerializedName

data class PostsResponse (
    @SerializedName("status_code")
    var status: Int,

    @SerializedName("message")
    var message: String,

    @SerializedName("posts")
    var posts: List<Post>
)