package Thread;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: wzs
 * Date: 2026-09-05
 * Time: 17:10
 */
public class Demo8 {
    public static void main(String[] args) {
        Thread t = new Thread(() ->{
            for (int i = 0; i < 3; i++){
                System.out.println("hello Thread");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        t.start();

        while (true){
            System.out.println(t.isAlive());
            System.out.println("hello main");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
