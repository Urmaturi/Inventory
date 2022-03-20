package com.example.inventory.addNewGods

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.example.inventory.APP
import com.example.inventory.R
import com.example.inventory.database.Goods
import com.example.inventory.database.GoodsDataBaseDao
import com.example.inventory.databinding.FragmentAddNewModelBinding
import java.lang.Exception

class AddNewModelFragment : Fragment() {

    lateinit var database: GoodsDataBaseDao
    lateinit var binding: FragmentAddNewModelBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()

    }

    private fun init() {
        binding.buttonAdd.setOnClickListener {

//            val name = binding.editTextName.text.toString()
//            val cost: Int = binding.editTextProductCost.text.toString().toInt()
//            val manufacturer = binding.editTextManufacturer.text.toString()
//            val number: Int = binding.editTextNumber.text.toString().toInt()
//            val archive = false
//
//
//            database.insert(   Goods(
//                        goodName = name,
//                        goodsManufacturer = manufacturer,
//                        goodCost = cost,
//                        amountOfGoods = number,
//                        archiveOfGoods = archive
//                    ))
//
//
//        }


            val viewModel = ViewModelProvider(this).get(AddNewGoodsViewModel::class.java)
            binding.buttonAdd.setOnClickListener {
                try {
                    val name = binding.editTextName.text.toString()
                    val cost: Int = binding.editTextProductCost.text.toString().toInt()
                    val manufacturer = binding.editTextManufacturer.text.toString()
                    val number: Int = binding.editTextNumber.text.toString().toInt()
                    val archive = false

                    viewModel.insert(
                        Goods(
                            goodName = name,
                            goodsManufacturer = manufacturer,
                            goodCost = cost,
                            amountOfGoods = number,
                            archiveOfGoods = archive
                        )
                    ) { }
                    val navController = APP.findNavController(R.id.nav_host_fragment)
                    navController.navigate(R.id.action_navi_add_model_to_navi_inventory_main)
                    Toast.makeText(context, "добавлено!", Toast.LENGTH_SHORT).show()

                } catch (e: Exception) {
                    Toast.makeText(context, e.toString(), Toast.LENGTH_SHORT).show()
                }


            }

            binding.imageViewGoBack.setOnClickListener {
                val navController = APP.findNavController(R.id.nav_host_fragment)
                navController.navigate(R.id.action_navi_add_model_to_navi_inventory_main)
            }
        }

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAddNewModelBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

}