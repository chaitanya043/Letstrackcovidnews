package com.puzzle.covidnewsapplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import java.util.ArrayList

private val items: ArrayList<News> = ArrayList()

class NewsAdaptor2(private val listener1:OnItemClicked) : RecyclerView.Adapter<NewsListAdaptor.NewsViewHolder>() {

    val titleView1: TextView = itemView.findViewById(R.id.title1)
    val image1: ImageView = itemView.findViewById(R.id.image1)
    val author1: TextView = itemView.findViewById(R.id.author1)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsAdaptor2.NewsViewHolder {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: NewsAdaptor2.NewsViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

}

override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsListAdaptor.NewsViewHolder {
    val view = LayoutInflater.from(parent.context).inflate(R.layout.item_list,parent,false)
    val viewHolder = NewsListAdaptor.NewsViewHolder(view)
    view.setOnClickListener{
        listener1.ItemClick(items[viewHolder.adapterPosition])
    }
    return viewHolder
}

 fun onBindViewHolder(holder: NewsAdaptor2.NewsViewHolder, position: Int) {
    val currentItem = items[position]
    holder.titleView1.text = currentItem.title
    holder.author1.text = currentItem.author

    Glide.with(holder.itemView.context).load(currentItem.imageUrl).into(holder.image1)
}

fun getItemCount(): Int {
    return items.size
}

fun updateNews(updatedNews: ArrayList<News>){
    items.clear()
    items.addAll(updatedNews)

}


interface OnItemClicked1 {
    fun ItemClick(items: News)
}