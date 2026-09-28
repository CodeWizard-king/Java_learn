package demo2;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: wzs
 * Date: 2025-11-07
 * Time: 22:58
 */

class Best{
    int a=1;
    int b=2;
}

class Derived extends Best{
    int c=3;

    public void print(){
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
    }
}

public class Test {
    public static void main(String[] args) {
        Derived derived = new Derived();
        derived.print();
    }
}
