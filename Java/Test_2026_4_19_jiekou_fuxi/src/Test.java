/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: wzs
 * Date: 2026-04-19
 * Time: 14:59
 */

class MyValue{
    public int val;
}
public class Test {

    public static void swap(MyValue myValue1,MyValue myValue2){
        int temp=myValue1.val;
        myValue1.val=myValue2.val;
        myValue2.val=temp;
    }
    public static void main(String[] args) {
        MyValue myValue1=new MyValue();
        MyValue myValue2=new MyValue();
        myValue1.val=10;
        myValue2.val=20;
        swap(myValue1,myValue2);
        System.out.println(myValue1.val+" "+ myValue2.val);
    }
}
