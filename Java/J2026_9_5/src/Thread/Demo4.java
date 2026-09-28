package Thread;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: wzs
 * Date: 2026-09-05
 * Time: 15:46
 */
public class Demo4 {
    public static void main(String[] args) {
        Runnable runnable = new Runnable(){
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

        Thread t = new Thread(runnable);
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
