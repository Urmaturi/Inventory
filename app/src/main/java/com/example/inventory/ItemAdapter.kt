package com.example.inventory

import android.content.Context
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView



class ItemAdapter(var context: Context) : RecyclerView.Adapter<ItemAdapter.ViewHolder>() {

    var dataList = emptyList<DataModel>()

    internal fun setDataList(dataList: List<DataModel>) {
        this.dataList = dataList
    }

    // Provide a direct reference to each of the views with data items

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var imageBotas: ImageView
        var textViewModelName: TextView
        var textViewCost: TextView
        var textViewManufacturer: TextView
        var textViewAmount: TextView


        init {
            imageBotas = itemView.findViewById(R.id.imageViewBotas)
            textViewModelName = itemView.findViewById(R.id.textViewModel)
            textViewCost = itemView.findViewById(R.id.textViewCost)
            textViewManufacturer = itemView.findViewById(R.id.textViewManufacturer)
            textViewAmount = itemView.findViewById(R.id.textViewAmount)
        }

    }

    // Usually involves inflating a layout from XML and returning the holder
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemAdapter.ViewHolder {

        // Inflate the custom layout
        var view =
            LayoutInflater.from(parent.context).inflate(R.layout.fragment_item, parent, false)
        return ViewHolder(view)
    }

    // Involves populating data into the item through holder
    override fun onBindViewHolder(holder: ItemAdapter.ViewHolder, position: Int) {

        // Get the data model based on position
        var data = dataList[position]

        // Set item views based on your views and data model
        holder.imageBotas.setImageResource(data.img)
        holder.textViewAmount.text = data.amount.toString()
        holder.textViewCost.text = data.cost.toString()
        holder.textViewManufacturer.text = data.manufacturer
        holder.textViewModelName.text = data.modelName

    }

    //  total count of items in the list
    override fun getItemCount() = dataList.size
}