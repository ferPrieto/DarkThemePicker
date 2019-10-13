package prieto.fernando.darkpicker

import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import prieto.fernando.darkpicker.di.DaggerAppComponent

class DarkPickerApp : DaggerApplication() {

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        val appComponent = DaggerAppComponent.builder()
            .application(this)
            .build()

        appComponent.inject(this)
        return appComponent
    }
}
