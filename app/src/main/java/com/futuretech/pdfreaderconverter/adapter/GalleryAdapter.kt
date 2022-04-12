package com.futuretech.pdfreaderconverter.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.futuretech.pdfreaderconverter.databinding.ItemGalleryBinding
import com.futuretech.pdfreaderconverter.model.GalleryModel


class GalleryAdapter :
    ListAdapter<GalleryModel, RecyclerView.ViewHolder>(DiffClass()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return GalleryViewHolder(
            ItemGalleryBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val item = currentList[position]
        (holder as GalleryViewHolder).bindItems(item)
    }

    override fun getItemId(position: Int): Long = currentList[position].id.toLong()

    inner class GalleryViewHolder(private val binding: ItemGalleryBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bindItems(gallery: GalleryModel) {
            if (gallery.isSelected) {
                binding.iVSelected.visibility = View.VISIBLE
            } else {
                binding.iVSelected.visibility = View.INVISIBLE
            }
            Glide.with(itemView.context)
                .load(gallery.uri)
                .diskCacheStrategy(DiskCacheStrategy.AUTOMATIC)
                .into(binding.iVGalleryItem)

            binding.root.setOnClickListener {
                currentList[bindingAdapterPosition].isSelected =
                    !currentList[bindingAdapterPosition].isSelected
                notifyItemChanged(bindingAdapterPosition)
            }
        }
    }

    override fun setHasStableIds(hasStableIds: Boolean) {
        super.setHasStableIds(hasStableIds)
    }
}

private class DiffClass : DiffUtil.ItemCallback<GalleryModel>() {
    override fun areItemsTheSame(oldItem: GalleryModel, newItem: GalleryModel): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: GalleryModel, newItem: GalleryModel): Boolean {
        return oldItem == newItem
    }
}