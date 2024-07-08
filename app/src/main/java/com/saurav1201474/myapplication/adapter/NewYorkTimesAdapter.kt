package com.saurav1201474.myapplication.adapter

import Doc
import android.content.Context
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.saurav1201474.myapplication.R
import com.saurav1201474.myapplication.constants.ImageConcat


class NewYorkTimesAdapter(
    private val context: Context,
    private var articles: MutableList<Doc>
) : RecyclerView.Adapter<NewYorkTimesAdapter.NewYorkViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewYorkViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.articles_design, parent, false)
        return NewYorkViewHolder(view)
    }

    override fun getItemCount(): Int {
        return articles.size
    }

    override fun onBindViewHolder(holder: NewYorkViewHolder, position: Int) {
        holder.bind(articles[position])
    }

    fun updateArticles(newArticles: List<Doc>) {
        articles.clear()
        articles.addAll(newArticles)
        notifyDataSetChanged()
    }

    inner class NewYorkViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        //        private val abstractTv: TextView = itemView.findViewById(R.id.abstractTv)
//        private val snippetTv: TextView = itemView.findViewById(R.id.snippetTV)
        private val image: ImageView = itemView.findViewById(R.id.imageView)
        private val leadParagraphTv: TextView = itemView.findViewById(R.id.leadParagraphTV)
//        private val sourceTv: TextView = itemView.findViewById(R.id.sourceTV)

        fun bind(article: Doc) {
            val multimedia = article.multimedia
            if (!multimedia.isNullOrEmpty()) {
                val imageUrl = multimedia[0].url
                if (!imageUrl.isNullOrEmpty()) {
                    val fullImageUrl = ImageConcat.concatImage("https://www.nytimes.com/", imageUrl)
                    Glide.with(itemView.context)
                        .load(fullImageUrl)
                        .into(image)
                } else {
                    image.setImageURI(null)
                }
            } else {
                image.setImageURI(null)
            }

            leadParagraphTv.text = article.lead_paragraph
        }
    }

}
