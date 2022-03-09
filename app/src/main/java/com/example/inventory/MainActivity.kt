package com.example.inventory

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager

import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var adapter: ItemAdapter
    private var dataList = mutableListOf<DataModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView.layoutManager = GridLayoutManager(applicationContext, 2)
        adapter = ItemAdapter(applicationContext)
        recyclerView.adapter = adapter
        dataList.add(DataModel("Shinamo 6000", 200, "Nike", 50, R.drawable.image1))
        dataList.add(DataModel("Shinamo 6000", 200, "Nike", 50, R.drawable.image2))
        adapter.setDataList(dataList)


    }


}