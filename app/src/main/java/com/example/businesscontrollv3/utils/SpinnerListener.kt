package com.example.businesscontrollv3.utils

import android.widget.AdapterView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatSpinner
import androidx.databinding.BindingAdapter

object SpinnerListener {

    private const val SPINNER_SELECT_ITEM_POSITION = "selectedItemPosition"

    @JvmStatic
    @BindingAdapter(SPINNER_SELECT_ITEM_POSITION)
    fun AppCompatSpinner.selectedItemPosition(position:Int){
        setSelection(position)
    }

//    fun onItemSelectedListener(callBackfunction: (position:Int) -> Unit)  : AdapterView.OnItemSelectedListener
//    override
}