package com.example.uts_mobile.ui.drama

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.uts_mobile.databinding.ItemDramaBinding

class DramaAdapter(private val listDrama: ArrayList<drama>) :
    RecyclerView.Adapter<DramaAdapter.ListViewHolder>() {

    private lateinit var onItemClickCallback: OnItemClickCallback

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    inner class ListViewHolder(private val binding: ItemDramaBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(drama: drama) {
            with(binding) {
                itemJudul.text = drama.name
                itemDetail.text = drama.detail
                Glide.with(itemView.context)
                    .load(drama.photo)
                    .into(itemFoto)

                itemView.setOnClickListener {
                    onItemClickCallback.onItemClicked(drama)
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val binding =
            ItemDramaBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ListViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        holder.bind(listDrama[position])
    }

    override fun getItemCount(): Int = listDrama.size

    interface OnItemClickCallback {
        fun onItemClicked(data: drama)
    }
}