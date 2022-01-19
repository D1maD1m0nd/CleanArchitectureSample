package com.example.cleanarchitecturesample.interface_adapter.repositories

import com.example.cleanarchitecturesample.interface_adapter.data.ISharedPrefDataSource
import io.reactivex.Observable


class ActivityMainRepository(val dataSource: ISharedPrefDataSource) : IActivityMainRepository {
    override fun getCountAppStart() : Observable<Int> {
        return dataSource.getCountOpensApp()
    }
}