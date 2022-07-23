package com.delacrixmorgan.firecraft

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.commit
import com.delacrixmorgan.firecraft.notification.NotificationFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val fragment = NotificationFragment.create()
        supportFragmentManager.commit {
            replace(android.R.id.content, fragment, fragment::class.java.simpleName)
        }
    }
}