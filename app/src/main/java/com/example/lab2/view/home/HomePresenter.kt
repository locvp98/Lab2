package com.example.lab2.view.home

class HomePresenter(val homeView: HomeView):HomeListener {

    val homeModel =HomeModel(this)
    fun getData(data:String){
        homeModel.getData(data)
    }

    override fun data(data: String) {
        homeView.getData(data)
    }

}