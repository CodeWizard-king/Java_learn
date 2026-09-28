package book;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: wzs
 * Date: 2026-04-19
 * Time: 20:07
 */
public class BookList {
    private Book[] books=new Book[10];
    private int usedSize;//统计图书本数

    public BookList(){
        this.books[0] = new Book("三国演义","罗贯中",10,"小说");
        this.books[1] = new Book("西游记","吴承恩",12,"小说");
        this.books[2] = new Book("红楼梦","曹雪芹",11,"小说");
        usedSize=3;
    }

    public Book getBook(int pos,Book book) {
        return books[pos]=book;
    }

    public Book[] getBooks() {
        return books;
    }

    public Book getBook(int pos) {
        return books[pos];
    }
    public void setBook(int pos, Book book) {
        this.books[pos] = book;
    }

    public int getUsedSize() {
        return usedSize;
    }

    public void setUsedSize(int usedSize) {
        this.usedSize = usedSize;
    }
}
