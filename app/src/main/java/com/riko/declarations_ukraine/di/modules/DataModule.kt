package com.riko.declarations_ukraine.di.modules

import com.riko.declarations_ukraine.data.api.NazkApi
import com.riko.declarations_ukraine.data.api.core.Api
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


/**
 * Created by Roman on 11.07.2017
 */

@Module
class DataModule {
    @Provides
    @Singleton
    internal fun provideNazkApi(): NazkApi {
        return Api().nazkApi
    }
}
