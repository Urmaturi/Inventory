package com.example.inventory.ArchiveGoods

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_inventory_archive.*

import androidx.recyclerview.widget.LinearLayoutManager
import com.example.inventory.DataModel
import com.example.inventory.ItemAdapter
import com.example.inventory.R
import com.example.inventory.RecyclerAdapter

class InventoryArchiveFragment : Fragment() {

    private lateinit var adapter: ItemAdapter
    private var dataList = mutableListOf<DataModel>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        return inflater.inflate(R.layout.fragment_inventory_archive, container, false)
        }


    override fun onViewCreated(itemView: View, savedInstanceState: Bundle?) {
        super.onViewCreated(itemView, savedInstanceState)


        recyclerViewArchive.apply {
            // set a LinearLayoutManager to handle Android
            // RecyclerView behavior
            layoutManager = LinearLayoutManager (activity)
            // set the custom adapter to the RecyclerView
            adapter = RecyclerAdapter()

        }

    }


}