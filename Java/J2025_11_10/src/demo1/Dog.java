package demo1;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: wzs
 * Date: 2025-11-10
 * Time: 19:00
 */
public class Dog extends Animal{

    public Dog(String name,int age){
        super(name,age);
    }

    public void bark(){
        System.out.println(this.name+"正在汪汪叫·····");

    }
    @Override
    public void eat(){
        System.out.println(this.name+"正在吃饭");
    }
}
