package com.contentgroup.ataraxia

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.View.OnClickListener
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.contentgroup.ataraxia.databinding.FragmentHomeBinding

class HomeFragment : Fragment(), OnClickListener {
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    @Override
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)

        binding.btnInvers.setOnClickListener(this)
        binding.btnNotficacion.setOnClickListener(this)
        binding.btnEducacion.setOnClickListener(this)
        binding.btnContacto.setOnClickListener(this)
        return binding.root
    }
    override fun onClick(v: View) {
        val navController = v.findNavController()
        when (v.id) {
            binding.btnInvers.id -> {
                navController.navigate(R.id.list_contracts)
            }
            binding.btnNotficacion.id -> {
                Toast.makeText(context, "btnNotficacion pressed", Toast.LENGTH_SHORT).show()
            }
            binding.btnEducacion.id -> {
                Toast.makeText(context, "btnEducacion pressed", Toast.LENGTH_SHORT).show()
            }
            binding.btnContacto.id -> {
                Toast.makeText(context, "btnContacto pressed", Toast.LENGTH_SHORT).show()
            }
        }
    }

}
/*
TODO: viewModel
<!-- https://stackoverflow.com/questions/62171730/where-should-i-call-rest-api-in-fragment */
