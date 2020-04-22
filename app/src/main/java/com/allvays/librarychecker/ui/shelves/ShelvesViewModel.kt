package com.allvays.librarychecker.ui.shelves

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.allvays.librarychecker.adapter.ShelvesRecyclerAdapter
import com.allvays.librarychecker.model.Shelf

class ShelvesViewModel : ViewModel() {

    val shelvesList = MutableLiveData<MutableList<Shelf>>().apply{}
}