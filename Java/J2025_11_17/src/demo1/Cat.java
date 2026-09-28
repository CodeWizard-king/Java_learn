package demo1;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: wzs
 * Date: 2025-11-07
 * Time: 16:23
 */
public class Cat extends Animal{
    static {
        System.out.println("static:: Cat{}");
    }

    {
        System.out.println("实例代码块 Cat{}");
    }


    public Cat(String name, int age) {
        super(name, age);
        System.out.println("Cat····");
    }

    public void mimi(){
        System.out.println(this.name+"咪咪叫");
    }

    /*@Override
    public String toString() {
        return "Cat{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }*/
}
