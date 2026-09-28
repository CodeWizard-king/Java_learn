import java.util.HashSet;
import java.util.Objects;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: wzs
 * Date: 2026-08-16
 * Time: 21:38
 */

class Person{
    public String id;

    public Person(String id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(id, person.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}


public class Test {

    public static void main(String[] args) {
        String str1 = "hello";
        String str2 = "hello";
        System.out.println(str1 == str2); //比的是地址还是值？

        String str3 = new String("world");
        String str4 = new String("world");

        System.out.println(str3 == str4);
    }

    public static void main3(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextInt()) { // 注意 while 处理多个 case
            String a = in.next();
            String b = in.next();
            fun(a,b);
        }
    }

    private static void fun(String str1, String str2) {
        str1 = str1.toUpperCase();//输入的
        str2 = str2.toUpperCase();//验证的
        HashSet<Character> hashSet = new HashSet<>();
        for (int i = 0; i < str2.length(); i++) {
            char ch = str2.charAt(i);
            hashSet.add(ch);
        }
        HashSet<Character> hashSetBuck = new HashSet<>();
        for (int i = 0; i < str1.length(); i++) {
            char ch = str1.charAt(i);
            if (!hashSet.contains(ch)){
                if (!hashSetBuck.contains(ch)){
                    System.out.println(ch);
                }
                hashSetBuck.add(ch);
            }
        }
    }

    public int singleNumber(int[] nums) {
        HashSet<Integer> hashset = new HashSet<>();
        for(int i = 0;i < nums.length; i++){
            if (hashset.contains(nums[i])){
                hashset.remove(nums[i]);
            }else {
                hashset.add(nums[i]);
            }
        }
        for(int i = 0;i < nums.length; i++){
            if (hashset.contains(nums[i])){
                return nums[i];
            }
        }
        return -1;
    }
    public static void main2(String[] args) {
        Person person1 = new Person("1234");
        Person person2 = new Person("1234");

        /*System.out.println(person1.hashCode());
        System.out.println(person2.hashCode());

        System.out.println(person1.equals(person2));*/
        HashBuck2<Person,String> hashBuck2 = new HashBuck2<>();
        hashBuck2.push(person1,"xiaoming");

        System.out.println(hashBuck2.getVal(person2));
    }

    public static void main1(String[] args) {
        HashBuck hashBuck = new HashBuck();
        hashBuck.push(14,99);
        hashBuck.push(4,99);

    }
}
