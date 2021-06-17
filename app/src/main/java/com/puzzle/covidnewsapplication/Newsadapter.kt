package com.puzzle.covidnewsapplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import java.util.ArrayList
import com.bumptech.glide.Glide


class NewsListAdaptor(private val listener: MainActivity2) : RecyclerView.Adapter<NewsListAdaptor.NewsViewHolder>() {

    private val items:ArrayList<News> = ArrayList()

    class NewsViewHolder(itemView:View) : RecyclerView.ViewHolder(itemView){

        val titleView:TextView = itemView.findViewById(R.id.title)
        val image: ImageView = itemView.findViewById(R.id.image)
        val author:TextView = itemView.findViewById(R.id.author)

}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_list,parent,false)
        val viewHolder = NewsViewHolder(view)
        view.setOnClickListener{
            listener.ItemClick(items[viewHolder.adapterPosition])
        }
        return viewHolder
    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        val currentItem = items[position]
        holder.titleView.text = currentItem.title
        holder.author.text = currentItem.author

        Glide.with(holder.itemView.context).load(currentItem.imageUrl).into(holder.image)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    fun updateNews(updatedNews:ArrayList<News>){
        items.clear()
        items.addAll(updatedNews)

        notifyDataSetChanged()
    }
}

interface OnItemClicked{
    fun ItemClick(items:News)
}