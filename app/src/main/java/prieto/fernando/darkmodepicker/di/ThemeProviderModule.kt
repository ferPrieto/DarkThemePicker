package prieto.fernando.darkmodepicker.di

import dagger.Module
import dagger.Provides
import javax.inject.Singleton
import prieto.fernando.darkmodepicker.util.RangeEvaluator
import prieto.fernando.darkmodepicker.util.StyleProvider

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
