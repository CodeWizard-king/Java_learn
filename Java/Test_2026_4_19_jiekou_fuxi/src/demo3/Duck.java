package demo3;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: wzs
 * Date: 2026-04-19
 * Time: 11:42
 */
public class Duck extends Animal implements IFly,IRunning,ISwimming{

    public Duck(String name,int age){
        super(name, age);
    }

    @Override
    public void eat() {
        System.out.println(this.name+"正在吃饭");
    }

    @Override
    public void fly() {
        System.out.println(this.name+"在飞");
    }

    @Override
    public void run() {
        System.out.println(this.name+"在跑");
    }

    @Override
    public void swim() {
        System.out.println(this.name+"在游泳");
    }
}
