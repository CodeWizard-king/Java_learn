package Homework;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: wzs
 * Date: 2026-09-13
 * Time: 10:43
 */

// 饿汉模式
class Singleton{
    private static final Singleton instance = new Singleton();

    public static Singleton getInstance(){
        return instance;
    }
    private Singleton(){

    }
}

// 懒汉模式
class SingletonLazy{
    private static SingletonLazy instance;

    public static SingletonLazy getInstance(){
        Object locker = new Object();
        if (instance == null){
            synchronized (locker){
                if (instance == null){
                    instance = new SingletonLazy();
                }
            }
        }
        return instance;
    }

    private SingletonLazy(){

    }
}

public class Demo7 {

}
