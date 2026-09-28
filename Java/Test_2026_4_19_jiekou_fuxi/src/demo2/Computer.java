package demo2;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: wzs
 * Date: 2026-04-19
 * Time: 10:36
 */
public class Computer {
    public void Power(){
        System.out.println("开机");
    }

    public void close(){
        System.out.println("关机");
    }

    public void useDevice(USB usb){
        usb.openDevice();
        if (usb instanceof Mouse){
            Mouse mouse=(Mouse) usb;
            mouse.Click();
        }else{
            Keyboard keyboard=(Keyboard) usb;
            keyboard.input();
        }
        usb.closeDevice();
    }
}
