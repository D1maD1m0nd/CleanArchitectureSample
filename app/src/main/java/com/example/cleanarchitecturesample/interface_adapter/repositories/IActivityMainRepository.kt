package com.example.cleanarchitecturesample.interface_adapter.repositories

import io.reactivex.Observable


interface IActivityMainRepository {
    fun getCountAppStart() : Observable<Int>
}