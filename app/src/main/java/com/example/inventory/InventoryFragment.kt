package com.example.inventory

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.NavHostFragment
import androidx.recyclerview.widget.GridLayoutManager
import kotlinx.android.synthetic.main.fragment_add_new_model.view.*
import kotlinx.android.synthetic.main.fragment_inventory.*
import kotlinx.android.synthetic.main.fragment_inventory.view.*
import kotlinx.android.synthetic.main.fragment_inventory_archive.*

class InventoryFragment : Fragment() {

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
//        val navController = NavHostFragment.findNavController(this)
//        val fragmentLayout = inflater.inflate(R.layout.fragment_inventory,container,false)
//
//        fragmentLayout.imageViewAddNewModel.setOnClickListener{navController.navigate(R.id.navi_add_model)}
//
//        return fragmentLayout
        return inflater.inflate(R.layout.fragment_inventory, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerViewHome.layoutManager = GridLayoutManager(view.context, 2)

        adapter = ItemAdapter(view.context)
        recyclerViewHome.adapter = adapter
        dataList.add(DataModel("Shinamo 6000", 200, "Nike", 50, R.drawable.image1))
        dataList.add(DataModel("Shinamo 6000", 200, "Nike", 50, R.drawable.image2))
        dataList.add(DataModel("Shinamo 6000", 200, "Nike", 50, R.drawable.image1))
        dataList.add(DataModel("Shinamo 6000", 200, "Nike", 50, R.drawable.image2))
        dataList.add(DataModel("Shinamo 6000", 200, "Nike", 50, R.drawable.image1))
        dataList.add(DataModel("Shinamo 6000", 200, "Nike", 50, R.drawable.image2))
        dataList.add(DataModel("Shinamo 6000", 200, "Nike", 50, R.drawable.image1))
        dataList.add(DataModel("Shinamo 6000", 200, "Nike", 50, R.drawable.image2))
        adapter.setDataList(dataList)
    }
}