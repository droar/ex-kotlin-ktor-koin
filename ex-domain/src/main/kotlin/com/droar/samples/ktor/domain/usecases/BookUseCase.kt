package com.droar.samples.ktor.domain.usecases

import com.droar.samples.ktor.domain.Book

interface BookUseCase {

    fun getBooks(): List<Book>

    fun getBook(id: Int): Book?

    fun addBook(book: Book): Book

    fun deleteBook(id: Int): Book?
}