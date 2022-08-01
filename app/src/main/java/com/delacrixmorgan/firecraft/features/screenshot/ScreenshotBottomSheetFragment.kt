package com.delacrixmorgan.firecraft.features.screenshot

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.delacrixmorgan.firecraft.R
import com.delacrixmorgan.firecraft.databinding.FragmentScreenshotBottomSheetBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class ScreenshotBottomSheetFragment : BottomSheetDialogFragment() {
    companion object {
        fun create(listener: Listener) = ScreenshotBottomSheetFragment().apply {
            this.listener = listener
        }
    }

    private val binding get() = requireNotNull(_binding)
    private var _binding: FragmentScreenshotBottomSheetBinding? = null

    interface Listener {
        fun onNavigationViewSelected(menuItems: MenuItems)
    }

    enum class MenuItems {
        SetHomeScreen,
        SetLockScreen,
        SetBothScreens
    }

    private lateinit var listener: Listener

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = FragmentScreenshotBottomSheetBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.navigationView.setNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.homeScreenMenu -> listener.onNavigationViewSelected(MenuItems.SetHomeScreen)
                R.id.lockScreenMenu -> listener.onNavigationViewSelected(MenuItems.SetLockScreen)
                R.id.bothScreensMenu -> listener.onNavigationViewSelected(MenuItems.SetBothScreens)
            }
            dismiss()
            true
        }
    }
}