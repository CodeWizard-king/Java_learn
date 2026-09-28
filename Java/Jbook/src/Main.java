import book.BookList;
import use.AdminUser;
import use.NormalUser;
import use.User;

import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: wzs
 * Date: 2026-04-19
 * Time: 20:42
 */
public class Main {
    public static User login() {
        System.out.println("请输入你的姓名:");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        int choice;
        do {
            System.out.println("请输入你的身份：1.管理员 2.普通用户");
            choice = scanner.nextInt();
        }while(choice!=1&&choice!=2);
        if(choice==1){
            return new AdminUser(name);
        }else{
            return new NormalUser(name);
        }
    }

    public static void main(String[] args) {
        User user = login();
        BookList bookList = new BookList();
        while(true) {
            int choice = user.menu();
            user.doIoperation(choice,bookList);
        }
    }
}
