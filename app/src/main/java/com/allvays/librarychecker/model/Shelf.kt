package com.allvays.librarychecker.model

import java.util.*

data class Shelf(val id: UUID, val name: String?, val bookList: MutableList<Book>)