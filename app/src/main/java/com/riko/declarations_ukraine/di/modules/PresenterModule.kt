package com.riko.declarations_ukraine.di.modules

import com.riko.declarations_ukraine.data.DataManager
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
}