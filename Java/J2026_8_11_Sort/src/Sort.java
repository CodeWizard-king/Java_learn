import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: wzs
 * Date: 2026-08-11
 * Time: 17:47
 */
public class Sort {


    /**
     * 直接插入排序
     * 时间复杂度：O(N^2)
     *     最坏情况下：逆序的  5 4 3 2 1
     *     最好情况下：本身就是有序的  1 2 3 4 5 O(n)
     *              如果数据越有序，直接插入排序越快
     * 空间复杂度：O(1)
     * 稳定性：稳定的排序
     *     本身如果是一个稳定的排序，那么可以实现为不稳定的
     *     但是 如果一个排序 本身就是不稳定，能实现为稳定的排序吗？
     * @param array
     */
    public static void insetSort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int tmp = array[i];
            int j = i - 1;
            for (; j >= 0; j--) {
                if (array[j] > tmp) {
                    array[j + 1] = array[j];
                } else {
                    array[j + 1] = tmp;
                    break;
                }
            }
            array[j + 1] = tmp;
        }
    }

    /**
     * 希尔排序
     * 不稳定的
     * 时间复杂度：n^1.3  - n^1.5
     * 空间复杂度：O(1)
     * @param array
     */
    public static void shellSort(int[] array){
        int gap=array.length;
        while (gap>1){
            gap/=2;
            shell(array,gap);
        }
    }

    private static void shell(int[] array, int gap) {
        for (int i = gap; i < array.length; i++) {
            int tmp = array[i];
            int j = i - gap;
            for (; j >= 0; j-=gap) {
                if (array[j] > tmp) {
                    array[j + gap] = array[j];
                } else {
                    array[j + gap] = tmp;
                    break;
                }
            }
            array[j + gap] = tmp;
        }
    }

    /**
     * 选择排序：
     * 时间复杂度：O(N^2)
     *        和数据 是否有序无关
     * 空间复杂度：O(1)
     * 稳定性：不稳定的排序
     * @param array
     */
    public static void selectSort1(int[] array){
        for (int i = 0; i < array.length; i++) {
            int minIndex=i;
            for (int j=i+1; j < array.length; j++) {
                if (array[j]<array[minIndex]){
                    minIndex=i;
                }
            }
            swap(array,i,minIndex);
        }
    }

    public static void selectSort(int[] array){
        int len=array.length-1;

        for (int i = 0; i <= len; i++,len--) {
            int minIndex=i;
            int maxIndex=i;

            for (int j=i+1; j < len; j++) {
                if (array[j]<array[minIndex]){
                    minIndex=j;
                }
                if (array[j]>array[maxIndex]){
                    maxIndex=j;
                }
            }

            swap(array,i,minIndex);
            //最大值正好是 i 下标，此时最大值换到minIndex的位置
            if (maxIndex==i){
                maxIndex=minIndex;
            }
            swap(array,len,maxIndex);
        }
    }
    private static void swap(int[] array, int j, int minIndex) {
        int tmp=array[j];
        array[j]=array[minIndex];
        array[minIndex]=tmp;
    }


    /**
     * 堆排序
     * 时间复杂度：O(n*logN)
     * 空间复杂度：O(1)
     * 稳定性：不稳定
     * @param array
     */
    public static void heapSort(int[] array){
        createHeap(array);
        int end=array.length-1;
        while (end > 0){
            swap(array,0,end);
            siftDown(array,0,end);
            end--;
        }
    }

    private static void createHeap(int[] array){
        for (int parent = (array.length-1-1)/2; parent >= 0 ; parent--) {
            siftDown(array, parent, array.length);
        }
    }

    /**
     *
     * @param array
     * @param parent 每颗子树调整的根节点
     * @param length 每颗子树调整的结束节点
     */

    private static void siftDown(int[] array, int parent, int length) {
        int child = parent * 2 + 1;
        while (child < length){
            if (child+1 < length && array[child]<array[child+1]){
                child++;
            }
            if (array[child] > array[parent]){
                swap(array , child , parent);
                parent = child;
                child = parent * 2 + 1;
            }else {
                break;
            }
        }
    }

    /**
     * 冒泡排序：
     * 时间复杂度：【讨论 没有优化的情况下，也就是 没有下方的boolean元素和-i操作】
     *           O(N^2)
     *           优化以后 可能会达到O(N)
     * 空间复杂度：O(1)
     * 稳定性：稳定的排序
     * @param array
     */
    public static void bubbleSort(int[] array){
        for (int i = 0; i < array.length-1; i++) {
            for (int j = 0; j < array.length-1-i; j++) {
                if (array[j]>array[j+1]){
                    swap(array,j,j+1);
                }
            }
        }
    }

    /**
     * 快速排序
     * 时间复杂度：
     *      *       最坏情况：当数据给定的是1 2 3 4 5 6 7.....有序的情况下 确实是O(n^2)
     *      *                          9 8 7 6 5 4
     *      *       最好情况：O(N*logN)
     *      * 空间复杂度：
     *      *      最坏情况：O(N)
     *      *      最好情况：O(logN)
     *      * 稳定性：
     *      *      不稳定性
     * @param array
     */
    public static void quickSort(int[] array){
        //quickNor(array,0,array.length-1);
        quick(array,0,array.length-1);
    }

    //非递归方式
    private static void quickNor(int[] array, int start, int end) {
        Stack<Integer> stack = new Stack();
        int pivot = partition(array,start,end);
        if (pivot > start + 1){
            stack.push(start);
            stack.push(pivot-1);
        }
        if (pivot < end - 1){
            stack.push(pivot+1);
            stack.push(end);
        }

        while (!stack.isEmpty()){

            end = stack.pop();
            start = stack.pop();

            pivot = partition(array,start,end);
            if (pivot > start + 1){
                stack.push(start);
                stack.push(pivot-1);
            }
            if (pivot < end - 1){
                stack.push(pivot+1);
                stack.push(end);
            }

        }
    }


    /**
     * 快速排序优化
     *  1. 三数取中法选key
     *  2. 递归到小的子区间时，可以考虑使用插入排序
     */
    private static void quick(int[] array, int start, int end) {

        if (start >= end){
            return;
        }
        //元素<=7时，用插入排序
        if (end - start +1 <=7){
            insertSortRange(array,start,end);
            return;
        }

        // 头，中，尾三个元素的中间值放在头
        int midIndex = getMiddleNum(array,start,end);
        swap(array,start,midIndex);

        int pivot = partition(array,start,end);
        quick(array ,start , pivot-1);
        quick(array ,pivot+1 , end);
    }

    private static void insertSortRange(int[] array, int start, int end) {
        for (int i = start+1; i <= end; i++) {
            int tmp = array[i];
            int j = i - 1;
            for (; j >= start; j--) {
                if (array[j] > tmp) {
                    array[j + 1] = array[j];
                } else {
                    array[j + 1] = tmp;
                    break;
                }
            }
            array[j + 1] = tmp;
        }
    }

    private static int getMiddleNum(int[] array, int start, int end) {
        int mid = ( start + end ) / 2;
        if (array[start]<array[end]){
            if (array[start] < array[mid]){
                return mid;
            }else {
                return start;
            }
        }else {
            if (array[end] < array[mid]){
                return mid;
            }else {
                return end;
            }
        }
    }


    // 挖坑法
    private static int partition(int[] array, int left, int right) {
        int pivotVal = array[left]; //保存基准数值
        while (left < right) {
            //右边找小于基准
            while (left < right && array[right] >= pivotVal) {
                right--;
            }
            array[left] = array[right];
            //左边找大于基准
            while (left < right && array[left] <= pivotVal) {
                left++;
            }
            array[right] = array[left];
        }
        array[left] = pivotVal; //基准回填坑
        return left;
    }

    //前后指针
    private static int partition1(int[] array, int left, int right) {
        int tmp=left;
        int cur=left+1;
        while (left < right){
            while (left < right && array[++left] < array[tmp]){
                swap(array,cur,left);
                cur++;
            }
        }
        swap(array,tmp,cur-1);
        return left;
    }

    //Hoare版
    private static int partition2(int[] array, int left, int right) {
        int tmp=left;
        int tmp_LP=left;
        while (left < right){

            while (left < right && array[right] >= array[tmp]){
                right--;
            }

            while (left < right && array[left] <= array[tmp]){
                left++;
            }
            swap(array,left,tmp_LP);
        }
        return left;
    }

    public static void mergeSort(int[] array){
        mergeSortTmp(array,0,array.length-1);
    }

    private static void mergeSortTmp(int[] array, int left, int right) {
        if (left == right){
            return;
        }
        int mid = (left + right) / 2;
        mergeSortTmp(array,left,mid);
        mergeSortTmp(array,mid+1,right);

        merge(array,left,mid,right);
    }

    private static void merge(int[] array, int left, int mid, int right) {

        int[] tmp = new int[(right - left)+1];
        int k = 0;
        int s1 = left;
        int s2 = mid + 1;

        while (s1 <= mid && s2 <= right){
            if (array[s1] <= array[s2]){
                tmp[k++]=array[s1++];
            }else {
                tmp[k++]=array[s2++];
            }
        }

        while (s1 <= mid){
            tmp[k++]=array[s1++];
        }
        while (s2 <= right){
            tmp[k++]=array[s2++];
        }

        for (int i = 0; i < k; i++) {
            array[i+left] = tmp[i];
        }
    }

    /**
     * 非递归实现 归并排序
     * @param array
     */
    public static void mergeSortNor(int[] array){
        int gap = 1;
        while (gap <= array.length){
            for (int i = 0; i < array.length; i = i + gap * 2) {
                int left = i;
                int mid = left + gap - 1;
                if (mid >= array.length){
                    mid = array.length - 1;
                }
                int right = mid + gap;
                if (right >= array.length){
                    right = array.length -1;
                }
                merge(array,left,mid,right);
            }
            gap *= 2;
        }
    }

    // 计数排序
    public static void countSort(int[] array){
        int maxVal = array[0];
        int minVal = array[0];
        for (int i = 0; i < array.length; i++) {
            if (array[i] < minVal){
                minVal = array[i];
            }
            if (array[i] > maxVal){
                maxVal = array[i];
            }
        }
        int len = maxVal - minVal + 1;
        int[] tmp =new int[len];
        for (int i = 0; i < array.length; i++) {
            int index = array[i];
            tmp[index-minVal]++;
        }

        int index = 0;
        for (int i = 0; i < tmp.length; i++) {
            while (tmp[i] != 0) {
                array[index] = i+minVal;
                index++;
                tmp[i]--;
            }
        }
    }
}
