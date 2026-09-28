package Ioperations;

import book.BookList;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: wzs
 * Date: 2026-04-20
 * Time: 7:21
 */
public class ExitOperation implements IOPeration{
    @Override
    public void work(BookList bookList) {
        System.out.println("退出系统");
        System.exit(0);
    }
}
