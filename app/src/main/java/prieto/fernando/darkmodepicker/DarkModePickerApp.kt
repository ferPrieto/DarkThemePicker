package prieto.fernando.darkmodepicker

import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import prieto.fernando.darkmodepicker.di.DaggerAppComponent

class DarkModePickerApp : DaggerApplication() {

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        val appComponent = DaggerAppComponent.builder()
            .application(this)
            .build()

        appComponent.inject(this)
        return appComponent
    }
}
