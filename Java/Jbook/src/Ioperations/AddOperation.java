package Ioperations;

import book.Book;
import book.BookList;

import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: wzs
 * Date: 2026-04-20
 * Time: 7:20
 */
public class AddOperation implements IOPeration{
    @Override
    public void work(BookList bookList) {
        System.out.println("新增图书");
        // 1.判满
        int currentSize = bookList.getUsedSize();
        if (currentSize == bookList.getBooks().length) {
            System.out.println("书架已满，无法新增！");
            return;
        }

        // 2.输入图书信息
        Scanner scanner = new Scanner(System.in);

        System.out.print("请输入书名：");
        String name = scanner.nextLine();

        //判重
        for (int i = 0; i < currentSize; i++) {
            Book book = bookList.getBook(i);
            if (book != null && book.getName().equals(name)) {  // 修复空指针
                System.out.println("该书已存在，不能插入！");
                return;
            }
        }

        System.out.print("请输入作者：");
        String author = scanner.nextLine();

        System.out.print("请输入价格：");
        double price = 0.0;
        while (true) {
            if (scanner.hasNextDouble()) {
                price = scanner.nextDouble();
                if (price < 0) {  // 修复负数价格
                    System.out.println("价格不能为负数，请重新输入！");
                    continue;
                }
                break;
            } else {
                System.out.println("价格必须是数字，请重新输入：");
                scanner.next();
            }
        }
        scanner.nextLine(); // 吃掉换行符

        System.out.print("请输入书的类型：");
        String type = scanner.nextLine();



        // 3.判断是否已存在这本书
        for (int i = 0; i < currentSize; i++) {
            Book book = bookList.getBook(i);
            if (book.getName().equals(name)) {
                System.out.println("该书已存在，不能插入！");
                return;
            }
        }

        Book newBook = new Book(name, author, price, type);

        // 4.插入图书
        bookList.setBook(currentSize, newBook);
        bookList.setUsedSize(currentSize + 1);
        System.out.println("新增图书成功！！！");
    }
}
