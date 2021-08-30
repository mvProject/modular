package com.mvproject.firstappmodule

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.mvproject.base.model.ItemModel
import com.mvproject.firstappmodule.databinding.ItemListBinding

class TestListAdapter(private val onItemClickListener: OnItemClickListener) :
    RecyclerView.Adapter<TestListAdapter.ItemViewHolder>() {
    fun interface OnItemClickListener {
        fun onItemClick(supporter: ItemModel?)
    }

    private val diffCallback = object : DiffUtil.ItemCallback<ItemModel>() {
        override fun areItemsTheSame(oldItem: ItemModel, newItem: ItemModel): Boolean {
            return oldItem.name == newItem.name
        }

        override fun areContentsTheSame(oldItem: ItemModel, newItem: ItemModel): Boolean {
            return oldItem == newItem
        }
    }

    private val differ = AsyncListDiffer(this, diffCallback)
    var clubs: List<ItemModel>
        get() = differ.currentList
        set(value) {
            differ.submitList(value)
        }

    override fun getItemCount() = clubs.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        return ItemViewHolder(
            ItemListBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
        ))
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.binding.apply {
            val club = clubs[position]
            clubName.text = club.name
            clubCountry.text = club.city

            root.setOnClickListener {
                onItemClickListener.onItemClick(club)
            }
        }
    }

    inner class ItemViewHolder(val binding: ItemListBinding) : RecyclerView.ViewHolder(binding.root)
}
