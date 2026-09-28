package demo1;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: wzs
 * Date: 2025-10-12
 * Time: 15:10
 */
public class Animal {
    public String name;
    public int age;

   /* public String getName() {
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
    }*/

    public void eat(){
        System.out.println(this.name+"正在吃饭....");
    }

    /*@Override
    public String toString() {
        return "Animal{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }*/
}
