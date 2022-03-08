package com.example.inventory

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Build
import android.os.Parcel
import android.os.Parcelable
import android.util.TypedValue
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat

class ItemAdapter(var context: Context, var dataSource: ArrayList<ItemList>) : BaseAdapter(), Parcelable {
    private val inflater: LayoutInflater =
        context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

    override fun getCount(): Int {
        return dataSource.size
    }

    override fun getItem(positions: Int): Any {
        return dataSource[positions]
    }

    override fun getItemId(positionss: Int): Long {
        return positionss.toLong()
    }

    @RequiresApi(Build.VERSION_CODES.Q)
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {

        val view: View = View.inflate(context, R.layout.item_layout, null)

        var binding: ItemLayoutBinding =
            DataBindingUtil.inflate(inflater, R.layout.item_layout, parent, false)

        val imageView: ImageView = view.findViewById(R.id.imageView)
        val nameText: TextView = view.findViewById(R.id.tv_name_of)
        val typeText: TextView = view.findViewById(R.id.tv_type)
        val adressText: TextView = view.findViewById(R.id.tv_adress)
        val workGrapText: TextView = view.findViewById(R.id.tv_work_graf)
        val aboutPlace: TextView = view.findViewById(R.id.tvAbout)
        val telephonePlace: TextView = view.findViewById(R.id.tvTelephone)
        val costOfPlace: TextView = view.findViewById(R.id.tvChek)
        val adress2: TextView = view.findViewById(R.id.tvAdress2)
        var buttonOnImgView: ImageView = view.findViewById(R.id.buttonOnImgView)

        val itemList: ItemList = dataSource.get(position)

        val viewGroup: ConstraintLayout = view.findViewById(R.id.view_group)
        viewGroup.visibility = View.GONE

        imageView.setImageResource(itemList.imageId!!)
        nameText.text = itemList.nameOfPlace
        typeText.text = itemList.typeOfPlace
        adressText.text = itemList.adressOfPlace
        adress2.text = itemList.adressOfPlace
        workGrapText.text = itemList.grafOfWork
        aboutPlace.text = itemList.aboutPlace
        telephonePlace.text = itemList.telephone
        costOfPlace.text = itemList.costOfPlace


        var tempBool: Boolean = false

        buttonOnImgView.setOnClickListener {

            if (tempBool == false) {
                nameText.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 28F);
                adressText.setTextColor(context.getResources().getColor(R.color.name_color))
                buttonOnImgView.setImageResource(R.drawable.ic_baseline_expand_less_24)
                tempBool = !tempBool
                viewGroup.visibility = View.VISIBLE
                workGrapText.visibility = View.GONE
                adress2.visibility = View.GONE
            } else {
                nameText.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 20F);
                adressText.setTextColor(R.color.black.toInt())
                buttonOnImgView.setImageResource(R.drawable.ic_baseline_expand_more_24)
                viewGroup.visibility = View.GONE
                workGrapText.visibility = View.VISIBLE
                adress2.visibility = View.VISIBLE
                tempBool = !tempBool
            }
        }
            return view!!
    }


}