package IMPLEMENT;
import java.util.ArrayList;

public class Heap {
    ArrayList<Integer> list;
    public Heap()
    {
        list=new ArrayList<>();
    }
    int parent(int index)
    {
        return (index - 1) / 2;
    }
    int left(int index)
    {
        return index*2+1;
    }
    int right(int index)
    {
        return index*2+2;
    }
    void swap(int first ,int second)
    {
        int temp = list.get(first);
        list.set(first, list.get(second));
        list.set(second, temp);
    }
    void insert(int value)
    {
        list.add(value);
         upheap(list.size()-1);
    }
    private void upheap(int index)
    {
        if(index==0)
            return;
        int p=parent(index);
        if(list.get(index)<list.get(p))
        {
            swap(index,p);
            upheap(p);
        }
    }
    int  remove() throws Exception{
        if(list.isEmpty()){
            throw new Exception("NOT VALID");
        }
        int temp=list.get(0);
        if(list.size()!=1) {
            list.set(0, list.remove(list.size() - 1));
            downheap(0);
        }
      else if(list.size()==1)
            list.remove(0);
        return temp;
    }
    private void downheap(int index)
    {
        int min=index;
        int rig=right(index);
        int lef=left(index);
        if(rig < list.size() && list.get(index)>list.get(rig))
            min=rig;
        if(lef < list.size() && list.get(index)>list.get(lef))
            min=lef;
        if(min!=index)
        {
            swap(min,index);
            downheap(min);
        }
    }
    ArrayList<Integer> HeapSort() throws Exception
    {
        ArrayList<Integer> item=new ArrayList<>();
        while(!list.isEmpty())
        {
            item.add(this.remove());
        }
        list=item;
        return item;
    }

}
