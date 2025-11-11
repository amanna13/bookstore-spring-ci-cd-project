package com.amanna.bookstoreapicicdtest.service;

import com.amanna.bookstoreapicicdtest.model.Book;
import com.amanna.bookstoreapicicdtest.repository.BookRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class BookServiceTest {

    @Mock
    private BookRepository bookRepository;

    @InjectMocks
    private BookService bookService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetAllBooks() {
        //Arrange
        Book book1 = new Book(1L, "Atomic Habits", "James Clear", 499);
        Book book2 = new Book(2L, "The Alchemist", "Paulo Coelho", 399);
        when(bookRepository.findAll()).thenReturn(Arrays.asList(book1, book2));

        //Act
        List<Book> books = bookService.getAllBooks();

        //Assert
        assertEquals(2, books.size());
        verify(bookRepository, times(1)).findAll();
    }

    @Test
    void testAddBook() {
        // Arrange
        Book newBook = new Book(null, "Deep Work", "Cal Newport", 599);
        when(bookRepository.save(any(Book.class))).thenReturn(
                new Book(1L, "Deep Work", "Cal Newport", 599)
        );

        // Act
        Book savedBook = bookService.addBook(newBook);

        // Assert
        assertNotNull(savedBook.getId());
        assertEquals("Deep Work", savedBook.getTitle());
        verify(bookRepository, times(1)).save(newBook);
    }

    @Test
    void testGetBookById() {
        // Arrange
        Book book = new Book(1L, "Clean Code", "Robert C. Martin", 699);
        when(bookRepository.findById(1L)).thenReturn(Optional.of(book));

        // Act
        Optional<Book> foundBook = bookService.getBookById(1L);

        // Assert
        assertTrue(foundBook.isPresent());
        assertEquals("Clean Code", foundBook.get().getTitle());
        verify(bookRepository, times(1)).findById(1L);
    }
}
