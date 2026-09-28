package cfb;

import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: wzs
 * Date: 2025-11-30
 * Time: 22:03
 */
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int P = scanner.nextInt();

        for (int i = 1; i < P; i++) {
            StringBuilder line = new StringBuilder();
            for (int j = 1; j <= i; j++) {
                int product = i * j;
                // 将 i, j, product 转为 P 进制字符串（大写）
                String a = Integer.toString(i, P).toUpperCase();
                String b = Integer.toString(j, P).toUpperCase();
                String c = Integer.toString(product, P).toUpperCase();
                String expr = a + "*" + b + "=" + c;
                if (line.length() > 0) {
                    line.append(" ");
                }
                line.append(expr);
            }
            System.out.println(line.toString());
        }
    }
}
