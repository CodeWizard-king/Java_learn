/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: wzs
 * Date: 2025-10-11
 * Time: 8:50
 */

class Student{
    private String name;
    private int age;
    private double score;

    private static String ClassName="211";

    // 当类加载的时候 就会触发
    static{
        // 定义在类的当中 方法的外边 一边用来初始化静态成员变量
        ClassName="114";
        System.out.println("静态代码块中 一般用来初始化静态成员变量");
    }

    {
        this.name="tangsan";
        System.out.println("实例代码块·······");
    }

    public Student(String name,int age,double score){
        this.name=name;
        this.age=age;
        this.score=score;
        System.out.println("构造方法执行······");
    }
    public  Student(){
        ;
    }


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

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public void doClass(){
        System.out.println(this.name+"正在上课");
    }

    public void show(){
        System.out.println("name: "+this.name+"     age: "+this.age+"   score: "+this.score+" "+ClassName);
    }

    /*
      静态成员-> 类方法 -> 不依赖对象
    */
    public static String getClassName(){
        /*Student student=new Student("zhangsan",10,50);
        student.show();*/
        return ClassName;
    }
}
public class Test {

    public static void main(String[] args) {
        Student student1=new Student();
        System.out.println("============");
        Student student2=new Student();
    }

    public static void main3(String[] args) {
        Student student1=new Student("zhangsan",10,50);
        //System.out.println(Student.getClassName());
    }
    public int add(int a,int b){
        return a+b;
    }
    public static void main2(String[] args) {
        Test test=new Test();
        System.out.println(test.add(1, 2));


       /* Student student1=new Student("zhangsan",10,50);
        student1.show();
        System.out.println(Student.getClassName());*/
        // System.out.println(student1.getClassName());
    }
    public static void main1(String[] args) {
        Student student1=new Student("zhangsan",10,50);
        student1.show();

        Student student2=new Student("lisi",11,88.8);
        student2.show();

        Student student3=new Student("wangwu",15,66.6);
        student3.show();

        Student student4=new Student();
        student4.setName("li");
        System.out.println(student4.getName());
    }
}
