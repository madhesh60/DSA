package GreedyProb;

public class LemonadeEx {
    public static void main(String[] args) {
        int[] arr= {5,5,5,10,5,5,10,20,20,20};
        System.out.println(helper(arr));
    }
    public static boolean helper(int[] nums){
        int five=0;
        int ten=0;
        for(int i=0;i<nums.length;i++)
        {
            if(nums[i]==5) {
                five++;
            }
            else if (nums[i]==10) {
                ten++;
                if(five<=0) {
                    return false;
                }
                five--;
            }
            else
            {
                if(ten<=0 || five<1) {
                    if (five < 3) {
                        return false;
                    }
                }

                if(ten>0 && five>=1)
                {
                    ten--;
                    five--;
                } else if (five>=3) {
                    five=five-3;
                }
            }
        }
        return true;
    }
}
