package com.riko.declarations_ukraine

import android.app.Application
import com.riko.declarations_ukraine.di.components.*
import com.riko.declarations_ukraine.di.modules.AppModule

/**
 * Created by Roman on 10.07.2017
 */

class App : Application() {

    companion object {
        lateinit var appComponent: AppComponent
        lateinit var dataManagerComponent: DataManagerComponent
        lateinit var presenterComponent: PresenterComponent
    }

    override fun onCreate() {
        super.onCreate()

        appComponent = DaggerAppComponent
                .builder()
                .appModule(AppModule(this))
                .build()
        dataManagerComponent = DaggerDataManagerComponent
                .builder()
                .build()
        presenterComponent = DaggerPresenterComponent
                .builder()
                .build()
    }
}