package com.allvays.librarychecker.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.allvays.librarychecker.databinding.ItemBookContentBinding
import com.allvays.librarychecker.model.Book

class BooksRecyclerAdapter :
    RecyclerView.Adapter<BookViewHolder>() {
    var bookList: MutableList<Book> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookViewHolder {
        val itemBookContentBinding: ItemBookContentBinding =
            ItemBookContentBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return BookViewHolder(itemBookContentBinding)
    }

    override fun onBindViewHolder(holder: BookViewHolder, position: Int) {
        holder.bind(bookList[position])
    }

    override fun getItemCount(): Int =
        bookList.size


}

class BookViewHolder(private val binding: ItemBookContentBinding) :
    RecyclerView.ViewHolder(binding.root) {
    fun bind(book: Book) {
        with(binding) {
            bookAuthor.text = book.author
            bookTitle.text = book.title
            bookCover.setImageResource(book.cover)
            bookDescription.text = book.synopsis
            bookArt.setImageResource(book.art)
        }
    }
}