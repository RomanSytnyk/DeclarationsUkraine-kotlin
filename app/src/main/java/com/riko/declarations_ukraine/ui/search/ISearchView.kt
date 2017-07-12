package com.riko.declarations_ukraine.ui.search

import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy
import com.arellomobile.mvp.viewstate.strategy.OneExecutionStateStrategy
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType
import com.riko.declarations_ukraine.data.api.model.DeclarationList
import com.riko.declarations_ukraine.ui.base.BaseMvpView

/**
 * Created by Roman on 10.07.2017.
 */
interface ISearchView : BaseMvpView {
    @StateStrategyType(AddToEndSingleStrategy::class)
    fun showSearchResult(list: DeclarationList?)
    @StateStrategyType(OneExecutionStateStrategy::class)
    fun finish()
    @StateStrategyType(OneExecutionStateStrategy::class)
    fun openDeclarationPdfInBrowser(url: String)
    @StateStrategyType(OneExecutionStateStrategy::class)
    fun showErrorToast()
    @StateStrategyType(OneExecutionStateStrategy::class)
    fun showNotFoundToast()
}