package demo1;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: wzs
 * Date: 2025-11-07
 * Time: 16:24
 */
public class Dog extends Animal{

    static {
        System.out.println("static:: Dog{}");
    }

    {
        System.out.println("实例代码块 Dog{}");
    }
    public Dog(String name, int age) {
        super(name,age);
        System.out.println("Dog····");
    }

    public void bark(){
        System.out.println(this.name+"汪汪叫");
    }

    /*@Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }*/
}
