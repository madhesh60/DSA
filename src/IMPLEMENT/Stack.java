package IMPLEMENT;

public class Stack {
    int size;
    int[] arr;
    int top=-1;
    Stack(int size)
    {
        this.size=size;
        arr=new int[size];
    }
    void push(int value)
    {
        if(isFull())
            System.out.println("STACK IS FULL GO-BACKKKKK");
        top++;
        arr[top]=value;
    }
    int  pop()
    {
        if(isEmpty())
            System.out.println("STACK IS EMPTY GO-BACKKKKK");
        int ans= arr[top];
        int range=top;
        top=-1;
        for(int i=0;i<range;i++)
        {
            top++;
            arr[top]=arr[i];
        }

        return ans;
    }
    int  peek()
    {
        if(isEmpty())
            System.out.println("STACK IS EMPTY GO-BACKKKKK");
        return arr[top];
    }
    boolean isFull() {
        return top == size - 1;
    }
    boolean isEmpty() {
        return top == -1;
    }
    void display()
    {
        for(int i=0;i<=top;i++)
            System.out.print(arr[i]+" ");
    }



}
