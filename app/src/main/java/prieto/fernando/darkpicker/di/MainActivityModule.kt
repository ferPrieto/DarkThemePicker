package prieto.fernando.darkpicker.di

import dagger.Module
import dagger.Provides
import dagger.android.ContributesAndroidInjector
import prieto.fernando.darkpicker.presentation.MainViewModel
import prieto.fernando.darkpicker.ui.MainActivity

@Module
internal abstract class MainActivityModule {
    @ActivityScope
    @ContributesAndroidInjector
    internal abstract fun bindMainActivity(): MainActivity

    @Module
    companion object {
        @Provides
        @JvmStatic
        internal fun provideMainViewModelFactory(viewModel: MainViewModel): prieto.fernando.presentation.ViewModelProviderFactory<MainViewModel> {
            return prieto.fernando.presentation.ViewModelProviderFactory(viewModel)
        }
    }

}
