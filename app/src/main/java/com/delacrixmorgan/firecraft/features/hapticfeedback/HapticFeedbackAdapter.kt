package com.delacrixmorgan.firecraft.features.hapticfeedback

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.delacrixmorgan.firecraft.databinding.ItemHapticFeedbackBinding

class HapticFeedbackAdapter : RecyclerView.Adapter<HapticFeedbackAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(ItemHapticFeedbackBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(HapticFeedbackFragment.HapticConstant.values()[position])
    }

    override fun getItemCount(): Int {
        return HapticFeedbackFragment.HapticConstant.values().size
    }

    inner class ViewHolder(private val binding: ItemHapticFeedbackBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(hapticConstant: HapticFeedbackFragment.HapticConstant) = with(binding) {
            button.text = hapticConstant.name.replace("_", " ")
            button.setOnClickListener {
                it.performHapticContextClick(hapticConstant)
                Toast.makeText(it.context, "${hapticConstant.name} Clicked", Toast.LENGTH_SHORT).show()
            }
        }

        private fun View.performHapticContextClick(hapticConstant: HapticFeedbackFragment.HapticConstant) {
            performHapticFeedback(hapticConstant.key)
        }
    }
}