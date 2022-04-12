package com.futuretech.pdfreaderconverter.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.futuretech.pdfreaderconverter.databinding.ItemHomeBinding
import com.futuretech.pdfreaderconverter.extension.disableClick
import com.futuretech.pdfreaderconverter.model.FileModel
import com.futuretech.pdfreaderconverter.utility.Constants.ACTION_DELETE
import com.futuretech.pdfreaderconverter.utility.Constants.ACTION_OPEN
import com.futuretech.pdfreaderconverter.utility.Constants.ACTION_RENAME
import com.futuretech.pdfreaderconverter.utility.Constants.ACTION_SEARCH
import com.futuretech.pdfreaderconverter.utility.Constants.ACTION_SHARE
import java.util.*


class HomeFilesAdapter(
    private val clickAction: (FileModel, Int) -> Unit,
    private val searchAction: (List<FileModel>, Int) -> Unit,
) : ListAdapter<FileModel, RecyclerView.ViewHolder>(DiffUtilCallback()), Filterable {


    private var homeFileArrayList: ArrayList<FileModel>? = null
    fun setAdapterList(homeFileArrayList: ArrayList<FileModel>?) {
        this.homeFileArrayList = homeFileArrayList
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        return HomeFilesViewHolder(
            ItemHomeBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }


    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val item = currentList[position]
        (holder as HomeFilesViewHolder).bindItems(item)
    }


    inner class HomeFilesViewHolder(private val binding: ItemHomeBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bindItems(fileModel: FileModel) {

            binding.tvTitle.text = fileModel.title
            binding.tvTitle.isSelected = true
            binding.tvNoOfDraftImages.text =
                (fileModel.imageQueueArrayList?.size).toString()
            binding.tvDate.text = fileModel.timestamp

            Glide.with(itemView.context)
                .load(fileModel.imageQueueArrayList!![0].uriPath!!)
                .diskCacheStrategy(DiskCacheStrategy.AUTOMATIC)
                .into(binding.iVDraft)

            binding.iVShareFile.setOnClickListener {
                if (disableClick()) {
                    clickAction.invoke(fileModel, ACTION_SHARE)
                }
            }
            binding.iVRenameFile.setOnClickListener {
                if (disableClick()) {
                    clickAction.invoke(fileModel, ACTION_RENAME)
                }
            }
            binding.iVDeleteFile.setOnClickListener {
                if (disableClick()) {
                    clickAction.invoke(fileModel, ACTION_DELETE)
                }
            }
            binding.root.setOnClickListener {
                if (disableClick()) {
                    clickAction.invoke(fileModel, ACTION_OPEN)
                }
            }
        }
    }

    override fun getFilter(): Filter {
        return object : Filter() {
            override fun performFiltering(constraint: CharSequence?): FilterResults {
                val charSearch = constraint.toString()
                val fileListFiltered = if (charSearch.isEmpty()) {
                    homeFileArrayList
                } else {
                    val resultList = ArrayList<FileModel>()
                    for (row in homeFileArrayList!!) {
                        if (row.title.lowercase(Locale.ROOT)
                                .contains(charSearch.lowercase(Locale.ROOT))
                        ) {
                            resultList.add(row)
                        }
                    }
                    resultList
                }
                val filterResults = FilterResults()
                filterResults.values = fileListFiltered
                return filterResults
            }

            @Suppress("UNCHECKED_CAST")
            override fun publishResults(constraint: CharSequence?, results: FilterResults?) {
                val files: List<FileModel> = results?.values as List<FileModel>
                submitList(files)
                searchAction.invoke(files, ACTION_SEARCH)

            }
        }
    }

    override fun setHasStableIds(hasStableIds: Boolean) {
        super.setHasStableIds(hasStableIds)
    }
}

private class DiffUtilCallback : DiffUtil.ItemCallback<FileModel>() {
    override fun areItemsTheSame(oldItem: FileModel, newItem: FileModel): Boolean {
//        return oldItem.title == newItem.title
        return oldItem.title == newItem.title
    }

    override fun areContentsTheSame(oldItem: FileModel, newItem: FileModel): Boolean {
        return oldItem == newItem
    }
}

