package com.example.inventory

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.inventory.database.Goods
import kotlinx.android.synthetic.main.custom_grid_layout.view.*


class GoodsAdapter: RecyclerView.Adapter<GoodsAdapter.MyViewHolder>() {

    private var goodsList = emptyList<Goods>()

    class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.fragment_item, parent, false))
    }

    override fun getItemCount(): Int {
        return goodsList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = goodsList[position]

        holder.itemView.imageViewBotas2.setImageResource(R.drawable.image1)
        holder.itemView.textViewModel2.text = currentItem.goodName.toString()
        holder.itemView.textViewCost2.text = currentItem.goodCost.toString()
        holder.itemView.textViewManufacturer2.text = currentItem.goodsManufacturer.toString()
        holder.itemView.textViewAmount2.text = currentItem.amountOfGoods.toString()



//        holder.itemView.rowLayout.setOnClickListener {
//            val action = ListFragmentDirections.actionListFragmentToUpdateFragment(currentItem)
//            holder.itemView.findNavController().navigate(action)
//        }
    }

    fun setData(user: List<Goods>){
        this.goodsList = user
        notifyDataSetChanged()
    }
}