package AnnotationsTests;

import mockitoAnnotations.support.BookClass;
import mockitoAnnotations.support.BookDao;
import mockitoAnnotations.support.BookService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

@ExtendWith( MockitoExtension.class )//1's alternative
public class AnnotationTest {

    @Mock//1's alternative
    private BookDao bookDao;

    @InjectMocks//2's alternatives
    private BookService bookService;

    @Test
    public void demoCreateMocksUsingAnnotations() {
//1      BookDao bookDao=mock(BookDao.class);
//2      BookService bookService = new BookService( bookDao );

        BookClass book1 = new BookClass( UUID.randomUUID(), "Elijah-Sepuru", "nka modira", LocalDate.now(), 500 );
        BookClass book2 = new BookClass( UUID.randomUUID(), "SB", "modirile", LocalDate.now(), 400 );
        BookClass book3 = new BookClass( UUID.randomUUID(), "mike", " modirile", LocalDate.now(), 10000 );

        List < BookClass > bookClassList = new ArrayList <>();//local data
        bookClassList.add( book1 );
        bookClassList.add( book2 );
        bookClassList.add( book3 );

        when( bookDao.findNewBooks( 7 ) ).thenReturn( bookClassList );
        List < BookClass > newBookClassListWithAppliedDiscount = bookService.getNewBooksWithAppliedDiscount( 10, 7 );
        assertNotNull( bookDao );
        assertEquals( 3, newBookClassListWithAppliedDiscount.size() );
        assertEquals( 450.0, newBookClassListWithAppliedDiscount.get( 0 ).getPrice() );
        assertEquals( 360, newBookClassListWithAppliedDiscount.get( 1 ).getPrice() );
        assertEquals( 9000, newBookClassListWithAppliedDiscount.get( 2 ).getPrice() );
        doReturn( book1 ).when( bookDao ).findNewBooks( 7 );
        verify( bookDao ).findNewBooks( 7 );
    }
}
