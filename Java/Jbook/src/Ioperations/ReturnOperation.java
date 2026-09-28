package Ioperations;

import book.Book;
import book.BookList;

import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: wzs
 * Date: 2026-04-20
 * Time: 7:22
 */
public class ReturnOperation implements IOPeration{
    @Override
    public void work(BookList bookList) {
       // System.out.println("归还图书");

        System.out.println("请输入要归还的书名：");
        Scanner scanner=new Scanner(System.in);
        String name=scanner.nextLine();

        int currentSize=bookList.getUsedSize();

        int pos=-1;
        int i=0;
        Book book=bookList.getBook(i);
        for(;i<currentSize;i++){

            if(book.getName().equals(name)) {
                pos=i;
                break;
            }
        }

        if(pos==currentSize||pos==-1){
            System.out.println("没有这本书");
            return;
        }

        bookList.getBook(pos).setBorrowed(false);
        System.out.println("归还成功！！！");
    }
}
