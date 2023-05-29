package com.example.uts_mobile.ui.drama

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.uts_mobile.R
import com.example.uts_mobile.databinding.ActivityDetailDrakorBinding


class DetailDramaActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_DATA = "extra_data"
        const val SEARCH_PREFIX = "https://www.google.com/search?q="
        const val SEARCH_PREFIX_YOUTUBE = "https://www.youtube.com/results?search_query="
    }

    private var _binding: ActivityDetailDrakorBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_drakor)

        _binding = ActivityDetailDrakorBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val data = intent.getParcelableExtra<drama>(EXTRA_DATA) ?: return

        binding.dtItemName.text = data.name
        binding.dtItemDetail.text = data.detail
        binding.dtItemFoto.setImageResource(data.photo)

        binding.button.setOnClickListener {
            val queryUrl: Uri = Uri.parse("${SEARCH_PREFIX}${data.name}")
            val intent = Intent(Intent.ACTION_VIEW, queryUrl)
            startActivity(intent)
        }
        binding.buttonYouTube.setOnClickListener {
            val queryUrl: Uri = Uri.parse("${SEARCH_PREFIX_YOUTUBE}${data.name}")
            val intent = Intent(Intent.ACTION_VIEW, queryUrl)
            startActivity(intent)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}