package com.example.cleanarchitecturesample.interactors

import io.reactivex.Observable

interface ICountInteractor {
    fun getCountStartApp() : Observable<Boolean>
}