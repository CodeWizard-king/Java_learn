package Ioperations;

import book.Book;
import book.BookList;

import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: wzs
 * Date: 2026-04-20
 * Time: 7:19
 */
public class FindOperation implements IOPeration{
    @Override
    public void work(BookList bookList) {
        //System.out.println("查找图书");

        System.out.println("请输入要查找的书名：");
        Scanner scanner=new Scanner(System.in);
        String name=scanner.nextLine();

        int currentSize=bookList.getUsedSize();//数组长度

        for(int i=0;i<currentSize;i++){
            Book book=bookList.getBook(i);
            if(book.getName().equals(name)) {
                System.out.println("找到了这本书:");
                System.out.println(book);
                return;
            }
        }
        System.out.println("没有找到这本书");
    }
}
