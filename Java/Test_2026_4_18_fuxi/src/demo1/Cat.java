package demo1;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: wzs
 * Date: 2026-04-18
 * Time: 16:33
 */
public class Cat extends Animal{


//    public Cat(String name, int age) {
//        this.name = name;
//        this.age = age;
//    }


//    @Override
//    public String toString() {
//        return "Cat{" +
//                "name='" + name + '\'' +
//                ", age=" + age +
//                '}';
//    }

    public void eat(){
        System.out.println(this.name +"正在吃饭");
    }

    public void mimi(){
        System.out.println(this.name+"正在咪咪叫...");
    }
}
