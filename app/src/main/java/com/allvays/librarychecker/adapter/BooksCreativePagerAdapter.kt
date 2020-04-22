package com.allvays.librarychecker.adapter

import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Build
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.allvays.librarychecker.databinding.ItemBookContentBinding
import com.allvays.librarychecker.databinding.ItemBookHeaderBinding
import com.allvays.librarychecker.model.Book
import com.tbuonomo.creativeviewpager.adapter.CreativePagerAdapter

class BooksCreativePagerAdapter(private val context: Context, private val books: List<Book>) :
    CreativePagerAdapter {

    override fun instantiateHeaderItem(
        inflater: LayoutInflater,
        container: ViewGroup,
        position: Int
    ): View {
        val contentBinding: ItemBookContentBinding =
            ItemBookContentBinding.inflate(inflater, container, false)
        with(contentBinding) {
            bookTitle.text = books[position].title
            bookAuthor.text = books[position].author
            bookArt.setImageResource(books[position].art)
            bookDescription.text = books[position].synopsis
        }

        return contentBinding.root
    }

    override fun instantiateContentItem(
        inflater: LayoutInflater,
        container: ViewGroup,
        position: Int
    ): View {
        val headerBinding: ItemBookHeaderBinding =
            ItemBookHeaderBinding.inflate(inflater, container, false)
        headerBinding.bookCover.setImageResource(books[position].cover)

        return headerBinding.root
    }

    override fun getCount(): Int {
        return books.size
    }

    override fun isUpdatingBackgroundColor(): Boolean {
        return Build.VERSION.SDK_INT >= Build.VERSION_CODES.O
    }

    override fun requestBitmapAtPosition(position: Int): Bitmap? {
        return BitmapFactory.decodeResource(context.resources, books[position].art)
    }
}
