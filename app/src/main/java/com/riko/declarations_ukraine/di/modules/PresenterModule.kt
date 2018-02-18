package com.riko.declarations_ukraine.di.modules

import com.riko.declarations_ukraine.data.DataManager
import com.riko.declarations_ukraine.ui.common.CoroutineContextProvider
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


/**
 * Created by Roman on 11.07.2017
 */
@Module
class PresenterModule {
    @Provides
    @Singleton
    internal fun provideDataManager(): DataManager {
        return DataManager()
    }

    @Provides
    @Singleton
    internal fun provideCoroutineContext(): CoroutineContextProvider {
        return CoroutineContextProvider()
    }
}