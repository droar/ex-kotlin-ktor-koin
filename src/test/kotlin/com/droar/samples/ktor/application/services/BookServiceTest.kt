package com.droar.samples.ktor.application.services

import com.droar.samples.ktor.domain.Book
import io.kotest.matchers.collections.shouldNotBeEmpty
import io.kotest.matchers.equality.shouldBeEqualToComparingFields
import io.kotest.matchers.nulls.shouldBeNull
import io.kotest.matchers.nulls.shouldNotBeNull
import org.junit.jupiter.api.Test

internal class BookServiceTest {

    companion object {
        private const val AN_ID = 1000
        private const val AN_EXISTENT_BOOK_ID = 1
        private const val A_TITTLE = "a-title"
        private const val AN_AUTHOR = "an-author"
        private const val SOME_PUBLICATION = "some-publication"
    }

    @Test
    fun `books are loaded properly`(){
        // Given - When
        val underTest = BookService()

        // Then
        underTest.getBooks().shouldNotBeEmpty()
    }

    @Test
    fun `a book is properly added`(){
        // Given
        val underTest = BookService()

        // When
        val result = underTest.addBook(buildBook(AN_ID))

        // Then
        underTest.getBook(AN_ID)?.shouldBeEqualToComparingFields(result)
    }

    @Test
    fun `an already existent book returns the same book`(){
        // Given
        val underTest = BookService()

        // When
        val result = underTest.addBook(buildBook(AN_EXISTENT_BOOK_ID))

        // Then
        underTest.getBook(AN_EXISTENT_BOOK_ID)?.shouldBeEqualToComparingFields(result)
    }

    @Test
    fun `an existent book can be deleted properly`(){
        // Given
        val underTest = BookService()
        underTest.getBook(AN_EXISTENT_BOOK_ID).shouldNotBeNull()

        // When
        underTest.deleteBook(AN_EXISTENT_BOOK_ID)

        // Then
        underTest.getBook(AN_EXISTENT_BOOK_ID).shouldBeNull()
    }

    private fun buildBook(id: Int): Book = Book(id, A_TITTLE, AN_AUTHOR, SOME_PUBLICATION)
}