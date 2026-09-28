package demo3;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: wzs
 * Date: 2026-04-19
 * Time: 11:29
 */
public class Dog extends Animal implements IRunning,ISwimming{

    public Dog(String name, int age) {
        super(name, age);
    }

    @Override
    public void eat() {
        System.out.println(this.name+"正在吃饭");
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
