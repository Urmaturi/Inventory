package com.example.inventory

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import kotlinx.android.synthetic.main.fragment_inventory.*

class InventoryFragment : Fragment() {

    private lateinit var adapter: ItemAdapter
    private var dataList = mutableListOf<DataModel>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {




            recyclerView.layoutManager = GridLayoutManager(applicationContext, 2)
            adapter = ItemAdapter(applicationContext)
            recyclerView.adapter = adapter
            dataList.add(DataModel("Shinamo 6000", 200, "Nike", 50, R.drawable.image1))
            dataList.add(DataModel("Shinamo 6000", 200, "Nike", 50, R.drawable.image2))
            adapter.setDataList(dataList)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        return inflater.inflate(R.layout.fragment_inventory, container, false)
    }


}