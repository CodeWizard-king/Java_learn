package demo1;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: wzs
 * Date: 2025-11-07
 * Time: 16:25
 */
public class Animal {
    public String name;
    public int age;
    static {
        System.out.println("static:: Animal{}");
    }


    {
        System.out.println("实例代码块{}");
    }

    public Animal(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void eat(){
        System.out.println(this.name+"正在吃饭");
    }

    /*@Override
    public String toString() {
        return "Cat{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }*/

}
