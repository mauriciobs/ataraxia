package com.contentgroup.ataraxia.data

import com.contentgroup.ataraxia.data.requests.LoginRequest
import com.contentgroup.ataraxia.data.responses.LoginResponse
import com.contentgroup.ataraxia.data.responses.PostsResponse
import com.contentgroup.ataraxia.utils.Constants
import retrofit2.Call
import retrofit2.http.*

/**
 * Interface for defining REST request functions
 */
interface ApiService {

    @POST(Constants.LOGIN_URL)
    /*@FormUrlEncoded*/
    fun login(@Body request: LoginRequest): Call<LoginResponse>

    @POST ( Constants.POSTS_URL )
    fun fetchPosts ( @Header ( "Authorization" ) token: String ) : Call < PostsResponse >
}