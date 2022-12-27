package com.example.redditnews.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.redditnews.R
import com.example.redditnews.databinding.ItemNewsBinding
import com.example.redditnews.pojo.Data


class NewsRecyclerAdapter : RecyclerView.Adapter<NewsRecyclerAdapter.Holder>() {
    private lateinit var list : List<Data>
    private lateinit var onClickOnItem : OnClickOnItem

    interface OnClickOnItem {
        fun onClick1(data: Data)
    }

    fun setList (list : List<Data>){
        this.list = list
    }

    fun setOnItemClickListener (listener : OnClickOnItem){
        onClickOnItem = listener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val binding : ItemNewsBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.context), R.layout.item_news,parent,false) //Initialize binding
        return Holder(binding)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.holderBinding.data = list[position]
    }

    override fun getItemCount(): Int {
        return list.size

    }

   inner class Holder(binding: ItemNewsBinding) : RecyclerView.ViewHolder(binding.root) {
         val holderBinding : ItemNewsBinding = binding

        init {
            binding.root.setOnClickListener {
                val position: Int = adapterPosition
                if (position != RecyclerView.NO_POSITION) {
                    // you can trust the adapter position
                    // do whatever you intend to do with this position
                    if (onClickOnItem != null)
                        onClickOnItem.onClick1(list[adapterPosition])

                }
            }
        }

    }
}