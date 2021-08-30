package Dummy;

import Fake.BookClass;
import Fake.BookDao;
import Fake.BookService;
import FakeTest.FakeBookDao;
import MockitoDummy.EmailsService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


import java.time.LocalDate;
import java.util.UUID;

public class TestDummy {

    private static BookClass book;
    private static BookDao bookDao;
    private static EmailsService service;
    private static BookService bookService;

    @Test
    public void demoDummy() {
        BookDao bookDao = new FakeBookDao();
        EmailsService emailsService = new DummyEmailServiceImpl();
        BookService bookService = new BookService( bookDao, emailsService );
        bookService.addBook(
                book = new BookClass(
                        UUID.randomUUID(),
                        "Shake Spear",
                        "Let me Not To the Marriage of True Minds",
                        LocalDate.now(),
                        20.28 ) );
        bookService.addBook(
                book = new BookClass(
                        UUID.randomUUID(),
                        "Dinesh",
                        "Mockito in action",
                        LocalDate.now(),
                        30.28 ) );
        Assertions.assertEquals("Method Not implemented!!!",emailsService.sendEmailsService( "ssss" ));
        Assertions.assertTrue( bookService.findAllBookCollection().size() > 1 );
    }


//    @Test
//    public void testFake() {
//
//    }
}
