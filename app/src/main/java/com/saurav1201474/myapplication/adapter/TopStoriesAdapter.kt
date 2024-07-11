package com.saurav1201474.myapplication.adapter

import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.saurav1201474.myapplication.R
import com.saurav1201474.myapplication.constants.ImageConcat
import com.saurav1201474.myapplication.models.Result
import com.saurav1201474.myapplication.view.WebDesignActivity

class TopStoriesAdapter(private val context: Context, private val topStories: MutableList<Result>) :
    RecyclerView.Adapter<TopStoriesAdapter.TopStoriesViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TopStoriesViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.articles_design, parent, false)
        return TopStoriesViewHolder(view)
    }

    override fun getItemCount(): Int {
        return topStories.size
    }

    override fun onBindViewHolder(holder: TopStoriesViewHolder, position: Int) {
        holder.bind(topStories[position])
    }

    fun updateTopStory(topStory: List<Result>) {
        topStories.clear()
        topStories.addAll(topStory)
        notifyDataSetChanged()
    }

    inner class TopStoriesViewHolder(private val itemView: View) :
        RecyclerView.ViewHolder(itemView) {
        private val image: ImageView = itemView.findViewById(R.id.imageView)
        private val title: TextView = itemView.findViewById(R.id.leadParagraphTV)
        private val copyrightTv: TextView = itemView.findViewById(R.id.copyrightTV)


        fun bind(topStories: Result) {
            val multimedia = topStories.multimedia
            if (!multimedia.isNullOrEmpty()) {
                val imageUrl = multimedia[0].url
                if (!imageUrl.isNullOrEmpty()) {
                    val fullImageUrl = ImageConcat.concatImage("", imageUrl)
                    Log.d("TopStoriesAdapter", "Loading image: $fullImageUrl")
                    Glide.with(itemView.context)
                        .load(fullImageUrl)
                        .into(image)
                } else {
                    image.setImageURI(null)
                }
            } else {
                image.setImageURI(null)
            }
            title.text = topStories.title
//            copyrightTv.text = topStories.abstract

            itemView.setOnClickListener {
                val url = topStories.url
                if (!url.isNullOrEmpty()) {
                    val intent = Intent(context, WebDesignActivity::class.java)
                    intent.putExtra("Url", url)
                    context.startActivity(intent)
                }
            }
        }
    }
}
