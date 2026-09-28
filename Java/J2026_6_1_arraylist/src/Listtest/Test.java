package Listtest;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: wzs
 * Date: 2026-06-01
 * Time: 14:56
 */
public class Test {

    public static void main(String[] args) {
        MyArrayList myArrayList=new MyArrayList();
        myArrayList.add(1);
        myArrayList.add(2);
        myArrayList.add(3);
        myArrayList.add(4);
        myArrayList.add(5);

        System.out.println(myArrayList.get(1));
        myArrayList.add(2,3);
        myArrayList.add(2,2);
        myArrayList.add(2,9999);
        myArrayList.display();
    }

    public static void main1(String[] args) {
        MyArrayList myArrayList=new MyArrayList();
        IList iList=new MyArrayList();

        System.out.println(myArrayList.size());
        System.out.println(iList.size());

        myArrayList.display();
        iList.display();

    }
}
