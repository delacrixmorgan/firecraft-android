package com.delacrixmorgan.firecraft.features.hapticfeedback

import android.os.Bundle
import android.view.HapticFeedbackConstants
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.delacrixmorgan.firecraft.databinding.FragmentHapticFeedbackBinding

class HapticFeedbackFragment : Fragment() {
    companion object {
        fun create() = HapticFeedbackFragment()
    }

    private val binding get() = requireNotNull(_binding)
    private var _binding: FragmentHapticFeedbackBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHapticFeedbackBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.recyclerView.adapter = HapticFeedbackAdapter()
    }

    enum class HapticConstant(
        val key: Int
    ) {
        Clock_Tick(HapticFeedbackConstants.CLOCK_TICK),
        Keyboard_Tap(HapticFeedbackConstants.KEYBOARD_TAP),
        Long_Press(HapticFeedbackConstants.LONG_PRESS),
        Virtual_Key(HapticFeedbackConstants.VIRTUAL_KEY),

        Confirm(HapticFeedbackConstants.CONFIRM),
        Context_Click(HapticFeedbackConstants.CONTEXT_CLICK),
        Gesture_Start(HapticFeedbackConstants.GESTURE_START),
        Gesture_End(HapticFeedbackConstants.GESTURE_END),
        Keyboard_Press(HapticFeedbackConstants.KEYBOARD_PRESS),
        Keyboard_Release(HapticFeedbackConstants.KEYBOARD_RELEASE),
        Text_Handle_Move(HapticFeedbackConstants.TEXT_HANDLE_MOVE),
        Virtual_Key_Release(HapticFeedbackConstants.VIRTUAL_KEY_RELEASE),
    }
}