package demo1;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: wzs
 * Date: 2026-04-18
 * Time: 16:32
 */
public class Dog extends Animal{

//    public Dog(String name, int age) {
//        this.name = name;
//        this.age = age;
//    }


//    @Override
//    public String toString() {
//        return "Dog{" +
//                "name='" + name + '\'' +
//                ", age=" + age +
//                '}';
//    }

    public void eat(){
        System.out.println(this.name+"正在吃放！！！");
    }
    public void bark(){
        System.out.println(this.name+"正在汪汪叫...");
    }
}
