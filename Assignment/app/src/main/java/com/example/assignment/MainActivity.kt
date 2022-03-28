package com.example.assignment

import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val sharedPreferences = getSharedPreferences("SP_INFO", Context.MODE_PRIVATE)

        saveBtn.setOnClickListener {

            val name = nameEt.text.toString()
            val age = Integer.parseInt(ageEt.text.toString())
            val Undergraduate = switchh.isChecked

            val editor = sharedPreferences.edit()

            editor.putString("NAME", name.toString())
            editor.putInt("AGE",age)
            editor.putBoolean("Undergraduate",Undergraduate)

            editor.apply()

        }

        showInfoBtn.setOnClickListener {

            val name = sharedPreferences.getString("NAME","")
            val age = sharedPreferences.getInt("AGE",0)
            val Undergraduate = sharedPreferences.getBoolean("Undergraduate",false)

            infoTv.text = "NAME: $name \nAGE: $age \nUndergraduate ?: $Undergraduate"




        }
    }



}