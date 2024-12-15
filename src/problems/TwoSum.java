package problems;

import java.util.HashMap;

/**
 * Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 * You can return the answer in any order.
 */

public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> numsMap = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            int compliment = target - nums[i];
            if(numsMap.containsKey(compliment)){
                return new int[] { numsMap.get(compliment), i };
            }
            numsMap.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }
}
