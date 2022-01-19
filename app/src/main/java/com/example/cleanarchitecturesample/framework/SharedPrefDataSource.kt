package com.example.cleanarchitecturesample.framework


import android.content.SharedPreferences

import com.example.cleanarchitecturesample.interface_adapter.data.ISharedPrefDataSource
import io.reactivex.Observable

class SharedPrefDataSource(private val sharedPreferences: SharedPreferences) : ISharedPrefDataSource {
    override fun getCountOpensApp() : Observable<Int> {
        val count = sharedPreferences.getInt(COUNTER_PREF, 0)
        val newValue = incrementSharedPref(count)
        return Observable.just(newValue)
    }

    private fun incrementSharedPref(value : Int) : Int {
        val newValue = value.inc();
        val editor: SharedPreferences.Editor = sharedPreferences.edit()
        editor.putInt(COUNTER_PREF, newValue)
        editor.apply()

        return  newValue;
    }
    private companion object {
        const val COUNTER_PREF = "COUNTER_PREF"
    }
}