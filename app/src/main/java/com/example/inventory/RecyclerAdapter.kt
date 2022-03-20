package com.example.inventory

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.inventory.database.Goods
import kotlinx.android.synthetic.main.custom_grid_layout.view.*


class RecyclerAdapter : RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {

    var list = emptyList<Goods>()


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context)
            .inflate(R.layout.custom_grid_layout, parent, false)
        return ViewHolder(v)
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setListData(liste: List<Goods>)
    {
        list = liste
        notifyDataSetChanged()
    }


     class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        // Get the data model based on position
        var dataTemp = list[position]
        holder.itemView.textViewModel2.text = dataTemp.goodName
        holder.itemView.textViewCost2.text = dataTemp.goodCost.toString()
        holder.itemView.textViewAmount2.text = dataTemp.amountOfGoods.toString()
        holder.itemView.textViewManufacturer2.text = dataTemp.goodsManufacturer
        holder.itemView.imageViewBotas2.setImageResource(R.drawable.image1)
    }

    override fun getItemCount(): Int = list.size

}
