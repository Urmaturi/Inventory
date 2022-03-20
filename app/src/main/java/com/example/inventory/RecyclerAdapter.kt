package com.example.inventory

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
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
        holder.itemView.textViewModel.text = dataTemp.goodName
        holder.itemView.textViewCost.text = dataTemp.goodCost.toString()
        holder.itemView.textViewAmount.text = dataTemp.amountOfGoods.toString()
        holder.itemView.textViewManufacturer.text = dataTemp.goodsManufacturer
        holder.itemView.imageViewBotas.setImageResource(R.drawable.image1)

    }

    override fun getItemCount(): Int = list.size

}
