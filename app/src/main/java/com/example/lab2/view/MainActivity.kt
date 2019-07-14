package com.example.lab2.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.bumptech.glide.Glide
import com.example.lab2.R
import com.example.lab2.view.home.HomeActivity
import com.example.lab2.view.login.LoginPresenter
import com.example.lab2.view.login.LoginView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(),LoginView {

    var data:String?=null
    lateinit var loginPresenter:LoginPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Glide.with(this).load(R.drawable.logo).into(imgLoad)
        loginPresenter =LoginPresenter(this)

        listener()
    }

    private fun listener(){
        var email=edtUsername.text.toString()
        var password = edtPassword.text.toString().trim()

        btnDownload.setOnClickListener {
            Log.d("LOGDDSSSSSSSSS","$email")
            if (email == "admin" && password == "123456") {
                loginPresenter.postData(email, password)
            }

        }

    }

    override fun logginSuccess(succes:String) {
        Toast.makeText(this,"đăng nhập thành công",Toast.LENGTH_LONG).show()
        data = succes
        val intent = Intent(this@MainActivity,HomeActivity::class.java)
        val name = edtName.text.toString().trim()
        Log.d("LOGDDSSSSSSSSS","$name")
        val text = data +"$name"
        intent.putExtra("name",text)
        startActivity(intent)
    }

    override fun logginFalse() {
        Toast.makeText(this,"đăng nhập thất bại",Toast.LENGTH_LONG).show()
    }
    override fun logginOut() {
        Toast.makeText(this,"Tên đăng nhập hoặc mật khẩu không chính xác",Toast.LENGTH_LONG).show()
    }
}
