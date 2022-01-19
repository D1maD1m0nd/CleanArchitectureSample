package com.example.cleanarchitecturesample.interactors

import com.example.cleanarchitecturesample.interface_adapter.repositories.IActivityMainRepository
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers


class CountInteractor(val repository: IActivityMainRepository) : ICountInteractor {
    override fun getCountStartApp(): Observable<Boolean> {
        return repository.getCountAppStart()
            .flatMap {
               Observable.just(it == 2 || (it % 4 != 0 && it % 2 == 0))
            }
            .observeOn(Schedulers.io())
            .subscribeOn(AndroidSchedulers.mainThread())
    }
}