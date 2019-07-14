package com.example.lab2.view.login

class LoginPresenter(val loginView: LoginView):LoginListener {
    val loginModel =  LoginModel(this)

    fun postData(username:String,password:String){

            loginModel.postData(username,password)

    }

    override fun logginSuccess(succes:String) {
        loginView.logginSuccess(succes)
    }

    override fun logginFalse() {
        loginView.logginFalse()
    }
}