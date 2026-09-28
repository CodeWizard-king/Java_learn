import com.baidu.www.TestDome;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: wzs
 * Date: 2025-10-09
 * Time: 16:25
 */

class Student{
    private String name;
    private int age;
    private String stuNum;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getStuNum() {
        return stuNum;
    }

    public void setStuNum(String stuNum) {
        this.stuNum = stuNum;
    }

    public Student(){
        System.out.println("不带参数构造方法！");
    }

    public Student(String name, int age, String stuNum) {
        this.name = name;
        this.age = age;
        this.stuNum = stuNum;
        System.out.println("带3个参数的构造方法！");
    }

    public void eat(){
        System.out.println(this.name+"正在吃饭！");
    }

    public void doClass(){
        System.out.println(this.name+"正在上课！");
    }
}

public class Test {

    public static void main4(String[] args) {
        TestDome t=new TestDome();
        t.test();
    }






    public static void main3(String[] args) {
        int[] array={1,2,3,4};
        System.out.println(Arrays.toString(array));
    }
    public static void main2(String[] args) {
        Student student=new Student();
        student.setName("zhangsan");
        System.out.println(student.getName());
        student.setAge(10);
        System.out.println(student.getAge());
        student.setStuNum("12345678");
        System.out.println(student.getStuNum());
    }

   /*public static void main1(String[] args) {
        Student student=new Student();
        student.name="zhangsan";
        student.age=18;
        student.stuNum="00000001";

        System.out.println(student.name);
        System.out.println(student.age);
        System.out.println(student.stuNum);

        Student student1=new Student();
        student1.name="lisi";
        student1.age=18;
        student1.stuNum="00000002";

        System.out.println(student1.name);
        System.out.println(student1.age);
        System.out.println(student1.stuNum);
    }*/
}
