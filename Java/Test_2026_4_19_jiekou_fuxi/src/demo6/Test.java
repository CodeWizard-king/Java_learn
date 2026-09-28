package demo6;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: wzs
 * Date: 2026-04-19
 * Time: 15:15
 */
public class Test {
    public static void main(String[] args)
            throws CloneNotSupportedException   {
        Person person1 = new Person("zhangsan",10);
        Person person2 = (Person)person1.clone();

        System.out.println("修改前："+person1.m.money);
        System.out.println("修改前："+person2.m.money);

        person2.m.money = 99.99;

        System.out.println("修改后："+person1.m.money);
        System.out.println("修改后："+person2.m.money);
    }
}
