import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: wzs
 * Date: 2025-09-27
 * Time: 17:21
 */
public class ff {


    public static void main5(String[] args) {
        int[][] arr=new int[][]{{1,2,3},{4,5,6}};
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println("=======");
        System.out.println(Arrays.deepToString(arr));
    }
    // 冒泡排序
    public  static  void  bubbleSort(int[] array){
        for (int i = 0; i < array.length-1; i++) {
            for (int j = 0; j < array.length-1-i; j++) {
                if(array[j]>array[j+1]){
                    int t=array[j];
                    array[j]=array[j+1];
                    array[j+1]=t;
                }
            }
        }
    }
    public static void main4(String[] args) {
        int[] array={4,7,3,8,2,6,1,9,0,5};
        bubbleSort(array);
        System.out.println(Arrays.toString(array));
    }






    //二分查找
    public  static  int  binarySearch(int[] array,int num){
        int left=0;
        int right= array.length-1;
        while(left<=right){
            int mid=(left+right)/2;
            if(num==array[mid]){
                return mid;
            }else if(num<array[mid]){
                left=mid-1;
            }else{
                right=mid-1;
            }
        }
        return -1;
    }
    public static void main3(String[] args) {
        int[] array={1,2,3,4,5};
        System.out.println(binarySearch(array,3));
    }



    public static void main2(String[] args) {
        int[] array=new int[]{1,2,3,4,5,6};
    }




    // 实现一个方法 transform, 以数组为参数,
    // 循环将数组中的每个元素 乘以 2 ,
    // 并设置到对应的数组元素上.
    // 例如 原数组为 {1, 2, 3}, 修改之后为 {2, 4, 6}

    public static void transform(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            arr[i]=arr[i]*2;
        }
    }

    public static void main1(String[] args) {
        int[] arr=new int[]{1,2,3};
        transform(arr);
        System.out.println(Arrays.toString(arr));
    }
}
