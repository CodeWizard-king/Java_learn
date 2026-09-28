import  java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: wzs
 * Date: 2026-08-10
 * Time: 16:40
 */
public class MyPriorityQueue {
    public int[] elem;
    public int usedSize;

    public MyPriorityQueue(){
        this.elem=new int[10];
    }

    public void initElem(int[] array){
        for (int i = 0; i < elem.length; i++) {
            this.elem[i]=array[i];
            this.usedSize++;
        }
    }

    public void createHeap(){
        for (int parent = (this.usedSize-1-1)/2; parent >=0; parent--) {
            siftDown(parent,this.usedSize);
        }
    }

    /**
     * @param parent 每棵树调整时的起始位置
     * @param usedSize 判断每棵树什么时候调整 结束
    */
    private void siftDown(int parent, int usedSize) {
        int child=parent*2+1;
        while (child<usedSize){
            if (child+1 < usedSize && elem[child]<elem[child+1]){
                child++;
            }
            if (elem[child]>elem[parent]){
                swap(elem,child,parent);
                parent=child;
                child=child*2+1;
            }else{
                break;
            }
        }
    }

    private void swap(int[] elem, int child, int parent) {
        int tmp=elem[child];
        elem[child]=elem[parent];
        elem[parent]=tmp;
    }


    public void offer(int val){
        if (isFull()){
            this.elem=Arrays.copyOf(elem,elem.length*2);
        }
        elem[usedSize]=val;
        siftUp(usedSize);
        usedSize++;
    }

    private void siftUp(int usedSize) {
        int parent=(usedSize-1)/2;
        while (usedSize>=0){
            if (elem[usedSize]>elem[parent]){
                swap(elem,usedSize,parent);
                usedSize=parent;
                parent=(usedSize-1)/2;
            }else {
                return;
            }
        }
    }

    public boolean isFull(){
        return this.usedSize==this.elem.length;
    }
}
