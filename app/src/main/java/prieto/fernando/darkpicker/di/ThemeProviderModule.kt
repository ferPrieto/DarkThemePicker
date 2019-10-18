package prieto.fernando.darkpicker.di

import dagger.Module
import dagger.Provides
import prieto.fernando.darkpicker.util.RangeEvaluator
import prieto.fernando.darkpicker.util.StyleProvider
import javax.inject.Singleton

@Module
class ThemeProviderModule {

    @Module
    companion object {
        @Provides
        @JvmStatic
        @Singleton
        internal fun provideThemeProvider(rangeEvaluator: RangeEvaluator) = StyleProvider(rangeEvaluator)

        @Provides
        @JvmStatic
        @Singleton
        internal fun provideRangeEvaluator() = RangeEvaluator()

    }
}
