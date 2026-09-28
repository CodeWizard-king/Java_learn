package demo2;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: wzs
 * Date: 2026-04-19
 * Time: 9:34
 */
public class Test {
    public static void main(String[] args) {
        Cycle cycle=new Cycle();
        Flower flower=new Flower();
        Shape[] shapes={cycle,cycle,flower,flower};
        for (Shape shape:shapes) {
            shape.draw();
        }
    }
}
