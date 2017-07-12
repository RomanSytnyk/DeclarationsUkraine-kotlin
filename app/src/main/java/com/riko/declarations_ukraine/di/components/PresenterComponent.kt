package com.riko.declarations_ukraine.di.components

import com.riko.declarations_ukraine.di.modules.PresenterModule
import com.riko.declarations_ukraine.ui.search.SearchPresenter
import dagger.Component
import javax.inject.Singleton

/**
 * Created by Roman on 11.07.2017
 */
@Singleton
@Component(modules = arrayOf(PresenterModule::class))
interface PresenterComponent {
    fun inject(searchPresenter: SearchPresenter)
}
