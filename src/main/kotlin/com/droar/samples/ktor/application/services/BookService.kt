package com.droar.samples.ktor.application.services

import com.droar.samples.ktor.domain.Book

class BookService {
    private val books = mutableListOf<Book>()

    init {
        books.add(Book(1, "The Inhumanity of people", "Krospotoff", "The wellness of humans"))
        books.add(Book(2, "The Inhumanity of revolvers", "Retungaff", "The wellness of revolvers"))
        books.add(Book(3, "The Incomprensible Joe", "Krospotoff", "The wellness of joe"))
        books.add(Book(4, "The Rare of sea", "Isunsoe", "The wellness of the sea"))
        books.add(Book(5, "The Abnormal thing", "Krospotoff", "The wellness of abnormality"))
        books.add(Book(6, "The Sad Cat", "CatnessFell", "The wellness of cats"))
    }

    fun getBooks(): List<Book> = books

    fun getBook(id: Int): Book? = books.find { it.id == id }

    fun addBook(book: Book): Book {
        val foundBook = books.find { it.id == book.id }.let {
            if (it == null) {
                books.add(book)
                book
            } else {
                it
            }
        }
        return foundBook
    }

    fun deleteBook(id: Int): Book? {
        return books.find { it.id == id }?.also { books.remove(it) }
    }
}