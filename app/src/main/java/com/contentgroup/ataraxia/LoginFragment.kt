package com.contentgroup.ataraxia

import ApiClient
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.util.Patterns
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.contentgroup.ataraxia.data.requests.LoginRequest
import com.contentgroup.ataraxia.data.responses.LoginResponse
import com.contentgroup.ataraxia.databinding.FragmentLoginBinding
import com.contentgroup.ataraxia.utils.SessionManager
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class LoginFragment : Fragment() {
    private lateinit var sessionManager: SessionManager
    private lateinit var apiClient: ApiClient
    private var _binding: FragmentLoginBinding? = null
    private val binding get() = _binding!!
    @Override
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentLoginBinding.inflate(inflater, container, false)
        apiClient = ApiClient()
        sessionManager = SessionManager(requireContext())
        binding.btnLogin.setOnClickListener { submitForm() }
        return binding.root
    }
    private fun submitForm(){
        emailListener()
        passwordListener()
        val validEmail = binding.layEmail.helperText == null
        val validPassword = binding.layPassword.helperText == null
        if(validEmail && validPassword){
            val email = binding.email.text.toString()
            val password = binding.password.text.toString()
            apiClient.getApiService().login(LoginRequest(email = email, password = password))
                .enqueue(object : Callback<LoginResponse> {
                    override fun onFailure(call: Call<LoginResponse>, t: Throwable) {
                        // Error logging in
                        Log.d("TAG", t.message.toString())
                    }
                    override fun onResponse(call: Call<LoginResponse>, response: Response<LoginResponse>) {
                        val loginResponse = response.body()
                        if (loginResponse?.statusCode == 200 && loginResponse.user != null) {
                            sessionManager.saveAuthToken(loginResponse.authToken)
                            val intent = Intent(activity, HomeActivity::class.java)
                            startActivity(intent)
                        } else {
                            // Error logging in
                            Log.d("TAG", response.body().toString())
                        }
                    }
            })
        }
}
    private fun passwordListener () {
        if(binding.password.text.toString().isEmpty()){
            binding.layPassword.helperText = "Escriba la constraseña"
        }else{
            binding.layPassword.helperText = null
        }
    }
    private fun emailListener () {
        val emailInput : String = binding.email.text.toString()
        if(emailInput.isEmpty() || !Patterns.EMAIL_ADDRESS.matcher(emailInput).matches()){
            binding.layEmail.helperText = "Email inválido"
        }else{
            binding.layEmail.helperText = null
        }
    }

}