package cn.whsw.task;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class ArrayRemoveDuplicate {
    public static void main(String[] args) {
        int[] nums = {1,3,2,6,2,6,4,8,2,6};
        hashsetRemoveDuplicate(nums);
        System.out.println("-------------------");
        doublePoint(nums);
    }

    public static void hashsetRemoveDuplicate(int[] nums){
        Set<Integer> hashset = new HashSet<>();
        for (int i : nums){
            hashset.add(i);
        }
        Iterator<Integer> it = hashset.iterator();
        while (it.hasNext()){
            System.out.println(it.next());
        }
    }

    public static void doublePoint(int[] nums){
        Arrays.sort(nums);
        int fast = 1;
        int slow = 1;
        while (fast<nums.length){
            if(nums[fast] != nums[fast-1]){
                nums[slow] = nums[fast];
                slow++;
            }
            fast++;
        }
        System.out.println(Arrays.toString(nums));

    }

    public static void doubleFor(){

    }
}
