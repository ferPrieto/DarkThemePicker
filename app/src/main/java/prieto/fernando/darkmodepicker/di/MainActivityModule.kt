package prieto.fernando.darkmodepicker.di

import dagger.Module
import dagger.Provides
import dagger.android.ContributesAndroidInjector
import prieto.fernando.darkmodepicker.presentation.MainViewModel
import prieto.fernando.darkmodepicker.presentation.ViewModelProviderFactory
import prieto.fernando.darkmodepicker.ui.MainActivity

@Module
internal abstract class MainActivityModule {
    @ActivityScope
    @ContributesAndroidInjector
    internal abstract fun bindMainActivity(): MainActivity

    @Module
    companion object {
        @Provides
        @JvmStatic
        internal fun provideMainViewModelFactory(viewModel: MainViewModel): ViewModelProviderFactory<MainViewModel> {
            return ViewModelProviderFactory(viewModel)
        }
    }
}
