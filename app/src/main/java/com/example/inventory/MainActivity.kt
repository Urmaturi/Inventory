package com.example.inventory

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import kotlinx.android.synthetic.main.activity_main.view.*


class MainActivity : AppCompatActivity() {

    private lateinit var adapter: ItemAdapter
    private var dataList = mutableListOf<DataModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        recyclerView.layoutManager = GridLayoutManager(applicationContext, 2)
//        adapter = ItemAdapter(applicationContext)
//        recyclerView.adapter = adapter
//        dataList.add(DataModel("Shinamo 6000", 200, "Nike", 50, R.drawable.image1))
//        dataList.add(DataModel("Shinamo 6000", 200, "Nike", 50, R.drawable.image2))
//        adapter.setDataList(dataList)

        val navController = this.findNavController(R.id.nav_host_fragment)
        // Find reference to bottom navigation view
        val navView: BottomNavigationView = findViewById(R.id.bottom_nav_view)
        // Hook your navigation controller to bottom navigation view
        navView.setupWithNavController(navController)





    }





}