package demo2;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: wzs
 * Date: 2026-04-19
 * Time: 10:32
 */
public class Mouse implements USB{

    @Override
    public void openDevice() {
        System.out.println("打开鼠标");
    }

    @Override
    public void closeDevice() {
        System.out.println("关闭鼠标");
    }

    public void Click(){
        System.out.println("点击鼠标");
    }
}
