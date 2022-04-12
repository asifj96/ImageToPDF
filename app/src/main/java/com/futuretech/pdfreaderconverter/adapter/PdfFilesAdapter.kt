package com.futuretech.pdfreaderconverter.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.futuretech.pdfreaderconverter.R
import com.futuretech.pdfreaderconverter.databinding.ItemListPdfFilesBinding
import com.futuretech.pdfreaderconverter.extension.disableClick
import com.futuretech.pdfreaderconverter.extension.getDate
import com.futuretech.pdfreaderconverter.extension.getSize
import com.futuretech.pdfreaderconverter.model.PdfFile
import com.futuretech.pdfreaderconverter.utility.Constants.ACTION_DELETE
import com.futuretech.pdfreaderconverter.utility.Constants.ACTION_OPEN
import com.futuretech.pdfreaderconverter.utility.Constants.ACTION_RENAME
import com.futuretech.pdfreaderconverter.utility.Constants.ACTION_SEARCH
import com.futuretech.pdfreaderconverter.utility.Constants.ACTION_SHARE
import java.util.*


class PdfFilesAdapter(
    private val clickAction: (PdfFile, Int, Int) -> Unit,
    private val searchAction: (List<PdfFile>?, Int) -> Unit,
) : ListAdapter<PdfFile, RecyclerView.ViewHolder>(DiffCallback()), Filterable {

    private var documentFileArrayList: ArrayList<PdfFile>? = null
    fun setAdapterList(documentFileArrayList: ArrayList<PdfFile>?) {
//        this.documentFileArrayList?.clear()
//        this.documentFileArrayList?.addAll(documentFileArrayList!!)
        this.documentFileArrayList = documentFileArrayList
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        val binding: ItemListPdfFilesBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.item_list_pdf_files,
            parent,
            false
        )
        return DocumentFilesViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val item = currentList[position]

        (holder as DocumentFilesViewHolder).bindItems(item)

    }

    inner class DocumentFilesViewHolder(private val binding: ItemListPdfFilesBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bindItems(documentFile: PdfFile) {

            binding.tvTitle.isSelected = true
            binding.tvTitle.text = documentFile.name
            binding.tvSize.text = itemView.context.getSize(documentFile.size.toULong().toLong())
            binding.tvDateTime.text = itemView.context.getDate(documentFile.date.toULong().toLong())

            binding.iVShareFile.setOnClickListener {
                if (disableClick()) {
                    clickAction.invoke(documentFile, ACTION_SHARE, absoluteAdapterPosition)
                }
            }
            binding.iVRenameFile.setOnClickListener {
                if (disableClick()) {
                    clickAction.invoke(documentFile, ACTION_RENAME, absoluteAdapterPosition)
                }
            }
            binding.iVDeleteFile.setOnClickListener {
                if (disableClick()) {
                    clickAction.invoke(documentFile, ACTION_DELETE, absoluteAdapterPosition)
                }
            }
            binding.root.setOnClickListener {
                if (disableClick()) {
                    clickAction.invoke(documentFile, ACTION_OPEN, absoluteAdapterPosition)
                }
            }
        }
    }

    override fun getFilter(): Filter {
        return object : Filter() {
            override fun performFiltering(constraint: CharSequence?): FilterResults {
                val charSearch = constraint.toString()
                val fileListFiltered = if (charSearch.isEmpty()) {
                    documentFileArrayList
                } else {
                    val resultList = ArrayList<PdfFile>()
                    for (row in documentFileArrayList!!) {
                        if (row.name.lowercase(Locale.ROOT)
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
                val files: List<PdfFile> = results?.values as List<PdfFile>
                submitList(files)
                searchAction.invoke(files, ACTION_SEARCH)
            }
        }
    }

    override fun setHasStableIds(hasStableIds: Boolean) {
        super.setHasStableIds(hasStableIds)
    }
}

private class DiffCallback : DiffUtil.ItemCallback<PdfFile>() {

    override fun areItemsTheSame(oldItem: PdfFile, newItem: PdfFile): Boolean {
        return oldItem.name == newItem.name
    }

    override fun areContentsTheSame(oldItem: PdfFile, newItem: PdfFile): Boolean {
        return oldItem == newItem
    }

}

