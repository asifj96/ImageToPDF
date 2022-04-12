package com.futuretech.pdfreaderconverter.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.futuretech.pdfreaderconverter.R
import com.futuretech.pdfreaderconverter.databinding.LayoutRootItemBinding
import com.futuretech.pdfreaderconverter.model.RootItem

class RootItemAdapter(
    private var rootItemList: MutableList<RootItem>,
    private val clickItem: (Int) -> Unit,
) : RecyclerView.Adapter<RootItemAdapter.RootItemViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RootItemViewHolder {
        val binding: LayoutRootItemBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.layout_root_item,
            parent,
            false
        )
        return RootItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RootItemViewHolder, position: Int) {

        val rootItem = rootItemList[position]

        if (rootItemList.size > 0) {
            holder.bindItems(rootItem)
        }
    }

    override fun getItemCount(): Int {
        return if (rootItemList.size > 0) {
            rootItemList.size
        } else {
            return 0
        }
    }

    inner class RootItemViewHolder(private var binding: LayoutRootItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bindItems(
            rootItem: RootItem,
        ) {
            binding.tvTitle.text = rootItem.title
            binding.iVIcon.setImageResource(rootItem.icon)

            binding.root.setOnClickListener {
                clickItem.invoke(bindingAdapterPosition)
            }
        }

    }
}
