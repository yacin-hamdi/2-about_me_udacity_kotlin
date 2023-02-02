package com.m01.aboutme

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import com.m01.aboutme.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding
    private val myName:MyName = MyName(name="aycin moose")



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //(R.layout.activity_main)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)
        binding.myName = myName
        binding.doneNickname.setOnClickListener{
            addNickname(it)
        }


    }

    private fun addNickname(view:View){
        binding.apply{
            myName?.nickname = editNickname.text.toString()
            invalidateAll()
            nicknameText.visibility = View.VISIBLE
            editNickname.visibility = View.GONE
            doneNickname.visibility = View.GONE

        }
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken, 0)

    }






}