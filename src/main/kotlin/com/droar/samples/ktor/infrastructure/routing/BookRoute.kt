package com.droar.samples.ktor.infrastructure.routing

import com.droar.samples.ktor.domain.Book
import com.droar.samples.ktor.application.services.BookService
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import io.ktor.util.pipeline.*

fun Route.bookRoutes() {
    val bookService = BookService()

    route("books") {
        get("/{id}") {
            val bookIdFromQuery = getParameter("id")
            val book = bookService.getBook(bookIdFromQuery.toInt())

            if (book == null) {
                call.respond(HttpStatusCode.NotFound, "Book not found");
            } else {
                call.respond(book)
            }
        }

        post("") {
            // Call receive a book, deserialized as a book
            val requestBody = call.receive<Book>()
            bookService.addBook(requestBody)
            call.respond(requestBody)
        }

        get("") {
            call.respond(bookService.getBooks())
        }

        delete("/{id}"){
            val bookIdFromQuery = getParameter("id")
            val book = bookService.deleteBook(bookIdFromQuery.toInt())

            if (book == null) {
                call.respond(HttpStatusCode.NotFound, "Book not found");
            } else {
                call.respond("Deleted book: $book")
            }
        }
    }
}

private fun PipelineContext<Unit, ApplicationCall>.getParameter(parameter: String): String {
    val parameterFromQuery = call.parameters[parameter] ?: kotlin.run {
        throw Exception("Please provide a valid parameter") // Simple handling
    }
    return parameterFromQuery
}