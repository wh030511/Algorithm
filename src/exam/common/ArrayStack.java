package exam.exam.common;

/**
 * @author WuHao
 * @create 2020-03-24-17:34
 */
public class ArrayStack {
    private int[] arr;
    private int top;
    private int size;

    public ArrayStack(int maxmium){
        this.size = maxmium;
        this.arr = new int[size];
        this.top = -1;
    }

    public void push(int num){ // 入栈
        if(isFull()){
            System.out.println("栈已满！");
            return ;
        }
        arr[++top] = num;
    }

    public int pop(){
        if (isEmpty()){
            System.out.println("栈已空！");
            return 0;
        }
        return arr[top--];
    }

    public boolean isFull(){
        return top == size-1;
    }
    public boolean isEmpty(){
        return top == -1;
    }
}
