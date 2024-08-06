package sn.cisse410.books.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import sn.cisse410.books.model.Book;

public interface BookRepository extends JpaRepository<Book, Long> {

}
