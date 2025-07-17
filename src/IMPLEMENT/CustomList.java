package IMPLEMENT;

import java.util.Arrays;

public class CustomList<T>{
    private Object[] data;
    private int size=0;
    private int DEAFAULT_SIZE=10;

    public CustomList()
    {
        data=new Object[DEAFAULT_SIZE];
    }
    //ADD ELEMENT WHEN GETS FULL IT AUTOMATICALLY RESIZES
    public void add(T num)
    {
        if(isFull())
        {
            resize();
        }
        data[size++]=num;
    }
    //SET ELEMENT WHEN GETS FULL IT AUTOMATICALLY RESIZES
    public void set(int index,T num)
    {
        if(isFull())
        {
            resize();
        }
        data[index]=num;
    }
    private void resize()
    {
        Object[] temp=new Object[data.length*2];
        for(int i=0;i<data.length;i++)
        {
            temp[i]=data[i];
        }
        data=temp;
    }
    public int size()
    {
        return size;
    }
    private boolean isFull()
    {
        return (size==data.length);
    }
    //REMOVE DATA WITH GIVEN INDEX
    public void remove(int index)
    {
        for(int i=index;i<data.length-1;i++) {
            data[i] = data[i + 1];
        }
    }

    public String toString() {
        return "List{" + Arrays.toString(data) + '}';
    }

    public T get(int index){
    return (T)data[index];
    }

}
