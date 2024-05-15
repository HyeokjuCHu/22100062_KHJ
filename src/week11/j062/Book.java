package week11.j062;

public class Book {
    private String Bname;
    private String Bauth;
    private String Bcate;
    private int price;
    private int year;

    public Book(String Bname, String Bauth, String Bcate, int price, int year) {
        this.Bname = Bname;
        this.Bauth = Bauth;
        this.Bcate = Bcate;
        this.price=price;
        this.year=year;
    }

    public String getBname() {
        return Bname;
    }

    public void setBname(String Bname) {
        this.Bname = Bname;
    }

    public String getBauth() {
        return Bauth;
    }

    public void setBauth(String Bauth) {
        this.Bauth = Bauth;
    }

    public String getBcate() {
        return Bcate;
    }

    public void setBcate(String Bcate) {
        this.Bcate = Bcate;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getYear() {
        return year;
    }

    public void setYEar(int year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return "Book [Book: " + Bname + ", " +
                "Author: " + Bauth + ", " +
                "Category: " + Bcate + ", "+
                "Price: "+price+", "+
                "Year: "+year+"]";
    }
}
