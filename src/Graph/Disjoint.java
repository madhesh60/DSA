package Graph;
import java.util.*;

class Disjoint{
    ArrayList<Integer> parent=new ArrayList<>();
    ArrayList<Integer> rank=new ArrayList<>();
    ArrayList<Integer> size=new ArrayList<>();

    Disjoint(int n){
        for(int i=0;i<n;i++){
            parent.add(i);
            rank.add(0);
            size.add(1);
        }
    }

    void UnionByRank(int x,int y){
        int ulp=findU(x);
        int ulp1=findU(y);

        if(ulp == ulp1){
            return;
        }
        if(rank.get(ulp) < rank.get(ulp1)){
            parent.set(ulp,ulp1);
        }
        else if(rank.get(ulp) >rank.get(ulp1)){
            parent.set(ulp1,ulp);
        }
        else{
            parent.set(ulp1,ulp);
            int rankU=rank.get(ulp);
            rank.set(ulp, rankU + 1);

    }
    }
    void UnionBySize(int x,int y){
        int ulp=findU(x);
        int ulp1=findU(y);

        if(ulp == ulp1){
            return;
        }
        if(size.get(ulp) < size.get(ulp1)){
           parent.set(ulp,ulp1);
        }
        else if(size.get(ulp) >size.get(ulp1)){
            parent.set(ulp1,ulp);
        }
        else{
            parent.set(ulp1,ulp);
            int rankU=size.get(ulp);
            size.set(ulp, rankU + 1);
        }

    }

    int findU(int x){
        if(parent.get(x)==x){
            return x;
        }
        int foundp=findU(parent.get(x));
        parent.set(x,foundp);
        return foundp;
    }
}

class Main{
    public static void main(String[] args) {
        Disjoint ds = new Disjoint(8);
        ds.UnionByRank(1, 2);
        ds.UnionByRank(2, 3);
        ds.UnionByRank(4, 5);
        ds.UnionByRank(6, 7);
        ds.UnionByRank(5, 6);

        // if 3 and 7 same or not
        if (ds.findU(3) == ds.findU(7)) {
            System.out.println("Same");
        } else
            System.out.println("Not Same");

        ds.UnionByRank(3, 7);

        if (ds.findU(3) == ds.findU(7)) {
            System.out.println("Same");
        } else
            System.out.println("Not Same");
    }
}

