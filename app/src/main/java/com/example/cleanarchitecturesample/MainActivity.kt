package com.example.cleanarchitecturesample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.cleanarchitecturesample.framework.SharedPrefDataSource
import com.example.cleanarchitecturesample.interactors.CountInteractor
import com.example.cleanarchitecturesample.interactors.ICountInteractor
import com.example.cleanarchitecturesample.interface_adapter.presenters.activity_main_presenter.ActivityMainPresenter
import com.example.cleanarchitecturesample.interface_adapter.presenters.activity_main_presenter.contract.Contract
import com.example.cleanarchitecturesample.interface_adapter.repositories.ActivityMainRepository
import javax.sql.DataSource

class MainActivity : AppCompatActivity(), Contract.View {
    lateinit var presenter : Contract.Presenter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        createPresenter()
    }
    private fun createPresenter() {
        val dataSource = SharedPrefDataSource(getSharedPreferences("SharedPref", MODE_PRIVATE));
        val repos = ActivityMainRepository(dataSource)
        val interactor = CountInteractor(repos)
        presenter = ActivityMainPresenter(this, interactor)
    }

    override fun onStart() {
        super.onStart()
        presenter.onStart()
    }
    override fun showScreen() {
        val textView = findViewById<TextView>(R.id.text_main_activity)
        textView.text = "УВЕДОМЛЕНИЕ"
    }
}