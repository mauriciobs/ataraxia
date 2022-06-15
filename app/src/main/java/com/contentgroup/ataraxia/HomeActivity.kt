package com.contentgroup.ataraxia

import ApiClient
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.NavController
import androidx.navigation.findNavController
import com.contentgroup.ataraxia.data.ApiService
import com.contentgroup.ataraxia.data.requests.LoginRequest
import com.contentgroup.ataraxia.data.responses.LoginResponse
import com.contentgroup.ataraxia.data.responses.PostsResponse
import com.contentgroup.ataraxia.utils.SessionManager
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class HomeActivity : AppCompatActivity(), View.OnClickListener {
    private var drawerLayout: DrawerLayout? = null

    private lateinit var navController: NavController

    private lateinit var apiClient: ApiClient
    private lateinit var sessionManager: SessionManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(findViewById<View>(R.id.toolbar) as Toolbar)
        drawerLayout = findViewById(R.id.drawer_layout)
        val toggle = ActionBarDrawerToggle( this, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close )
        drawerLayout!!.addDrawerListener(toggle)
        toggle.syncState()

        sessionManager = SessionManager(this)
        apiClient = ApiClient()
    }
    override fun onBackPressed() {
        if (drawerLayout!!.isDrawerOpen(GravityCompat.START)) {
            drawerLayout!!.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.btn_invers -> {
                Toast.makeText(this, "btn_invers pressed", Toast.LENGTH_SHORT).show()
                /*navController.navigateUp() // to clear previous navigation history
                navController.navigate(R.id.list_contracts)*/
                /*apiClient.getApiService().fetchPosts( token = "Bearer ${sessionManager.fetchAuthToken()} " )
                    .enqueue( object : Callback <PostsResponse> {
                        override fun onFailure ( call: Call < PostsResponse > , t: Throwable ) {
                            // Error fetching posts
                            Log.d("TAG", t.message.toString())
                        }
                        override fun onResponse ( call: Call < PostsResponse > , response: Response < PostsResponse >) {
                            // Handle function to display posts
                            val postsResponse = response.body()
                            if (postsResponse?.status == 200) {
                                Log.d("TAG", postsResponse.posts.toString())
                            } else {
                                // Error logging in
                                Log.d("TAG", response.body().toString())
                            }
                        }
                    })*/
            }
            R.id.btn_notficacion -> {
                Toast.makeText(this, "btn_notficacion pressed", Toast.LENGTH_SHORT).show()
            }
            R.id.btn_educacion -> {
                Toast.makeText(this, "btn_educacion pressed", Toast.LENGTH_SHORT).show()
            }
            R.id.btn_contacto -> {
                Toast.makeText(this, "btn_contacto pressed", Toast.LENGTH_SHORT).show()
            }
        }
    }

}