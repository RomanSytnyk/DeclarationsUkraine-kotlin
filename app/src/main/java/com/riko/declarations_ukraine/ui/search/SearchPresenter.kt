package com.riko.declarations_ukraine.ui.search

import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import com.riko.declarations_ukraine.App
import com.riko.declarations_ukraine.data.DataManager
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

/**
 * Created by Roman on 10.07.2017
 */
@InjectViewState
class SearchPresenter : MvpPresenter<ISearchView>(), ISearchPresenter {
    @Inject
    lateinit var dataManager: DataManager
    private val disposable = CompositeDisposable()

    init {
        App.presenterComponent.inject(this)
    }

    override fun search(query: String) {
        viewState.showProgress()
        disposable.add(dataManager.nazkApi.search(query)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        { response ->
                            viewState.hideProgress()
                            if(response.body()?.items == null) {
                                viewState.showNotFoundToast()
                                viewState.finish()
                            }
                            viewState.showSearchResult(response.body())

                        }, { e ->
                            e.printStackTrace()
                            viewState.hideProgress()
                            viewState.showErrorToast()
                            viewState.finish()
                        }))
    }

    override fun downloadDeclaration(url: String) {
        viewState.openDeclarationPdfInBrowser(url)
    }

    override fun onDestroy() {
        super.onDestroy()
        disposable.dispose()
    }
}