package stubbing;

import java.util.List;
import java.util.UUID;

public interface BookDao {
    List< BookClass > findNewBooks( int days );
    BookClass findBooksById( UUID bookId );

    void saveBook( BookClass book );
}
