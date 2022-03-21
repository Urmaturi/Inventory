package com.example.inventory

import android.annotation.SuppressLint
import android.content.Context
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.inventory.database.Goods
import kotlinx.android.synthetic.main.custom_grid_layout.view.*
import kotlinx.android.synthetic.main.custom_grid_layout.view.imageViewBotas2
import kotlinx.android.synthetic.main.custom_grid_layout.view.textViewAmount2
import kotlinx.android.synthetic.main.custom_grid_layout.view.textViewCost2
import kotlinx.android.synthetic.main.custom_grid_layout.view.textViewManufacturer2
import kotlinx.android.synthetic.main.custom_grid_layout.view.textViewModel2
import kotlinx.android.synthetic.main.fragment_item.view.*


class ItemAdapter  : RecyclerView.Adapter<ItemAdapter.ViewHolder>() {

    var dataList = emptyList<Goods>()

    @SuppressLint("NotifyDataSetChanged")
    fun setListData(liste: List<Goods>)
    {
        dataList = liste
        notifyDataSetChanged()
    }


    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context)
            .inflate(R.layout.fragment_item, parent, false)
        return ViewHolder(v)
    }



    override fun onBindViewHolder(holder: ItemAdapter.ViewHolder, position: Int) {

        var data = dataList[position]
        holder.itemView.imageViewBotas2.setImageResource(R.drawable.image1)
        holder.itemView.textViewModel2.text = data.goodName
        holder.itemView.textViewCost2.text = data.goodCost.toString()
        holder.itemView.textViewManufacturer2.text = data.goodsManufacturer
        holder.itemView.textViewAmount2.text = data.amountOfGoods.toString()


    }


    override fun getItemCount() = dataList.size
}