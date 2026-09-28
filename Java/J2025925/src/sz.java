/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: wzs
 * Date: 2025-09-25
 * Time: 11:06
 */
public class sz {
    public static void main(String[] args) {
        //int []arr= new int[5];
        //arr=new int[]{1,2,3,4,5};

        int []arr=new int[]{1,2,3,4,5,6};
        // 在数组中可以通过 数组对象.length 来获取数组的长度
        for (int n=0;n< arr.length;n++){
            System.out.println(arr[n]);
        }

        System.out.println();

        // for-each 是 for 循环的另外一种使用方式. 能够更方便的完成对数组的遍历. 可以避免循环条件和更新语句写错.
        for (int x:arr) {
            System.out.println(x);
        }

    }
}
