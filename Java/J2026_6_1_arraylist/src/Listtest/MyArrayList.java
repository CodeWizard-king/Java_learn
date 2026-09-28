package Listtest;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: wzs
 * Date: 2026-06-01
 * Time: 14:58
 */
public class MyArrayList implements IList{
    int[] array;
    int UsedSize;
    public static final int DEFAULT_CAPACITY = 10;

    public MyArrayList(){
        this.array = new int [DEFAULT_CAPACITY];
        this.UsedSize=0;
    }


    @Override
    // 新增元素,默认在数组最后新增
    public void add(int data) {
        if(isFull()){
            grow();
        }
        this.array[this.UsedSize]=data;
        this.UsedSize++;
    }

    private void grow(){
        //扩容
        this.array= Arrays.copyOf(this.array,
                2*array.length);
    }

    public boolean isFull(){
        //判断是否满了
        return this.UsedSize==this.array.length;
    }

    private void checkPos(int pos)throws PosIllegal{
        //检查是否合法
        if(pos<0||pos>this.UsedSize){
            throw new PosIllegal("Pos位置不合法！");
        }
    }

    @Override
    // 在 pos 位置新增元素
    public void add(int data, int pos) {
        try{
            checkPos(pos);
            if(isFull()){
                grow();
            }

            for(int i=this.UsedSize-1;i>=pos;i--)
                this.array[i+1]=this.array[i];

            this.array[pos]=data;
            this.UsedSize++;

        }catch (PosIllegal e){
            System.out.println("插入元素pos位置不合法....");
            e.printStackTrace();
        }
    }

    @Override
    // 判定是否包含某个元素
    public boolean contains(int toFind) {
        for (int i = 0; i < this.UsedSize; i++) {
            if(this.array[i]==toFind)
                return true;
        }
        return false;
    }

    @Override
    // 查找某个元素对应的位置
    public int indexOf(int toFind) {
        for(int i=0;i<this.UsedSize;i++){
            if(this.array[this.UsedSize]==toFind)
                return i;
        }
        return -1;
    }

    private void checkPos1(int pos)throws EmptyException{
        //检查是否合法
        if(pos<0||pos>=this.UsedSize){
            throw new PosIllegal("Pos位置不合法！");
        }
    }
    @Override
    // 获取 pos 位置的元素
    public int get(int pos) {
        try{
            checkEmpty();
            checkPos1(pos);
            return array[pos];
        }
        catch (PosIllegal e){
            e.printStackTrace();
        }
        catch (EmptyException e){
            e.printStackTrace();
        }
        return -1;
    }


    private void checkEmpty(){
        if(isEmpty()){
            System.out.println("顺序表为空");
        }
    }

    public  boolean isEmpty(){
        if(this.UsedSize==0)
            return  true;
        return false;
    }
    @Override
    // 给 pos 位置的元素设为 value
    public void set(int pos, int value) {
        try{
            checkEmpty();
            checkPos1(pos);
            array[pos]=value;
        }
        catch (PosIllegal e){
            e.printStackTrace();
        }
        catch (EmptyException e){
            e.printStackTrace();
        }
    }

    @Override
    //删除第一次出现的关键字key
    public void remove(int toRemove) {
        try{
            checkEmpty();
            int pos =indexOf(toRemove);
            if(pos==-1)
                return ;
            for(int i=pos;i<this.UsedSize-1;i++)
                array[i]=array[i+1];
        }catch (EmptyException e){
            e.printStackTrace();
        }

    }

    @Override
    //获取顺序表长度
    public int size() {
        return this.UsedSize;
    }

    @Override
    //清空顺序表
    public void clear() {
        this.UsedSize=0;
    }

    @Override
    //打印顺序表
    public void display() {
        for (int i = 0; i < this.UsedSize; i++) {
            System.out.print(this.array[i]+" ");
        }
    }
}
