package Dummy;

import Fake.BookClass;
import Fake.BookDao;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class FakeBookDao implements BookDao {
    //in memory database,hashmap or list
    Map < UUID,BookClass> bookStore=new HashMap <>();


    @Override
    public void save( BookClass book ) {
        bookStore.put( book.getUuid(),book);
    }

    @Override
    public Collection < BookClass > findAll() {
        return bookStore.values();
    }

    @Override
    public Collection < BookClass > findAllBookCollection() {
        return bookStore.values();
    }
}
