package demo2;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: wzs
 * Date: 2026-04-19
 * Time: 10:48
 */
public class Test {
    public static void main(String[] args) {
        Computer computer=new Computer();
        computer.Power();
        computer.useDevice(new Mouse());
        computer.useDevice(new Keyboard());
        computer. close();
    }
}
