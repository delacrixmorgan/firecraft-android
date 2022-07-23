package com.delacrixmorgan.firecraft

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.commit
import com.delacrixmorgan.firecraft.screenshot.ScreenshotFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val fragment = ScreenshotFragment.create()
        supportFragmentManager.commit {
            replace(android.R.id.content, fragment, fragment::class.java.simpleName)
        }
    }
}