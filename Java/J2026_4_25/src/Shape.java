/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: wzs
 * Date: 2026-04-25
 * Time: 8:52
 */

// 抽象类：被abstract修饰的类
public abstract class Shape {
    // 抽象方法：被abstract修饰的方法，没有方法体
    abstract public void draw();

    abstract void calcArea();

    // 抽象类也是类，也可以增加普通方法和属性
    public double getArea() {
        return area;
    }

    protected double area; // 面积

}
