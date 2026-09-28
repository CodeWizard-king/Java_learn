package demo1;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: wzs
 * Date: 2025-10-12
 * Time: 15:09
 */
public class Dog extends Animal{
    public void bark(){
        System.out.println(this.name+"正在汪汪叫.....");
    }

   /* @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }*/
}
