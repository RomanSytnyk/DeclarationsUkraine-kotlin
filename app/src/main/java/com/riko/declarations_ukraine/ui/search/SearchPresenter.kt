package com.riko.declarations_ukraine.ui.search

import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import com.riko.declarations_ukraine.App
import com.riko.declarations_ukraine.data.DataManager
import kotlinx.coroutines.experimental.android.UI
import kotlinx.coroutines.experimental.async
import javax.inject.Inject

/**
 * Created by Roman on 10.07.2017
 */
@InjectViewState
class SearchPresenter : MvpPresenter<ISearchView>(), ISearchPresenter {
    @Inject lateinit var dataManager: DataManager

    init {
        App.presenterComponent.inject(this)
    }

    override fun search(query: String) {
        async(UI) {
            try {
                val response = dataManager.nazkApi.search(query).await()
                if (response.body()?.items == null) {
                    viewState.showNotFoundToast()
                    viewState.finish()
                }
                viewState.showSearchResult(response.body())
            } catch (e: Exception) {
                e.printStackTrace()
                viewState.showErrorToast()
                viewState.finish()
            }
        }
    }

    override fun downloadDeclaration(url: String) {
        viewState.openDeclarationPdfInBrowser(url)
    }
}