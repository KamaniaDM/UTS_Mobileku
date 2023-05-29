package com.example.uts_mobile.ui.drama

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.uts_mobile.databinding.FragmentDramaBinding

class DramaFragment : Fragment() {
    private var list: ArrayList<drama> = arrayListOf()
    private var _binding: FragmentDramaBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDramaBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val rvDrama = binding.rvDrama
        rvDrama.layoutManager = LinearLayoutManager(context)

        list.addAll(DramaData.listData)

        val dramaAdapter = DramaAdapter(list)
        rvDrama.adapter = dramaAdapter

        dramaAdapter.setOnItemClickCallback(object : DramaAdapter.OnItemClickCallback {
                override fun onItemClicked(data: drama) {
                val intent = Intent(requireContext(), DetailDramaActivity::class.java)
                intent.putExtra(DetailDramaActivity.EXTRA_DATA, data)
                startActivity(intent)
            }
        })

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
