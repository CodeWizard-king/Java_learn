package demo1;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: wzs
 * Date: 2026-04-19
 * Time: 9:59
 */
public class Test {
    public static void eat(Shape shape){
        shape.draw();
    }
    public static void main(String[] args) {
        eat(new Cycle());
        eat(new Rect());
    }
}
