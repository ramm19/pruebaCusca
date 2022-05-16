package com.ramm.pruebacuscatlan

import android.app.Application
import com.ramm.pruebacuscatlan.core.di.interactionModule
import com.ramm.pruebacuscatlan.framework.di.networkModule
import com.ramm.pruebacuscatlan.framework.di.repositoryModule
import com.ramm.pruebacuscatlan.ui.di.presentationModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.androidx.workmanager.koin.workManagerFactory
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class MyApp: Application() {

    private val appModules = listOf(presentationModule)
    private val coreModules = listOf(interactionModule)
    private val frameworkModules = listOf(repositoryModule, networkModule)

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@MyApp)
            androidLogger(if (BuildConfig.DEBUG) Level.ERROR else Level.NONE)
            modules(appModules + coreModules + frameworkModules)
            //workManagerFactory()
        }
    }

}