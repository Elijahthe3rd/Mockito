package MockitoDummy;

import java.time.LocalDate;
import java.util.UUID;

public class BookClass {
    private UUID uuid;
    private String author;
    private String Title;
    private LocalDate published_year;
    private double price;

    public BookClass( UUID uuid, String author, String title, LocalDate published_year, double price ) {
        this.uuid = uuid;
        this.author = author;
        Title = title;
        this.published_year = published_year;
        this.price = price;
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid( UUID uuid ) {
        this.uuid = uuid;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor( String author ) {
        this.author = author;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle( String title ) {
        Title = title;
    }

    public LocalDate getPublished_year() {
        return published_year;
    }

    public void setPublished_year( LocalDate published_year ) {
        this.published_year = published_year;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice( double price ) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "\nBookClass:\n{" +
                "\n\tuuid=" + uuid +
                ", \n\tauthor='" + author + '\''+
                ", \n\tTitle='" + Title + '\''+
                ", \n\tpublished_year=" + published_year+
                ", \n\tprice=" + price +"\n"+
                '}'+"";
    }
}
