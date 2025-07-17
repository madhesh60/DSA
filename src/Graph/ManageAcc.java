package Graph;

import java.util.*;

public class ManageAcc {
    public static void main(String[] args){

    }
    public static List<List<String>> helper(List<List<String>> arr){
            List<List<String>> ans=new ArrayList<>();
            int n=arr.size();
            Disjoint ds=new Disjoint(n);
            Map<String,Integer> map=new HashMap<>();

            for(int i=0;i<n;i++) {
                for (int j = 1; j < arr.get(i).size(); j++) {
                    String mail = arr.get(i).get(j);
                    if (map.containsKey(mail) == false) {
                        map.put(mail, i);
                    } else {
                        ds.UnionBySize(i, map.get(mail));
                    }
                }
            }
            ArrayList<String>[] addbyParents = new ArrayList[n];
            for (int i = 0; i < n; i++){
                addbyParents[i] = new ArrayList<String>();
            }
        for(Map.Entry<String,Integer> entry:map.entrySet()){
                String mail= entry.getKey();
                int node= ds.findU(entry.getValue());
                addbyParents[node].add(mail);
            }

            for(int i=0;i<n;i++){
                ans.add(new ArrayList<>());
            }

            for(int i=0;i<ans.size();i++){
                if(addbyParents[i].size()==0) continue;
                Collections.sort(addbyParents[i]);

                List<String> temp = new ArrayList<>();
                temp.add(arr.get(i).get(0));
                for(String it:addbyParents[i]){
                      temp.add(it);
                }
                ans.add(temp);
            }
            return ans;
    }
}
