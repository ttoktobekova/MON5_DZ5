package com.example.mon5_dz5.data

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class MainViewModel(private val pref: Pref) : ViewModel() {

    fun checkOnboarding() {
        if (!pref.isShow()) {
            markOnboardingAsShown()
        }
    }

    private fun markOnboardingAsShown() {
        viewModelScope.launch {
            pref.onShowed()
        }
    }
}