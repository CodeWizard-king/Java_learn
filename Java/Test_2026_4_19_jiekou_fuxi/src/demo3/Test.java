package demo3;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: wzs
 * Date: 2026-04-19
 * Time: 11:51
 */
public class Test {
    public static void func1(Animal animal){
        animal.eat();
    }
    public static void swim(ISwimming iSwimming){
        iSwimming.swim();
    }
    public static void fly(IFly ifly){
        ifly.fly();
    }
    public static void run(IRunning iRunning){
        iRunning.run();
    }

    public static void main(String[] args) {
        swim(new Dog("旺财",1));
        func1(new Duck("唐老鸭",3));
        func1(new Fish("金鱼",2));
    }

    public static void main1(String[] args) {
        func1(new Dog("旺财",1));
        func1(new Duck("唐老鸭",3));
        func1(new Fish("金鱼",2));
    }
}
