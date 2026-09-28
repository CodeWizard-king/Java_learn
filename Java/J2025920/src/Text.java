import java.util.Random;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: wzs
 * Date: 2025-09-20
 * Time: 21:12
 */
public class Text {

    // 在同一个类中定义多个方法：要求不仅可以求2个整数的最大值，还可以求3个小数的最大值？
    public static void main(String[] args) {
        
    }

    // 在同一个类中,分别定义求两个整数的方法 和 三个小数之和的方法。 并执行代码，求出结果

    public static int AddInt(int a,int b){
        return a+b;
    }

    public static double AddDouble(double a,double b,double c){
        return a+b+c;
    }
    public static void main11(String[] args) {
        Scanner scan=new Scanner(System.in);
        int n=scan.nextInt();
        int m=scan.nextInt();
        System.out.println(AddInt(n,m));

        double a=scan.nextDouble();
        double b=scan.nextDouble();
        double c=scan.nextDouble();
        System.out.println(AddDouble(a,b,c));
    }



    public  static  int max2(int a,int b){
        if(a>b)return a;
        return b;
    }

    public  static  int max3(int a,int b, int c){
        return max2(max2(a,b),c);
    }
    public static void main10(String[] args) {
        Scanner scan=new Scanner(System.in);
        int a=scan.nextInt();
        int b=scan.nextInt();
        System.out.println(max2(a,b));

        int c=scan.nextInt();
        System.out.println(max3(a,b,c));
    }













/*
    // 求斐波那契数列的第 N 项
    public  static  int fib(int n){
        if(n==1||n==2)
            return 1;
        return fib(n-1)+fib(n-2);
    }
    public static void main9(String[] args) {
        System.out.println(fib(10));
    }
    // 写一个递归方法，输入一个非负整数，返回组成它的数字之和. 例如，输入 1729, 则应该返回1+7+2+9，它的和是19
    public  static  int sum1(int n){
        if(n<10)
            return n;
        return n%10+sum1(n/10);
    }
    public static void main8(String[] args) {
        System.out.println(sum1(1729));
    }
    // 递归求 1 + 2 + 3 + ... + 10
    public  static int sum(int n){
        if(n==1)
            return 1;
        return n+sum(n-1);
    }
    public static void main7(String[] args) {
        System.out.println(sum(10));
    }

    // 按顺序打印一个数字的每一位(例如 1234 打印出 1 2 3 4)
    public  static  void print(int n){
        if(n>9){
            print(n/10);
        }
        System.out.println(n%10);
    }
    public static void main6(String[] args) {
        print(1234);
    }
    public  static  int num(int n){
        if(n==1) return 1;
        return n * num(n-1);
    }

    public static void main5(String[] args) {
        System.out.println(num(5));
    }
*/
















/*
    public static boolean isLeapYear(int year){
        if( (year%4==0&&year%100!=0) || (year%400==0) ){
            return true;
        }
        return false;
    }

    public static int fac(int n){
        System.out.println("计算n的阶乘n!="+n);
        int sum=0;
        for (int i = 1; i <= n; i++) {
            sum*=i;
        }
        return sum;
    }

    public  static  void swap(int x,int y){
        int tmp=x;
        x=y;
        y=tmp;
    }

    public  static  int add(int a,int b){
        return a+b;
    }

    public  static double add(double a,double b){
        return a+b;
    }

    public static void main4(String[] args) {
        int a=20;
        int b=10;
        add(a,b);

        double m=10.0;
        double n=20.0;
        add(m,n);

    }

    public static void main3(String[] args) {
        int x=10;
        int y=20;
        swap(x,y);
        System.out.println(x+" "+y);
    }
    public static void main2(String[] args) {
        Scanner scan=new Scanner(System.in);
        int n=scan.nextInt();
        System.out.println(fac(n));
    }


    public static void main1(String[] args) {
        Scanner scan=new Scanner(System.in);
        int year=scan.nextInt();
        boolean ret=isLeapYear(year);
        if(ret==true){
            System.out.println("是闰年");
        }else {
            System.out.println("不是闰年");
        }
    }*/
}
