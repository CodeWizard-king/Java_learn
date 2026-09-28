package demo1;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: wzs
 * Date: 2025-11-10
 * Time: 19:00
 */
public class Test {

    public static void func(Animal animal){
        animal.eat();
    }
    public static void main(String[] args) {
        Dog dog=new Dog("旺财",2);
        func(dog);
    }

    public static void main1(String[] args) {
        Animal animal=new Dog("旺财",2);
        animal.eat();
    }
}
