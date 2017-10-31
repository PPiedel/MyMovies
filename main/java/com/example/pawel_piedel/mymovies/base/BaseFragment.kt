package com.example.pawel_piedel.mymovies.base

import android.os.Bundle
import android.support.annotation.LayoutRes
import android.support.v4.app.Fragment
import android.support.v4.util.LongSparseArray
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.pawel_piedel.mymovies.MyMoviesApplication
import com.example.pawel_piedel.mymovies.injection.component.ConfigPersistentComponent
import com.example.pawel_piedel.mymovies.injection.component.DaggerConfigPersistentComponent
import com.example.pawel_piedel.mymovies.injection.component.FragmentComponent
import com.example.pawel_piedel.mymovies.injection.module.FragmentModule
import java.util.concurrent.atomic.AtomicLong

/**
 * Abstract Fragment that every other Fragment in this application must implement. It handles
 * creation of Dagger components and makes sure that instances of ConfigPersistentComponent are kept
 * across configuration changes.
 */
abstract class BaseFragment : Fragment() {

    private var fragmentComponent: FragmentComponent? = null
    private var fragmentId = 0L

    companion object {
        private val KEY_FRAGMENT_ID = "KEY_FRAGMENT_ID"
        private val componentsArray = LongSparseArray<ConfigPersistentComponent>()
        private val NEXT_ID = AtomicLong(0)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Create the FragmentComponent and reuses cached ConfigPersistentComponent if this is
        // being called after a configuration change.
        fragmentId = savedInstanceState?.getLong(KEY_FRAGMENT_ID) ?: NEXT_ID.getAndIncrement()
        val configPersistentComponent: ConfigPersistentComponent
        if (componentsArray.get(fragmentId) == null) {
            configPersistentComponent = DaggerConfigPersistentComponent.builder()
                    .appComponent(MyMoviesApplication[activity].component)
                    .build()
            componentsArray.put(fragmentId, configPersistentComponent)
        } else {
            configPersistentComponent = componentsArray.get(fragmentId)
        }
        fragmentComponent = configPersistentComponent.fragmentComponent(FragmentModule(this))
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view: View? = inflater?.inflate(layoutId(), container, false)
        return view
    }

    @LayoutRes abstract fun layoutId(): Int

    override fun onSaveInstanceState(outState: Bundle?) {
        super.onSaveInstanceState(outState)
        outState?.putLong(KEY_FRAGMENT_ID, fragmentId)
    }

    override fun onDestroy() {
        if (!activity.isChangingConfigurations) {
            componentsArray.remove(fragmentId)
        }
        super.onDestroy()
    }

    fun fragmentComponent() = fragmentComponent as FragmentComponent
}