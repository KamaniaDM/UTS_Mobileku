package com.example.uts_mobile.ui.film

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.uts_mobile.databinding.ItemFilmBinding

class FilmAdapter(private val listFilm: ArrayList<Film>) :
    RecyclerView.Adapter<FilmAdapter.ListViewHolder>() {

    private lateinit var onItemClickCallback: OnItemClickCallback

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    inner class ListViewHolder(private val binding: ItemFilmBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(film: Film) {
            with(binding) {
                itemJudul.text = film.name
                itemDetail.text = film.detail
                Glide.with(itemView.context)
                    .load(film.photo)
                    .into(itemFoto)

                itemView.setOnClickListener {
                    onItemClickCallback.onItemClicked(film)
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val binding =
            ItemFilmBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ListViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        holder.bind(listFilm[position])
    }

    override fun getItemCount(): Int = listFilm.size

    interface OnItemClickCallback {
        fun onItemClicked(data: Film)
    }
}

