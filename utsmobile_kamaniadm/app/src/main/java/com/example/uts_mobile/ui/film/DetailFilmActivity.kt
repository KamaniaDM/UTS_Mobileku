package com.example.uts_mobile.ui.film

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.uts_mobile.databinding.ActivityDetailFilmBinding
import com.example.uts_mobile.ui.drama.DetailDramaActivity


class DetailFilmActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_DATA = "extra_data"
        const val SEARCH_PREFIX = "https://www.google.com/search?q="
        const val SEARCH_PREFIX_YOUTUBE = "https://www.youtube.com/results?search_query="
    }

    private var _binding: ActivityDetailFilmBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        _binding = ActivityDetailFilmBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val data = intent.getParcelableExtra<Film>(EXTRA_DATA) ?: return

        binding.dtItemName.text = data.name
        binding.dtItemDetail.text = data.detail
        binding.dtItemFoto.setImageResource(data.photo)

        binding.button.setOnClickListener {
            val queryUrl: Uri = Uri.parse("${DetailDramaActivity.SEARCH_PREFIX}${data.name}")
            val intent = Intent(Intent.ACTION_VIEW, queryUrl)
            startActivity(intent)
        }
        binding.buttonYouTube.setOnClickListener {
            val queryUrl: Uri = Uri.parse("${DetailDramaActivity.SEARCH_PREFIX_YOUTUBE}${data.name}")
            val intent = Intent(Intent.ACTION_VIEW, queryUrl)
            startActivity(intent)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}
