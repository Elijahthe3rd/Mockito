package Fake;

import MockitoDummy.EmailsService;

import java.util.Collection;

public class BookService {

    private BookDao bookDao;

    public BookService( BookDao bookDao, EmailsService emailsService ) {
        this.bookDao = bookDao;
    }

    public BookService( BookDao bookRepo ) {
        this.bookDao=bookRepo;
    }

    public void addBook(BookClass book_class){
        bookDao.save(book_class);
    }

    public int findNumberOfBookCollection(){
        return bookDao.findAll().size();
    }

    public Collection<BookClass> findAllBookCollection(){
        return bookDao.findAllBookCollection();
    }


}
