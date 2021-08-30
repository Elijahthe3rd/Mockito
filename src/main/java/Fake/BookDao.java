package Fake;

import java.util.Collection;

public interface BookDao {

    void save( BookClass book);
    Collection<BookClass> findAll();
    public Collection<BookClass> findAllBookCollection();

}
