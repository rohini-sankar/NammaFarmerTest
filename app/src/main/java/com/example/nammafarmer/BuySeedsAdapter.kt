package com.example.nammafarmer

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.example_item.view.*

class BuySeedsAdapter(private val exampleList: List<BuySeeds>) : RecyclerView.Adapter<BuySeedsAdapter.BuySeedsViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BuySeedsViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.example_item, parent, false)
        return BuySeedsViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: BuySeedsViewHolder, position: Int) {
        val currentItem = exampleList[position]

        holder.name.text = currentItem.name
        holder.phone.text = currentItem.phone
        holder.email.text = currentItem.email
    }

    override fun getItemCount(): Int {
        return exampleList.size
    }


    class BuySeedsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val name = itemView.textName
        val phone = itemView.textPhone
        val email = itemView.textEMail
    }
}