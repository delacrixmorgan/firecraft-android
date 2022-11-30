package com.delacrixmorgan.firecraft

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.commit
import com.delacrixmorgan.firecraft.features.Features

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val feature = Features.Locale
        supportFragmentManager.commit {
            replace(android.R.id.content, feature.fragmentBuilder.invoke(), feature.featureName)
        }
    }
}