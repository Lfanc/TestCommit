package cn.whsw.task;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public static void main(String[] args) {
        int[] x = {2,7,11,15};
        int[] y = twoSum(x,9);
        for (int i:y) {
            System.out.println(i);
        }
    }

    public static int[] twoSum(int[] nums, int target){
        int[] result = new int[2];
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            int num = target - nums[i];
            if(map.containsKey(num)){
                result[0] = i;
                result[1] = map.get(num);
                return result;
            }
            map.put(nums[i],i);
        }
        return result;
    }
}
