package com.contentgroup.ataraxia

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.contentgroup.ataraxia.utils.SessionManager


class MainActivity : AppCompatActivity() {
    private lateinit var sessionManager: SessionManager

    @SuppressLint("PrivateResource")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        sessionManager = SessionManager(this)
        Log.d("SESSION", sessionManager.fetchAuthToken().toString())
        if (sessionManager.fetchAuthToken() != null) {
            val intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
        }else{
            setContentView(R.layout.activity_main)
            val buttonLogin : Button = findViewById(R.id.btn_openLogin)
            val fragment = LoginFragment()
            buttonLogin.setOnClickListener {
                supportFragmentManager.beginTransaction()
                    .setCustomAnimations(   com.google.android.material.R.anim.design_bottom_sheet_slide_in,
                        com.google.android.material.R.anim.design_bottom_sheet_slide_in
                    )
                    .replace(R.id.root_layout, fragment).commit()
            }
        }
    }
}