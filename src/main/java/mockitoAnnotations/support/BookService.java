package mockitoAnnotations.support;

import MockitoDummy.EmailsService;

import java.util.List;

public class BookService {

    private BookDao bookDao;

    public BookService( BookDao bookRepo ) {
        this.bookDao=bookRepo;
    }

    public List < BookClass > getNewBooksWithAppliedDiscount( int discountRate, int days){
        List< BookClass > newBooks=bookDao.findNewBooks(days);
        //500 apply 10%-> 10% OF 500=50
        //THEREFORE: 500-50=450books
        for ( BookClass book_class : newBooks) {
            double price=book_class.getPrice();
            double newPrice =price- ((discountRate * price) / 100);
            book_class.setPrice(newPrice);
        }
        return newBooks;
    }

}
