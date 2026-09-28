import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: wzs
 * Date: 2025-09-29
 * Time: 19:39
 */


public class Date {
    public int year;
    public int month;
    public int day;

    public void setDate(int year,int month,int day){
        this.year=year;
        this.month=month;
        this.day=day;
    }

    public  Date(){
        this(2009,1,1);
        System.out.println("这是一个不带参的构方法····");
    }
    public Date(int year,int month,int day){
        this.year=year;
        this.month=month;
        this.day=day;
    }
    public void setPrint(){
        System.out.println(year+"年"+month+"月"+day+"日");
    }

    public static void main(String[] args) {
        Date date1=new Date();
        //date1.setDate(2008,8,8);
        date1.setPrint();
    }
}
