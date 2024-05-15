package week11.j063;

public class Todo {
    private String Tname;
    private String TDetail;
    private String TDate;
    private String TCate;

    public Todo(String Tname, String TDetail, String TDate, String TCate) {
        this.Tname = Tname;
        this.TDetail = TDetail;
        this.TDate = TDate;
        this.TCate=TCate;
    }

    public String getTname() {
        return Tname;
    }

    public void setTname(String Tname) {
        this.Tname = Tname;
    }

    public String getTDetail() {
        return TDetail;
    }

    public void setTDetail(String TDetail) {
        this.TDetail = TDetail;
    }

    public String getTDate() {
        return TDate;
    }

    public void setTDate(String TDate) {
        this.TDate = TDate;
    }

    public String getTCate() {
        return TCate;
    }

    public void setTCate(String TCate) {
        this.TCate = TCate;
    }



    @Override
    public String toString() {
        return "Todo [Title: " + Tname + ", " +
                "Detail: " + TDetail + ", " +
                "Date: " + TDate + ", "+
                "Category: "+TCate+"]";
    }
}
