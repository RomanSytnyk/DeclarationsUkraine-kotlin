package com.riko.declarations_ukraine.di.components

import android.content.Context
import com.riko.declarations_ukraine.di.modules.AppModule
import dagger.Component
import javax.inject.Singleton


/**
 * Created by Roman on 11.07.2017
 */
@Singleton
@Component(modules = arrayOf(AppModule::class))
interface AppComponent {
    val context: Context
}
