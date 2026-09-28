package Ioperations;

import book.Book;
import book.BookList;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: wzs
 * Date: 2026-04-20
 * Time: 7:22
 */
public class ShowOperation implements IOPeration{
    @Override
    public void work(BookList bookList) {
        System.out.println("显示图书");
        int currentSize=bookList.getUsedSize();//数组长度
        for(int i=0;i<currentSize;i++){
            Book book=bookList.getBook(i);
            System.out.println(book);
        }
    }
}
