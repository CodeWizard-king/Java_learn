package demo4;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: wzs
 * Date: 2026-04-19
 * Time: 13:51
 */

class Student implements Comparable<Student>{
    public String name;
    public int age;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public int compareTo(Student o) {
        /*if(this.age > o.age) {
            return 1;
        }else if(this.age == o.age) {
            return 0;
        }else {
            return -1;
        }*/
        //return o.age - this.age;
        return  this.age - o.age;
        //return this.name.compareTo(o.name);
    }
}

public class Test {
    public static void main(String[] args) {

        Student student1 = new Student("zhangsan",10);
        Student student2 = new Student("lisi",19);

        //System.out.println(student1 < student2);
        System.out.println(student1.compareTo(student2));

    }
}
