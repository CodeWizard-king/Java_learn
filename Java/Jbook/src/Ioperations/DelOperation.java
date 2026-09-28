package Ioperations;

import book.Book;
import book.BookList;

import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: wzs
 * Date: 2026-04-20
 * Time: 7:21
 */
public class DelOperation implements IOPeration{
    @Override
    public void work(BookList bookList) {
        //System.out.println("删除图书");
        System.out.println("请输入要删除的书名：");
        Scanner scanner=new Scanner(System.in);
        String name=scanner.nextLine();
        int currentSize=bookList.getUsedSize();

        int pos=-1;
        int i=0;
        for(;i<currentSize;i++){
            Book book=bookList.getBook(i);
            if(book.getName().equals(name)) {
                pos=i;
                break;
            }
        }

        if(pos==currentSize||pos==-1){
            System.out.println("没有找到这本书");
            return;
        }

        for(int j=pos;j<currentSize-1;j++){
            Book book=bookList.getBook(j+1);
            bookList.setBook(j,book);
        }

        bookList.setUsedSize(currentSize-1);
        bookList.setBook(currentSize-1,null);
        System.out.println("删除成功！！！");
    }
}
