package com.allvays.librarychecker.ui.books


import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.allvays.librarychecker.model.Book

class BooksOnShelfViewModel: ViewModel() {
    val list = MutableLiveData<List<Book>>()

}