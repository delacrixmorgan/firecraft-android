package com.delacrixmorgan.firecraft.features.locale

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.delacrixmorgan.firecraft.R
import com.delacrixmorgan.firecraft.databinding.FragmentLocaleBinding
import java.util.Locale

class LocaleFragment : Fragment() {
    companion object {
        fun create() = LocaleFragment()
    }

    private val binding get() = requireNotNull(_binding)
    private var _binding: FragmentLocaleBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentLocaleBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.enEnglishButton.setOnClickListener {
            updateLocale("en")
        }

        binding.ukEnglishButton.setOnClickListener {
            updateLocale("en", "gb")
        }

        binding.deEnglishButton.setOnClickListener {
            updateLocale("en", "de")
        }
    }

    private fun updateLocale(language: String, region: String? = null) = with(resources) {
        val locale = if (region != null) Locale(language, region) else Locale(language)
        configuration.setLocale(locale)
        configuration.setLayoutDirection(locale)
        updateConfiguration(configuration, displayMetrics)

        Locale.setDefault(locale)
        updateViews()

    }

    private fun updateViews() {
        binding.welcomeTextView.setText(R.string.locale_title)
    }
}