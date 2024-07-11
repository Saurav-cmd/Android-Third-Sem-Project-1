package com.saurav1201474.myapplication.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import bhuwan.TimesWireModal
import com.bumptech.glide.Glide
import com.saurav1201474.myapplication.R


class TimesWireAdapter(
    private val context: Context,
    private val timesWires: MutableList<TimesWireModal>
) : RecyclerView.Adapter<TimesWireAdapter.TimesWireViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TimesWireViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.articles_design, parent, false)
        return TimesWireViewHolder(view)
    }

    override fun getItemCount(): Int {
        return timesWires.size
    }

    override fun onBindViewHolder(holder: TimesWireViewHolder, position: Int) {
        holder.bind(timesWires[position])
    }

    fun updateTimeWire(timeWire: List<TimesWireModal>) {
        timesWires.clear()
        timesWires.addAll(timeWire)
        notifyDataSetChanged()
    }


    inner class TimesWireViewHolder(private val itemView: View) :
        RecyclerView.ViewHolder(itemView) {
        private val image: ImageView = itemView.findViewById(R.id.imageView)
        private val leadParagraphTv: TextView = itemView.findViewById(R.id.leadParagraphTV)
        private val copyrightTv: TextView = itemView.findViewById(R.id.copyrightTV)

        fun bind(news: TimesWireModal) {
            val result = news.results?.firstOrNull()
            result?.let {
                leadParagraphTv.text = it.abstract
                copyrightTv.text = news.copyright

                // Load the first multimedia item, if it exists
                val multimediaUrl = it.multimedia?.firstOrNull()?.url
                if (!multimediaUrl.isNullOrEmpty()) {
                    Glide.with(context)
                        .load(multimediaUrl)
                        .placeholder(R.drawable.newspaper_free_download_png)
                        .error(R.drawable.newspaper_free_download_png)
                        .into(image)
                } else {
                    // Handle case where there's no multimedia
//                    image.setImageResource(R.drawable.placeholder_image) // Use a placeholder image
                }
            }
        }
    }
}

