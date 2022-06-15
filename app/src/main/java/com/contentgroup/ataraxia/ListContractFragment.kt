package com.contentgroup.ataraxia

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.contentgroup.ataraxia.data.models.Post
import com.contentgroup.ataraxia.databinding.FragmentListContractBinding
import kotlin.math.log

class ListContractFragment : Fragment() {
    private var _binding: FragmentListContractBinding? = null
    private val binding get() = _binding!!
    @Override
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentListContractBinding.inflate(inflater, container, false)
        /*val listItems = arrayOfNulls<String>(9)
        for (i in 0 until 9) {
            listItems[i] = "ITEM #$i"
        }
        val adapter = ArrayAdapter(requireContext(), R.layout.simple_list_item_1, listItems)*/

        val data = ArrayList<Post>()
        for (i in 1..20) {
            data.add(Post(1, "Contrato No. $i", "Estado: Activo", "Content Conten"))
        }
        val adapter = ItemContractAdapter(data)
        binding.contractsListView.layoutManager = LinearLayoutManager(context)
        binding.contractsListView.adapter = adapter
        return binding.root
    }
/*https://www.raywenderlich.com/6430697-view-binding-tutorial-for-android-getting-started*/
}