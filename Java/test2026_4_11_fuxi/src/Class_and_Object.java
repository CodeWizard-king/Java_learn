import com.baidu.www.TestDome;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: wzs
 * Date: 2026-04-13
 * Time: 10:38
 */

class Student{
    public String name;//姓名
    public int age;//年龄
    public String stuNum;//学号

    public Student(){
        System.out.println("不带参数构造方法...");
    }

    public Student(String name,int age,String stuNum){
        this();
        this.eat();
        this.doClass();
        System.out.println("带参数的构造方法...");
    }
    public void eat(){
        System.out.println(name+"要吃饭");
    }
    public void doClass(){
        System.out.println(name+"正在上课");
    }
}

public class Class_and_Object {

    public static void main(String[] args) {
        TestDome testdome=new TestDome();
        testdome.Test();
    }

    public static void main1(String[] args) {
        Student student1=new Student("王五",2,"0001");
        student1.name="张三";
        student1.eat();
        student1.doClass();
        System.out.println("========");
        Student student2=new Student();
        student2.name="李四";
        student2.eat();
        student2.doClass();
    }
}
