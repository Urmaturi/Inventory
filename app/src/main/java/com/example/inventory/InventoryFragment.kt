package com.example.inventory

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.NavHostFragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.inventory.database.Goods
import com.example.inventory.databinding.FragmentInventoryBinding
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_add_new_model.view.*
import kotlinx.android.synthetic.main.fragment_inventory.*
import kotlinx.android.synthetic.main.fragment_inventory.view.*
import kotlinx.android.synthetic.main.fragment_inventory_archive.*

class InventoryFragment : Fragment() {

    private lateinit var adapterOld: ItemAdapter
    private var dataList = mutableListOf<DataModel>()

    lateinit var binding: FragmentInventoryBinding
    lateinit var recyclerView: RecyclerView
    lateinit var adapter: RecyclerAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentInventoryBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        super.onViewCreated(view, savedInstanceState)
        init()

//        recyclerViewHome.layoutManager = GridLayoutManager(view.context, 2)
//
//        adapter = ItemAdapter(view.context)
//        recyclerViewHome.adapter = adapter
//        dataList.add(DataModel("Shinamo 6000", 200, "Nike", 50, R.drawable.image1))
//        dataList.add(DataModel("Shinamo 6000", 200, "Nike", 50, R.drawable.image2))
//        dataList.add(DataModel("Shinamo 6000", 200, "Nike", 50, R.drawable.image1))
//        dataList.add(DataModel("Shinamo 6000", 200, "Nike", 50, R.drawable.image2))
//        dataList.add(DataModel("Shinamo 6000", 200, "Nike", 50, R.drawable.image1))
//        dataList.add(DataModel("Shinamo 6000", 200, "Nike", 50, R.drawable.image2))
//        dataList.add(DataModel("Shinamo 6000", 200, "Nike", 50, R.drawable.image1))
//        dataList.add(DataModel("Shinamo 6000", 200, "Nike", 50, R.drawable.image2))
//        adapter.setDataList(dataList)
    }

    private fun init() {
        val viewModel = ViewModelProvider(this)[FragmentInventoryViewModel::class.java]
        viewModel.initDataBase()
        recyclerView = binding.recyclerViewHome
        adapter = RecyclerAdapter()
        recyclerView.adapter = adapter
        viewModel.getAllGoods().observe(viewLifecycleOwner) { dataList ->
            dataList.asReversed()
            adapter.setListData(dataList)

        }


        binding.imageViewAddNewModel.setOnClickListener {
            APP.

        }
    }
}