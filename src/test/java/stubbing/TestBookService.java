package stubbing;

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
import static org.mockito.Mockito.*;

@ExtendWith( MockitoExtension.class )
public class TestBookService {

    private static BookClass book1;
    private static BookClass book2;
    private static BookClass book3;

    @InjectMocks
    private BookService bookService;

    @Mock
    private BookDao bookDao;

    @Test
    public void testCalculateTotalCostOfBooks() {

        book1 = new BookClass( UUID.randomUUID(), "Elijah-Sepuruss", "nka dmodira", LocalDate.now(), 500 );
        book2 = new BookClass( UUID.randomUUID(), "SBd", "modfirile", LocalDate.now(), 400 );
        book3 = new BookClass( UUID.randomUUID(), "mikde", " moddirile", LocalDate.now(), 10000 );

        List < BookClass > books = new ArrayList <>();

        books.add( book1 );
        books.add( book2 );
        books.add( book3 );

        List < UUID > ids = new ArrayList <>();
        ids.add( books.get( 0 ).getUuid() );
        ids.add( books.get( 1 ).getUuid() );
        ids.add( books.get( 2 ).getUuid() );

        //stubbing can only be performed on a mocked instance or object
        when( bookDao.findBooksById( ids.get( 0 ) ) ).thenReturn( book1 );
        when( bookDao.findBooksById( ids.get( 1 ) ) ).thenReturn( book2 );
        when( bookDao.findBooksById( ids.get( 2 ) ) ).thenReturn( book3 );

        //using the service class/object AKA interface mocking
        double cost = bookService.calculateTotalBooksCosts( books );

        assertEquals( 10900, cost );
        lenient().doReturn( book1).when( bookDao ).findBooksById( book1.getUuid() );

        lenient().doReturn( book1).when( bookDao ).findBooksById( ids.get( 1 ) );
        //Mock.Verify can only be performed on a mocked instance or object
        verify( bookDao ).findBooksById( ids.get( 1 ) );
    }

    @Test
    public void testAdd(){
        BookClass book = new BookClass( UUID.randomUUID(), "Marcelo","Book of Eli",LocalDate.of( 1993,04,26 ),680);
        doNothing().when(bookDao).saveBook(book);
        bookService.addBook( book );
    }
}
