package com.example.inventory

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class RecyclerAdapter : RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {

    var dataList = emptyList<DataModel>()


    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

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


            itemView.setOnClickListener {
//        var position: Int = getAdapterPosition()
//        val context = itemView.context
//        val intent = Intent(context, DetailPertanyaan::class.java).apply {
//            putExtra("NUMBER", position)
//            putExtra("CODE", itemKode.text)
//            putExtra("CATEGORY", itemKategori.text)
//            putExtra("CONTENT", itemIsi.text)
            }
//        context.startActivity(intent)


        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context)
            .inflate(R.layout.custom_grid_layout, parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        // Get the data model based on position
        var data = dataList[position]

        // Set item views based on your views and data model
        holder.imageBotas.setImageResource(data.img)
        holder.textViewAmount.text = data.amount.toString()
        holder.textViewCost.text = data.cost.toString()
        holder.textViewManufacturer.text = data.manufacturer
        holder.textViewModelName.text = data.modelName
    }

    override fun getItemCount(): Int = dataList.size

}
