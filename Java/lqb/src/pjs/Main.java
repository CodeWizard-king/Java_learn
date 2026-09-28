package pjs;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();

        // 预处理所有平方数 < 1_000_000
        Set<Integer> squareSet = new HashSet<>();
        for (int i = 1; i * i < 1_000_000; i++) {
            squareSet.add(i * i);
        }

        // 找出 [a, b] 范围内的所有平方数
        int startRoot = (int) Math.ceil(Math.sqrt(a));
        int endRoot = (int) Math.floor(Math.sqrt(b));

        for (int root = startRoot; root <= endRoot; root++) {
            int n = root * root;
            String s = String.valueOf(n);
            if (s.length() < 2) continue; // 至少两位才能分割

            boolean valid = false;
            // 尝试所有分割点：1 到 len-1
            for (int i = 1; i < s.length(); i++) {
                String leftStr = s.substring(0, i);
                String rightStr = s.substring(i);

                // 排除前导零（长度>1且首字符为'0'）
                if ((leftStr.length() > 1 && leftStr.charAt(0) == '0')) {
                    continue;
                }

                int left = Integer.parseInt(leftStr);
                int right = Integer.parseInt(rightStr);

                // 题目规定 0 不算平方数
                if (left == 0 || right == 0) continue;

                if (squareSet.contains(left) && squareSet.contains(right)) {
                    valid = true;
                    break;
                }
            }

            if (valid) {
                System.out.println(n);
            }
        }
    }
}