
/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: wzs
 * Date: 2026-04-26
 * Time: 9:32
 */
class Alg<E extends Comparable<E>>{
    public E findMax(E[] arr){
        E max=arr[0];
        for (int i = 0; i < arr.length; i++) {
            if(arr[i].compareTo(max)>0){
                max=arr[i];
            }
        }
        return max;
    }
}

class Alg1{
    public <E extends Comparable<E>> E findMax(E[] arr){
        E max=arr[0];
        for (int i = 0; i < arr.length; i++) {
            if(arr[i].compareTo(max)>0){
                max=arr[i];
            }
        }
        return max;
    }
}
public class TestGeneric {

    public static void main(String[] args) {
        Alg1 alg1=new Alg1();
        Integer[] arr={0,1,2,3,4,5,6,7,8,9};
        System.out.println(alg1.findMax(arr));
    }

    public static void main1(String[] args) {
        Alg<Integer> alg=new Alg<>();
        Integer[] arr={0,1,2,3,4,5,6,7,8,9};
        int max=alg.findMax(arr);
        System.out.println(max);
    }
}
