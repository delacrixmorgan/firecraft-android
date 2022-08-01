package com.delacrixmorgan.firecraft.features.notification

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.app.NotificationCompat
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.Fragment
import com.delacrixmorgan.firecraft.MainActivity
import com.delacrixmorgan.firecraft.R
import com.delacrixmorgan.firecraft.databinding.FragmentNotificationBinding

class NotificationFragment : Fragment() {
    companion object {
        const val EVENT_CHANNEL_ID = "EventChannelId"
        const val EVENT_CHANNEL_NAME = "EventChannelName"
        const val EVENT_CHANNEL_GROUP = "EventChannelGroup"

        fun create() = NotificationFragment()
    }

    private val binding get() = requireNotNull(_binding)
    private var _binding: FragmentNotificationBinding? = null

    private val message = NotificationMessage(
        id = 1,
        code = "1",
        title = "Hello There",
        message = "General Kenobi"
    )

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentNotificationBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        createNotificationChannels()

        binding.titleEditText.setText(message.title)
        binding.messageEditText.setText(message.message)

        binding.titleEditText.addTextChangedListener { message.title = it?.toString() }
        binding.messageEditText.addTextChangedListener { message.message = it?.toString() }

        binding.actionButton.setOnClickListener {
            pushNotification(message)
        }
    }

    private fun createNotificationChannels() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val importance = NotificationManager.IMPORTANCE_DEFAULT
            val channels = listOf(
                NotificationChannel(EVENT_CHANNEL_ID, EVENT_CHANNEL_NAME, importance)
            )
            val notificationManager: NotificationManager = context?.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            notificationManager.createNotificationChannels(channels)
        }
    }

    private fun pushNotification(message: NotificationMessage) {
        val context = requireContext()

        val intent = Intent(context, MainActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_REORDER_TO_FRONT
        intent.action = System.currentTimeMillis().toString()

        intent.putExtra("id", message.id.toString())
        intent.putExtra("code", message.code.toString())

        val pendingIntent = PendingIntent.getActivity(
            context, 0, intent, PendingIntent.FLAG_IMMUTABLE
        )
        val notification =
            NotificationCompat.Builder(context, EVENT_CHANNEL_ID)
                .setSmallIcon(R.drawable.ic_launcher_foreground)
                .setContentTitle(message.title)
                .setContentText(message.message)
                .setStyle(NotificationCompat.BigTextStyle().bigText(message.message))
                .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                .setAutoCancel(true)
                .setGroup(EVENT_CHANNEL_GROUP)
                .setContentIntent(pendingIntent)
                .build()

        val manager = context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        manager.notify(message.code, message.id ?: 0, notification)
    }

    data class NotificationMessage(
        val id: Int? = null,
        val code: String? = null,
        var title: String? = null,
        var message: String? = null
    )
}