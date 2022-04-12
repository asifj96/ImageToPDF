package com.futuretech.pdfreaderconverter.ui.filter

import android.graphics.Bitmap
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.Transformation
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import com.futuretech.pdfreaderconverter.R
import com.futuretech.pdfreaderconverter.extension.disableClick
import com.futuretech.pdfreaderconverter.model.FilterScreenModel
import com.google.android.material.card.MaterialCardView


class FiltersScreenAdapter(
    private val clickItem: (FilterScreenModel, Int) -> Unit,
) : ListAdapter<FilterScreenModel, FiltersScreenAdapter.FiltersViewHolder>(DiffCallback()) {

    private val colorFilter: ColorFilters = ColorFilters()
    var selectedPos = 0

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FiltersViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_filter_list, parent, false)
        return FiltersViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: FiltersViewHolder, position: Int) {
        holder.bindItems(currentList[position], fun(item: FilterScreenModel) {
            if (position != selectedPos) {
                currentList[position].isSelected = true
                notifyItemChanged(position)
                currentList[selectedPos].isSelected = false
                notifyItemChanged(selectedPos)
                selectedPos = position
            }
            clickItem.invoke(item, position)
        })

    }

    inner class FiltersViewHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView) {
        private var ivEffectView =
            itemView.findViewById(R.id.iv_effect_view) as ImageView
        private var iVSelectedFilter =
            itemView.findViewById(R.id.iVSelectedFilter) as ImageView
        private var tvEffectName =
            itemView.findViewById(R.id.tv_effect_name) as TextView
        private var mCVItem =
            itemView.findViewById(R.id.mCVItem) as MaterialCardView

        fun bindItems(
            filterModel: FilterScreenModel,
            function: (FilterScreenModel) -> Unit,
        ) {
            tvEffectName.text = filterModel.filterName
            iVSelectedFilter.visibility = if (filterModel.isSelected) View.VISIBLE else View.GONE
            Glide.with(itemView.context)
                .load(getFilter(filterModel.bitmap)!!)
                .circleCrop()
                .diskCacheStrategy(DiskCacheStrategy.NONE)
                .skipMemoryCache(true)
                .into(ivEffectView)

            itemView.setOnClickListener {
                if (disableClick()) {
                    function.invoke(filterModel)
                }
            }
        }

        private fun getFilter(bitmap: Bitmap?) = when (absoluteAdapterPosition) {
            1 -> {
                colorFilter.filter1(itemView.context, bitmap!!)

            }
            2 -> {
                colorFilter.filter2(itemView.context, bitmap!!)

            }
            3 -> {
                colorFilter.filter3(itemView.context, bitmap!!)

            }
            4 -> {
                colorFilter.filter4(itemView.context, bitmap!!)

            }
            5 -> {
                colorFilter.filter5(itemView.context, bitmap!!)

            }
            6 -> {
                colorFilter.filter6(itemView.context, bitmap!!)

            }
            7 -> {
                colorFilter.filter7(itemView.context, bitmap!!)

            }
            8 -> {
                colorFilter.filter8(itemView.context, bitmap!!)

            }
            9 -> {
                colorFilter.filter9(itemView.context, bitmap!!)

            }
            10 -> {
                colorFilter.filter10(itemView.context, bitmap!!)

            }
            11 -> {
                colorFilter.filter11(itemView.context, bitmap!!)

            }
            else -> {
                bitmap
            }
        }
    }

}


private class DiffCallback : DiffUtil.ItemCallback<FilterScreenModel>() {
    override fun areItemsTheSame(oldItem: FilterScreenModel, newItem: FilterScreenModel): Boolean {
        return oldItem.filterName == newItem.filterName
    }

    override fun areContentsTheSame(
        oldItem: FilterScreenModel,
        newItem: FilterScreenModel
    ): Boolean {
        return oldItem == newItem
    }
}