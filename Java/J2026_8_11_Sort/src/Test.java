import java.util.Arrays;
import java.util.Random;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: wzs
 * Date: 2026-08-11
 * Time: 17:46
 */
public class Test {

    // 生成有序/无序数组
    public static void orderArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            //array[i] = i;
            array[i] = array.length-1-i;
        }
    }

    // 生成随机数组
    public static void notOrderArray(int[] array) {
        Random random = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(10_0000) ;
        }
    }

    // 测试排序方法的耗时
    public static void testInsert(int[] array) {
        array = Arrays.copyOf(array,array.length);
        long startTime = System.currentTimeMillis();
        Sort.insetSort(array);
        long endTime = System.currentTimeMillis();
        System.out.println("直接插入排序耗时："+(endTime-startTime));
    }

    public static void testShellSort(int[] array) {
        array = Arrays.copyOf(array,array.length);
        long startTime = System.currentTimeMillis();
        Sort.shellSort (array);
        long endTime = System.currentTimeMillis();
        System.out.println("希尔排序耗时："+(endTime-startTime));
    }

    public static void testSelectSort(int[] array) {
        array = Arrays.copyOf(array,array.length);
        long startTime = System.currentTimeMillis();
        Sort.selectSort (array);
        long endTime = System.currentTimeMillis();
        System.out.println("选择排序耗时："+(endTime-startTime));
    }

    public static void testHeapSort(int[] array) {
        array = Arrays.copyOf(array,array.length);
        long startTime = System.currentTimeMillis();
        Sort.selectSort (array);
        long endTime = System.currentTimeMillis();
        System.out.println("堆排序耗时："+(endTime-startTime));
    }

    public static void testBubbleSort(int[] array) {
        array = Arrays.copyOf(array,array.length);
        long startTime = System.currentTimeMillis();
        Sort.selectSort (array);
        long endTime = System.currentTimeMillis();
        System.out.println("冒泡排序耗时："+(endTime-startTime));
    }

    public static void testQuickSort(int[] array) {
        array = Arrays.copyOf(array,array.length);
        long startTime = System.currentTimeMillis();
        Sort.quickSort (array);
        long endTime = System.currentTimeMillis();
        System.out.println("快速排序耗时："+(endTime-startTime));
    }

    /**
     * 测试简单的数据能否执行，测试算法是否正确
     */
    public static void testSimple() {
        int[] array = {10,6,7,1,3,9,4,2};
        System.out.println("排序前："+Arrays.toString(array));
        Sort.countSort(array);
        System.out.println("排序后："+Arrays.toString(array));
    }

    public static void main(String[] args) {
        testSimple();
       // testOther();
    }

    public static void testOther() {
        int[] array = new int[10_0000];
        notOrderArray(array);
        //orderArray(array);
        //testInsert(array);
        //testSelectSort(array);
        //testSelectSort(array);

    }
}
