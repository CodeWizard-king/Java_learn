package demo3;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: wzs
 * Date: 2026-04-19
 * Time: 11:49
 */
public class Fish extends Animal implements ISwimming{
    public Fish(String name,int age){
        super(name, age);
    }
    @Override
    public void swim() {
        System.out.println(this.name+"在游泳");
    }

    @Override
    public void eat() {
        System.out.println(this.name+"正在吃饭");
    }
}