package com.example.mon5_dz5.onBoarding

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.viewpager2.widget.ViewPager2
import com.example.mon5_dz5.R
import com.example.mon5_dz5.data.Pref
import com.example.mon5_dz5.databinding.FragmentOnBoardingBinding

class onBoardingFragment : Fragment() {
    private lateinit var binding: FragmentOnBoardingBinding
    private val adapter = onBoardingAdapter(this::onClick)
    private lateinit var pref: Pref

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentOnBoardingBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        pref = Pref(requireContext()) // Инициализация Pref
        binding.viewPager2.adapter = adapter
        binding.indicator.createIndicators(3, 3)
        binding.indicator.animatePageSelected(0)
        binding.viewPager2.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                binding.indicator.animatePageSelected(position)
            }
        })
    }

    private fun onClick() {
        pref.onShowed()
        findNavController().navigateUp()
    }
}
