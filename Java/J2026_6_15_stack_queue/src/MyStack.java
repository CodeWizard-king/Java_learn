import java.util.Arrays;
import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: wzs
 * Date: 2026-06-15
 * Time: 12:08
 */
public class MyStack {
    public int[] elem;
    public int usedSize;

    public MyStack(){
        this.elem=new int[10];
        usedSize=0;
    }

    public void push(int val){
        if(isFull()){
            this.elem= Arrays.copyOf(elem,2*elem.length);
        }
        elem[usedSize++]=val;
    }

    public boolean isFull(){
        return this.usedSize==elem.length;
    }

    public int pop(){
        if(isEmpty()){
            throw new EmptyStackException();
        }
        int val=elem[usedSize-1];
        usedSize--;
        return val;
    }

    public int peek(){
        if(isEmpty()){
            throw new EmptyStackException();
        }
        return elem[usedSize-1];
    }

    public boolean isEmpty(){
        return usedSize==0;
    }

    public int evalRPN(String[] tokens) {
        Stack<Integer> stack=new Stack<>();
        for (String str: tokens) {
            if(!ifOperator(str)){
                int x=Integer.parseInt(str);
                stack.push(x);
            }else{
                int val2=stack.pop();
                int val1=stack.pop();
                switch (str){
                    case "+": stack.push(val1+val2);
                        break;
                    case "-":stack.push(val1-val2);
                        break;
                    case "*":stack.push(val1*val2);
                        break;
                    case "/":stack.push(val1/val2);
                        break;
                }
            }
        }
        return stack.pop();
    }
    public boolean ifOperator(String str){
        if(str.equals("+")||str.equals("-")||str.equals("*")||str.equals("/")){
            return true;
        }
        return false;
    }


    public boolean IsPopOrder (int[] pushV, int[] popV) {
        Stack<Integer> stack=new Stack<>();
        int j=0;
        for (int i = 0; i < pushV.length; i++) {
            stack.push(pushV[i]);
            while (stack.peek()==popV[j]){
                stack.pop();
                j++;
            }
        }
        if(stack.isEmpty()&&j==popV.length){
            return true;
        }
        return false;
    }
}
