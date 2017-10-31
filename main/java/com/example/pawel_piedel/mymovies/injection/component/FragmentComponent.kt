package com.example.pawel_piedel.mymovies.injection.component

import com.example.pawel_piedel.mymovies.injection.module.FragmentModule
import dagger.Subcomponent
import com.example.pawel_piedel.mymovies.injection.PerFragment

/**
 * This component inject dependencies to all Fragments across the application
 */
@PerFragment
@Subcomponent(modules = arrayOf(FragmentModule::class))
interface FragmentComponent