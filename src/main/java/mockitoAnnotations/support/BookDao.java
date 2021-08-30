package mockitoAnnotations.support;

import java.util.List;

public interface BookDao {
    List< BookClass > findNewBooks( int days );
}
