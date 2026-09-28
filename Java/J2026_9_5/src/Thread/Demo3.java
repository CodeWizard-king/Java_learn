package Thread;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: wzs
 * Date: 2026-09-05
 * Time: 15:40
 */

//匿名内部类
public class Demo3 {
    public static void main(String[] args) {
        Thread t = new Thread(){
            @Override
            public void run() {
                while (true){
                    System.out.println("hello Thread");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        };

        t.start();

        while (true){
            System.out.println("hello main");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
