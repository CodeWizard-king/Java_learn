package use;

import Ioperations.*;

import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: wzs
 * Date: 2026-04-19
 * Time: 20:40
 */
public class NormalUser extends User{

    public NormalUser(String name) {
        super(name);
        this.ioPerations=new IOPeration[]{
                new ExitOperation(),
                new FindOperation(),
                new BorrowOperation(),
                new ReturnOperation(),
        };
    }

    @Override
    public int menu() {
        System.out.println("欢迎"+this.name+"来到图书系统");
        System.out.println("*****管理员菜单*****");
        System.out.println("1. 查找图书");
        System.out.println("2. 借阅图书");
        System.out.println("3. 归还图书");
        System.out.println("0. 退出系统");
        System.out.println("******************");
        System.out.println("请输入你的操作:");
        Scanner scanner=new Scanner(System.in);
        int choice=scanner.nextInt();
        return choice;
    }

}