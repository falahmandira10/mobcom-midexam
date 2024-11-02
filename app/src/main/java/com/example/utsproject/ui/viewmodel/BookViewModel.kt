package com.example.utsproject.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.utsproject.data.dao.BookDao
import com.example.utsproject.data.model.Book
import kotlinx.coroutines.launch

class BookViewModel(private val bookDao: BookDao) : ViewModel() {
    val books = bookDao.getAllBooks()

    fun addBook(book: Book) {
        viewModelScope.launch {
            bookDao.insertBook(book)
        }
    }

    fun updateBook(book: Book) {
        viewModelScope.launch {
            bookDao.updateBook(book)
        }
    }

    fun deleteBook(book: Book) {
        viewModelScope.launch {
            bookDao.deleteBook(book)
        }
    }
}
