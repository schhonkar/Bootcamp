package com.example.assesments

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MultiViewRecyclerAdapter(private val context: Context, private val listViewType: List<Int>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    companion object {
        const val TEXT_VIEW = 1
        const val IMAGE_VIEW = 2
        const val TEXT_WITH_IMAGE_VIEW = 3
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return when (viewType) {
            TEXT_VIEW -> ViewHolderText(inflater.inflate(R.layout.type_text, parent, false))
            IMAGE_VIEW -> ViewHolderImage(inflater.inflate(R.layout.type_image, parent, false))
            TEXT_WITH_IMAGE_VIEW -> ViewHolderImageText(inflater.inflate(R.layout.type_text_with_images, parent, false))
            else -> throw IllegalArgumentException("No Holder")
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (listViewType[position]) {
            TEXT_VIEW -> {
                val viewHolderText = holder as ViewHolderText
                viewHolderText.textView.text = context.getString(R.string.str1)
            }
            IMAGE_VIEW -> {
                val viewHolderImage = holder as ViewHolderImage
                viewHolderImage.offerImage.setBackgroundResource(if (position%3==0) R.drawable.img6 else R.drawable.pizza)
            }
            TEXT_WITH_IMAGE_VIEW -> {
                val restaurantViewHolder = holder as ViewHolderImageText
                restaurantViewHolder.restaurantText.text = context.getString(R.string.str2)
                restaurantViewHolder.restaurantImage.setBackgroundResource(if (position%2==0) R.drawable.ic_bank_offers else R.drawable.img5)
            }
            else -> {
                throw IllegalArgumentException("NoViews")
            }
        }
    }

    override fun getItemCount(): Int {
        return listViewType.size
    }

    override fun getItemViewType(position: Int): Int = listViewType[position]

    //View holders for each unique view type
    inner class ViewHolderText(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textView: TextView = itemView.findViewById(R.id.textView6)
    }

    inner class ViewHolderImage(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val offerImage: ImageView = itemView.findViewById(R.id.typeImg)
    }

    inner class ViewHolderImageText(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val restaurantText: TextView = itemView.findViewById(R.id.textView9)
        val restaurantImage: ImageView = itemView.findViewById(R.id.ImageView2)
    }

}