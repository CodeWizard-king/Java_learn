package demo5;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: wzs
 * Date: 2026-04-19
 * Time: 13:56
 */

class Student implements Comparable<Student>{
    String name;
    int age;

    public Student(String name,int age){
        this.name=name;
        this.age=age;
    }

    @Override
    public String toString() {
        return "student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public int compareTo(Student o) {
        return this.age-o.age;
    }
}
public class Test {
    public static void main(String[] args) {
        Student student1=new Student("张三",5);
        Student student2=new Student("李四",7);
        System.out.println(student1.compareTo(student2));
    }
}
