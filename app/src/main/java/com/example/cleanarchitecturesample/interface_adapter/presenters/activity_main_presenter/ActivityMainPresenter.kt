package com.example.cleanarchitecturesample.interface_adapter.presenters.activity_main_presenter

import com.example.cleanarchitecturesample.interactors.ICountInteractor
import com.example.cleanarchitecturesample.interface_adapter.presenters.activity_main_presenter.contract.Contract
import io.reactivex.Observer
import io.reactivex.disposables.Disposable


class ActivityMainPresenter(val view : Contract.View, val interactor: ICountInteractor) : Contract.Presenter {
    private var disposable: Disposable? = null
    override fun onStart() {
        interactor.getCountStartApp().subscribe(getObserver())
    }

    override fun onStop() {
        disposable?.dispose()
    }

    private fun getObserver() = object : Observer<Boolean> {
        override fun onSubscribe(d: Disposable) {
            disposable = d
        }

        override fun onNext(t: Boolean) {
            if(t) {
                view.showScreen()
            }
        }

        override fun onError(e: Throwable) {
            //empty
        }

        override fun onComplete() {
            //empty
        }

    }

}