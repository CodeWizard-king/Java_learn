package demo6;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: wzs
 * Date: 2026-04-19
 * Time: 15:15
 */

class Money implements Cloneable{
    public double money=9.9;

    @Override
    protected Object clone()
            throws CloneNotSupportedException {
        return super.clone();
    }
}
public class Person implements Cloneable{
    public String name;
    public int age;

    public Money m=new Money();

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    protected Object clone()
            throws CloneNotSupportedException {
        //return super.clone(); // 重写
        Person tmp=(Person) super.clone();
        tmp.m=(Money) this.m.clone();
        return tmp;
    }
}
