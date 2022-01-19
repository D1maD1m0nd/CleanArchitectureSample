package com.example.cleanarchitecturesample.interface_adapter.presenters.activity_main_presenter.contract

class Contract {
    interface View {
        fun showScreen()
    }

    interface Presenter {
        fun onStart()
        fun onStop()
    }
}