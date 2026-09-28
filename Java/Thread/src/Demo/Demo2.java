package Demo;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: wzs
 * Date: 2026-09-12
 * Time: 12:07
 */

class Singleton{
    private static Singleton instance = new Singleton();
    public static Singleton getInstance(){
        return instance;
    }
    private Singleton(){

    }
}

class SingletonLazy {
    // 声明，并用volatile修饰，保证在多线程环境下的有序性
    private volatile static SingletonLazy instance = null;
    // 私有构造方法
    private SingletonLazy () {}
    // 对外提供一个获取实例的方法，
    public static SingletonLazy getInstance() {
        // 使用双重if检查, 降低锁竞争的频率
        if (instance == null) {
            // instance没有被实例化才去加锁
            synchronized (Singleton.class) {
                // 获取到锁后再检查一遍，确认instance没有被实例化后去真正的实例化
                if (instance == null) {
                    instance = new SingletonLazy();
                }
            }
        }
        return instance;
    }
}
public class Demo2 {
    public static void main(String[] args) {
        SingletonLazy t1 = SingletonLazy.getInstance();
        SingletonLazy t2 = SingletonLazy.getInstance();
        System.out.println(t1==t2);
        //Singleton t3 = new Singleton();
    }
}
