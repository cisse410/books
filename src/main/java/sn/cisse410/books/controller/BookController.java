package sn.cisse410.books.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import sn.cisse410.books.model.Book;
import sn.cisse410.books.service.BookService;
import sn.cisse410.books.utils.CustomResponse;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping("/api")
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping("/books")
    public ResponseEntity<Object> getAllBooks() {
        List<Book> books = bookService.getAllBooks();
        return CustomResponse.customResponseHandler("Voici la liste des livres disponibles en libraire", HttpStatus.OK,
                books);
    }

    @GetMapping("/book/{id}")
    public ResponseEntity<Object> getBookById(@PathVariable Long id) {
        Book book = bookService.getBookById(id);
        return CustomResponse.customResponseHandler("Voici les informations du livre de: \'" + book.getAuthor() + "\'",
                HttpStatus.OK, book);
    }

    @PostMapping("/add-book")
    public ResponseEntity<Object> addBook(@RequestBody Book book) {
        Book addedBook = bookService.addBook(book);
        return CustomResponse.customResponseHandler("Livre ajouté avec succés", HttpStatus.CREATED, addedBook);
    }

    @PutMapping("book/{id}")
    public ResponseEntity<Object> updateBook(@PathVariable Long id, @RequestBody Book book) {
        Book updatedBook = bookService.updateBook(book);
        return CustomResponse.customResponseHandler("Livre modifié avec succés", HttpStatus.OK, updatedBook);
    }

    @DeleteMapping("/book/{id}")
    public ResponseEntity<Object> removeBook(@PathVariable Long id) {
        bookService.removeBook(id);
        return CustomResponse.customResponseHandler("Livre supprimé avec succés", HttpStatus.NO_CONTENT, id);
    }

}
