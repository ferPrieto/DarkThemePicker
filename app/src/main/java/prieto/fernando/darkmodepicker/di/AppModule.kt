package prieto.fernando.darkmodepicker.di

import dagger.Module
import dagger.Provides
import prieto.fernando.darkmodepicker.presentation.AppSchedulerProvider
import prieto.fernando.darkmodepicker.presentation.SchedulerProvider
import javax.inject.Singleton

@Module
class AppModule {
    @Provides
    @Singleton
    fun provideSchedulerProvider(): SchedulerProvider = AppSchedulerProvider()
}
