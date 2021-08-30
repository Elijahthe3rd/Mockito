package FakeTest;

import Fake.BookClass;
import Fake.BookDao;
import Fake.BookService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.UUID;

public class FakeTest {
        private static BookClass book;
        private static BookService service;

        private static BookDao bookRepo;

        @BeforeAll
        public static void setup() {
            bookRepo = new FakeBookDao();

            service = new BookService( bookRepo );
        }

    @Test
    public void testFake() {
        service.addBook(
                book = new BookClass(
                        UUID.randomUUID(),
                        "Shake Spear",
                        "Let me Not To the Marriage of True Minds",
                        LocalDate.now(),
                        20.28 ) );
        service.addBook(
                book = new BookClass(
                        UUID.randomUUID(),
                        "Dinesh",
                        "Mockito in action",
                        LocalDate.now(),
                        30.28 ) );
        Assertions.assertEquals( 2, service.findNumberOfBookCollection() );
        Assertions.assertEquals( service.findAllBookCollection(),service.findAllBookCollection());
        System.out.println(service.findAllBookCollection());
    }
}
