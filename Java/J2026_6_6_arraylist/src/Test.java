import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: wzs
 * Date: 2026-06-06
 * Time: 14:42
 */
public class Test {

    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> arrayList=new ArrayList<>();
        List<Integer> last0=new ArrayList<>();
        last0.add(1);
        arrayList.add(last0);

        for (int i = 1 ; i < numRows; i++) {
            List<Integer> curRow=new ArrayList<>();
            //头
            curRow.add(1);
            //中间
            List<Integer> perRow=arrayList.get(i-1);
            for (int j = 1; j < i; j++) {
                int val1=perRow.get(j);
                int val2=perRow.get(j-1);
                curRow.add(val1+val2);
            }
            //尾
            curRow.add(1);
            arrayList.add(curRow);
        }
        return arrayList;
    }

    public static void main(String[] args) {
        List<List<Integer>> ret=generate(4);
        for (int i = 0; i < ret.size(); i++) {
            for (int j = 0; j < ret.get(i).size(); j++) {
                System.out.print(ret.get(i).get(j)+" ");
            }
        }
        System.out.println();
    }

    public static void main4(String[] args) {
        String str1="welcome to bit";
        String str2="come";
        ArrayList<Character> arrayList=new ArrayList<>(10);

        for(int i=0; i<str1.length();i++){
            char ch=str1.charAt(i);
            if(!str2.contains(ch+"")){
                arrayList.add(ch);
            }
        }

        for (int i = 0; i < arrayList.size(); i++) {
            System.out.print(arrayList.get(i));
        }
        System.out.println();
    }


    public static void main3(String[] args) {
        ArrayList<Integer> arrayList=new ArrayList<>(10);
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);
        arrayList.add(4);
        arrayList.add(5);

        ListIterator<Integer> listIterator =arrayList.listIterator(arrayList.size());
        while(listIterator.hasPrevious()){
            System.out.print(listIterator.previous()+" ");
        }
        System.out.println();

        //迭代器方法
        Iterator<Integer> iterator = arrayList.iterator();
        while (iterator.hasNext()){
            System.out.print(iterator.next()+" ");
        }
        System.out.println();

        System.out.println(arrayList);
        //for i方法
        int size= arrayList.size();
        for (int i = 0; i < size; i++) {
            System.out.print(arrayList.get(i)+" ");
        }
        System.out.println();

        //for each 方法
        for (Integer e:arrayList) {
            System.out.print(e+" ");
        }
        System.out.println();
    }

    public static void main2(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<>(10);
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);
        arrayList.add(4);
        arrayList.add(5);

        List<Integer> list = arrayList.subList(1,3);
        list.set(0,99);
        System.out.println(list);
        System.out.println(arrayList);
    }

    public static void main1(String[] args) {
        ArrayList<Integer> arrayList=new ArrayList(10);
        List<Integer> List=new ArrayList<>();

        List.add(5);
        List.add(6);
        List.add(7);
        List.add(8);

        arrayList.add(1);
        arrayList.add(99);
        arrayList.add(2);
        arrayList.add(3);
        arrayList.add(4);

        arrayList.addAll(List);
        arrayList.remove(2);
        arrayList.remove(new Integer(99));
        System.out.println(arrayList);
    }
}
