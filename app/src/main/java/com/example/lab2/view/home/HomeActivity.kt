package com.example.lab2.view.home

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.lab2.R
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : AppCompatActivity(),HomeView {
  lateinit var homePresenter:HomePresenter

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        homePresenter =HomePresenter(this)
        val data ="today"
        homePresenter.getData(data)
        val intent = Intent()
        val name=intent.getStringExtra("name")
        Log.d("LOGDD","$name")
        txtName.text = "Xin chào nhân viên $name"

    }

    override fun getData(data: String) {
        txtData.text =data
    }
}
