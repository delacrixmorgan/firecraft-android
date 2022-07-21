package com.delacrixmorgan.firecraft

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.commit
import com.delacrixmorgan.firecraft.compose.BooksFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportFragmentManager.commit {
            replace(android.R.id.content, BooksFragment.create(), BooksFragment::class.java.simpleName)
        }
    }
}