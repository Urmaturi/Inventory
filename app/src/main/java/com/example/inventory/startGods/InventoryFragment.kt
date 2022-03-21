package com.example.inventory.startGods

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.inventory.APP
import com.example.inventory.ItemAdapter
import com.example.inventory.R
import com.example.inventory.RecyclerAdapter
import com.example.inventory.databinding.FragmentInventoryBinding

class InventoryFragment : Fragment() {

     lateinit var binding: FragmentInventoryBinding
    lateinit var recyclerView: RecyclerView
    lateinit var adapter: ItemAdapter

    private lateinit var mUserViewModel: ViewModel

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

        //init()
        return binding.root
    }

    fun fillRecicleView
    {
        val adapter = ListAdapter()
        val recyclerView = view.recyclerview
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        // UserViewModel
        mUserViewModel = ViewModelProvider(this).get(UserViewModel::class.java)
        mUserViewModel.readAllData.observe(viewLifecycleOwner, Observer { user ->
            adapter.setData(user)
        })
    }






    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        super.onViewCreated(view, savedInstanceState)


        binding.btnAddNewGoods.setOnClickListener {
            val navController = APP.findNavController(R.id.nav_host_fragment)
            navController.navigate(R.id.action_navi_inventory_main_to_navi_add_model)
        }
    }

//    private fun init() {
//        val viewModel = ViewModelProvider(this).get(FragmentInventoryViewModel::class.java)
//        viewModel.initDataBase()
//        recyclerView = binding.recyclerViewHome
////        recyclerView.layoutManager =LinearLayoutManager(requireContext())
//        adapter = ItemAdapter()
//        recyclerView.adapter = adapter
//        viewModel.getAllGoods().observe(this, { dataList ->
//            adapter.setListData(dataList)
//        })
//    }
}