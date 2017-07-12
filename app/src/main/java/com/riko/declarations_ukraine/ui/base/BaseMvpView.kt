package com.riko.declarations_ukraine.ui.base

import com.arellomobile.mvp.MvpView
import com.arellomobile.mvp.viewstate.strategy.OneExecutionStateStrategy
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType

/**
 * Created by Roman on 10.07.2017.
 */
interface BaseMvpView : MvpView {
    @StateStrategyType(OneExecutionStateStrategy::class) fun showToast(msg: String)
    @StateStrategyType(OneExecutionStateStrategy::class) fun showSnackbar(msg: String)
    @StateStrategyType(OneExecutionStateStrategy::class) fun showProgress()
    @StateStrategyType(OneExecutionStateStrategy::class) fun hideProgress()
}