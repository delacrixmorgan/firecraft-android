package com.delacrixmorgan.firecraft.features.screenshot

import android.app.WallpaperManager
import android.graphics.Bitmap
import android.graphics.Canvas
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import com.delacrixmorgan.firecraft.R
import com.delacrixmorgan.firecraft.databinding.FragmentScreenshotBinding
import com.google.android.material.snackbar.Snackbar

class ScreenshotFragment : Fragment(R.layout.fragment_screenshot), ScreenshotBottomSheetFragment.Listener {
    companion object {
        fun create() = ScreenshotFragment()
    }

    private val binding get() = requireNotNull(_binding)
    private var _binding: FragmentScreenshotBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentScreenshotBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.setAsWallpaperButton.setOnClickListener {
            val bottomSheetFragment = ScreenshotBottomSheetFragment.create(this)
            bottomSheetFragment.show(requireActivity().supportFragmentManager, bottomSheetFragment.javaClass.simpleName)
        }
    }

    private fun setAsWallpaper(menuItems: ScreenshotBottomSheetFragment.MenuItems) {
        binding.setAsWallpaperButton.isVisible = false
        val wallpaperManager = WallpaperManager.getInstance(requireContext())
        val bitmap = getViewAsBitmap(requireActivity().window.decorView.rootView)
        when (menuItems) {
            ScreenshotBottomSheetFragment.MenuItems.SetHomeScreen -> {
                wallpaperManager.setBitmap(bitmap, null, true, WallpaperManager.FLAG_SYSTEM)
            }
            ScreenshotBottomSheetFragment.MenuItems.SetLockScreen -> {
                wallpaperManager.setBitmap(bitmap, null, true, WallpaperManager.FLAG_LOCK)
            }
            ScreenshotBottomSheetFragment.MenuItems.SetBothScreens -> {
                wallpaperManager.setBitmap(bitmap)
            }
        }
        binding.setAsWallpaperButton.isVisible = true
    }

    private fun getViewAsBitmap(view: View): Bitmap {
        val bitmap = Bitmap.createBitmap(view.width, view.height, Bitmap.Config.ARGB_8888)
        Canvas(bitmap).also { view.draw(it) }
        return bitmap
    }

    override fun onNavigationViewSelected(menuItems: ScreenshotBottomSheetFragment.MenuItems) {
        setAsWallpaper(menuItems)
        Snackbar.make(binding.root, "Wallpaper changed!", Snackbar.LENGTH_SHORT).show()
    }
}