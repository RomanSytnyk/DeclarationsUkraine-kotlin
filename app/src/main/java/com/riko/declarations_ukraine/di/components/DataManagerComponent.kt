package com.riko.declarations_ukraine.di.components

import com.riko.declarations_ukraine.data.DataManager
import com.riko.declarations_ukraine.di.modules.DataModule
import dagger.Component
import javax.inject.Singleton



/**
 * Created by Roman on 11.07.2017
 */
@Singleton
@Component(modules = arrayOf(DataModule::class))
interface DataManagerComponent {
    fun inject(dataManager: DataManager)
}
