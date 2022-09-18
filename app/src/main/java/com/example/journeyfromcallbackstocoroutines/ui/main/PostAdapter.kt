package com.example.journeyfromcallbackstocoroutines.ui.main

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.journeyfromcallbackstocoroutines.databinding.TimelinePostItemBinding
import com.example.journeyfromcallbackstocoroutines.pojo.Post

class PostAdapter : ListAdapter<Post, PostAdapter.PostVH>(DiffUtil()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostVH {
        val bind = TimelinePostItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PostVH(bind)
    }

    override fun onBindViewHolder(holder: PostVH, position: Int) {
        holder.bind(currentList[position])
    }

    inner class PostVH (val bind : TimelinePostItemBinding): RecyclerView.ViewHolder(bind.root){
        init{
            itemView.setOnClickListener {

            }
        }
        fun bind(data : Post){
            bind.userNameTV.text = data.title
            bind.postBodyTV.text = data.body

        }
    }

    class DiffUtil(): androidx.recyclerview.widget.DiffUtil.ItemCallback<Post>(){
        override fun areItemsTheSame(oldItem: Post, newItem: Post): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: Post, newItem: Post): Boolean {
            return oldItem == newItem
        }

    }
}