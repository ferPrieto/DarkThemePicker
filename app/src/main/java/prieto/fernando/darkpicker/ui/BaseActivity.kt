package prieto.fernando.darkpicker.ui

import android.os.Bundle
import androidx.lifecycle.ViewModel
import dagger.android.support.DaggerAppCompatActivity
import io.reactivex.disposables.CompositeDisposable
import kotlinx.android.synthetic.main.main_activity.*
import prieto.fernando.darkpicker.R
import prieto.fernando.darkpicker.widget.ThemeMode
import prieto.fernando.presentation.SchedulerProvider
import prieto.fernando.presentation.ViewModelProviderFactory
import javax.inject.Inject

abstract class BaseActivity<T : ViewModel> : DaggerAppCompatActivity(), BaseView<T> {

    @Inject
    protected lateinit var vmFactory: ViewModelProviderFactory<T>

    @Inject
    protected lateinit var schedulers: SchedulerProvider

    protected val subscriptions = CompositeDisposable()

    override fun onDestroy() {
        subscriptions.clear()
        super.onDestroy()
    }
}
