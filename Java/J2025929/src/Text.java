/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: wzs
 * Date: 2025-09-29
 * Time: 19:17
 */

class Dog{
    public String name;// 名字
    public String color;// 毛发颜色

    public void bark(){
        System.out.println(name+"汪汪叫~");
    }

    public void wag(){
        System.out.println(name+"摇尾巴~");
    }
}
public class Text {

    public static void main(String[] args) {
        Dog dog=new Dog();//通过 new()来实现实例化
        dog.name = "阿黄";
        dog.color = "黑黄";
        dog.bark();
        dog.wag();
        Dog dogs = new Dog();
        dogs.name = "阿黄";
        dogs.color = "黑黄";
        dogs.bark();
        dogs.wag();
    }

}
