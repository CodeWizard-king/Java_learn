package sttj;

import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: wzs
 * Date: 2025-12-01
 * Time: 22:59
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int n = scanner.nextInt();
        int today=1;
        int sum=0,count=0;
        while(sum<n){
            if(today>7){
                today-=7;
            }
            if(today<6){
                sum+=a;
            }
            else {
                sum+=b;
            }
            today++;
            count++;
        }
        System.out.println(count);
    }
}
