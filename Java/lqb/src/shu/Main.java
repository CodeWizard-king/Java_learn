package shu;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int a=scanner.nextInt();
        int b=scanner.nextInt();

        Set<Integer>squareSet=new HashSet<>();
        for(int i=1;i*i<1000000;i++)
        {
            squareSet.add(i*i);
        }

        int startRoot=(int)Math.ceil(Math.sqrt(a));
        int endRoot=(int)Math.ceil((Math.sqrt(b)));

        for(int root=startRoot;root<=endRoot;root++){
            int n=root*root;
            String s=String.valueOf(n);
            if(s.length()<2){
                continue;
            }

            boolean voila=false;

            for (int i=1;i<s.length();i++){
                String leftStr=s.substring(0,i);
                String rightStr=s.substring(i);

                if(leftStr.length()>1&&leftStr.charAt(0)=='0'){
                    continue;
                }

                int left=Integer.parseInt(leftStr);
                int right=Integer.parseInt(rightStr);

                if(left==0 || right==0){
                    continue;
                }

                if(squareSet.contains(left)&&squareSet.contains(right)){
                    voila=true;
                    break;
                }
            }
            if(voila==true){
                System.out.println(n);
            }
        }
    }
}