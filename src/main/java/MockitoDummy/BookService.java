package MockitoDummy;

import java.util.Collection;

public class BookService {

    private BookDao bookDao;
    private  EmailsService emailsService;

    public BookService( BookDao bookDao ,EmailsService emailsService ) {
        this.emailsService = emailsService;
        this.bookDao = bookDao;
    }


    public void addBook( BookClass book_class){
        bookDao.save(book_class);
    }

    public int findNumberOfBookCollection(){
        return bookDao.findAll().size();
    }

    public Collection< BookClass > findAllBookCollection(){
        return bookDao.findAllBookCollection();
    }

    public void sendEmail( String msg){}

}
