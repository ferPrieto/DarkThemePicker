package prieto.fernando.darkpicker.di

import android.app.Application
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton
import prieto.fernando.darkpicker.DarkPickerApp

@Singleton
@Component(
    modules = [
        AndroidSupportInjectionModule::class,
        MainActivityModule::class,
        ThemeProviderModule::class,
        AppModule::class]
)
interface AppComponent : AndroidInjector<DaggerApplication> {

    fun inject(app: DarkPickerApp)

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(app: Application): Builder

        fun build(): AppComponent
    }
}
