import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: wzs
 * Date: 2025-09-14
 * Time: 9:19
 */
public class zy {
    // 求一个整数，在内存当中存储时，二进制1的个数。
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int n=in.nextInt();
        int count=0;
        while(n!=0){
            n=n&(n-1);
            count++;
        }
        System.out.println(count);
    }
    // 给定两个数，求这两个数的最大公约数
    public static void main6(String[] args) {
        Scanner in= new Scanner(System.in);
        int a=in.nextInt();
        int b=in.nextInt();
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        System.out.println(a);
    }
    // 计算1/1-1/2+1/3-1/4+1/5 …… + 1/99 - 1/100 的值    。
    public static void main5(String[] args) {
        float sum= 0L;
        for (int i = 1; i <= 100; i++) {
            if(i%2==1){
            sum+=(1.0/i);
            }
            else{
               sum-=(1.0/i);
            }
        }
        System.out.println(sum);
    }
    // 求出0～n之间的所有“水仙花数”并输出。(“水仙花数”是指一个三位数，其各位数字的立方和确好等于该数本 身，如；153＝1^3＋5^3＋3^3，则153是一个“水仙花数“。）
    public static void main4(String[] args) {
        Scanner in = new Scanner(System.in);
        int n=in.nextInt();
        for (int i = 100; i <= n; i++) {
            int sum=0;
            int num=i;
            while(num!=0){
                sum+=(num%10)*(num%10)*(num%10);
                num/=10;
            }
            if(sum==i)
                System.out.print(i+" ");
        }

    }
        public static void main3(String[] args) {
            Scanner in = new Scanner(System.in);
            while (in.hasNextInt()) {
                int n = in.nextInt();
                int h = n;
                int s = n;
                for (int i = 0; i < s; i++) {
                    for (int j = 0; j < h; j++) {
                        if (i == j || (i + j) == (h - 1)) {
                            System.out.print("*");
                        } else {
                            System.out.print(" ");
                        }
                    }
                    System.out.println();
                }
            }
        }
    //给定一个数字，判定一个数字是否是素数
    public static void main2(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int i=2;
        while (i<n){
            if(n%i!=0) {
                break;
            }
            i++;
        }
        if(i==n){
            System.out.println("不是素数");
        }
        else{
            System.out.println("是素数");
        }
    }
    // 编写程序数一下 1到 100 的所有整数中出现多少个数字9
    public static void main1(String[] args) {
        int num=0;
        for (int i = 1; i <= 100; i++) {
            if(i%10==9){
                num++;
            }
            if (i/10==9) {
                num++;
            }
        }
        System.out.println(num);
    }
}
