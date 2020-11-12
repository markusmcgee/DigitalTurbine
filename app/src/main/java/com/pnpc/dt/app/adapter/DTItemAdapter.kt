package com.pnpc.dt.app.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.pnpc.dt.app.R
import com.pnpc.dt.app.viewmodel.AdsViewModel
import com.squareup.picasso.MemoryPolicy
import com.squareup.picasso.NetworkPolicy
import com.squareup.picasso.Picasso

class DTItemAdapter(val viewModel:AdsViewModel?) : RecyclerView.Adapter<DTItemAdapter.ViewHolder>() {

    private val layoutResourceId: Int = R.layout.item_list_item_view
    private lateinit var data: ArrayList<Any>

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val productNameText: TextView = itemView.findViewById(R.id.product_name_text)
        private val productRatingText: TextView = itemView.findViewById(R.id.product_rating_text)
        private val productImageView: ImageView = itemView.findViewById(R.id.product_image)
        private val productRatingImageView: ImageView = itemView.findViewById(R.id.product_rating_image)

        fun bind(itemData: Any) {
            productNameText.text = (itemData as Map<*, *>)["productName"].toString()
            productRatingText.text = itemData["rating"].toString()

            itemData["productThumbnail"]?.let {
                Picasso.get()
                        .load(it.toString())
                        .memoryPolicy(MemoryPolicy.NO_CACHE, MemoryPolicy.NO_STORE)
                        .networkPolicy(NetworkPolicy.NO_CACHE, NetworkPolicy.NO_STORE)
                        .into(productImageView)
            }

            itemData["averageRatingImageURL"]?.let {
                Picasso.get()
                        .load(it.toString())
                        .memoryPolicy(MemoryPolicy.NO_CACHE, MemoryPolicy.NO_STORE)
                        .networkPolicy(NetworkPolicy.NO_CACHE, NetworkPolicy.NO_STORE)
                        .into(productRatingImageView)
            }

        }
    }

    fun replaceItems(incomingData: ArrayList<Any>){
        data = incomingData
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(layoutResourceId, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val itemData = data[position]
        holder.bind(itemData)
        holder.itemView.setOnClickListener {
            viewModel?.selectedAd?.value = itemData
        }
    }

    override fun getItemCount() = data.size

}