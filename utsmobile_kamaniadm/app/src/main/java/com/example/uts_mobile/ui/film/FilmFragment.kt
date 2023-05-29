package com.example.uts_mobile.ui.film

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.uts_mobile.databinding.FragmentFilmBinding

class FilmFragment : Fragment() {
    private var list: ArrayList<Film> = arrayListOf()
    private var _binding: FragmentFilmBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentFilmBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val rvFilm = binding.rvFilm
        rvFilm.layoutManager = LinearLayoutManager(context)

        list.addAll(FilmData.listData)

        val filmAdapter = FilmAdapter(list)
        rvFilm.adapter = filmAdapter

        filmAdapter.setOnItemClickCallback(object : FilmAdapter.OnItemClickCallback {
            override fun onItemClicked(data: Film) {
                val intent = Intent(requireContext(), DetailFilmActivity::class.java)
                intent.putExtra(DetailFilmActivity.EXTRA_DATA, data)
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
