package com.delacrixmorgan.firecraft.compose

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.fragment.app.Fragment
import com.delacrixmorgan.firecraft.R

class BooksFragment : Fragment() {
    companion object {
        fun create() = BooksFragment()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        return ComposeView(requireContext()).apply {
            setContent { BooksContent() }
        }
    }

    @Composable
    @Preview
    fun BooksContent() {
        Scaffold(
            topBar = { BooksTopBar() },
            floatingActionButton = { AddNewBook() })
        {

        }
    }

    @Composable
    fun BooksTopBar() {
        TopAppBar(
            title = { Text(text = "Books") },
            backgroundColor = colorResource(id = R.color.colorPrimary),
            contentColor = Color.White
        )
    }

    @Composable
    fun AddNewBook() {
        FloatingActionButton(
            content = { Icon(imageVector = Icons.Filled.Add, contentDescription = "Add Book") },
            onClick = { showAddBook() })
    }

    private fun showAddBook() {

    }
}