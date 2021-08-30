package MockitoDummy;

import java.util.Collection;

public interface BookDao {

    void save( BookClass book);
    Collection< BookClass > findAll();
    Collection< BookClass > findAllBookCollection();

}
