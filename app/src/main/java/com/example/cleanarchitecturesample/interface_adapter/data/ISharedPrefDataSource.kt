package com.example.cleanarchitecturesample.interface_adapter.data

import io.reactivex.Observable

interface ISharedPrefDataSource {
    fun getCountOpensApp() : Observable<Int>
}