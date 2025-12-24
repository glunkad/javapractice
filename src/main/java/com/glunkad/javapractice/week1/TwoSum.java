package com.glunkad.javapractice.week1;

/*
M1: Bruteforce
using 2 for loops
TC : O(n^2) SC : O(1)

M2:
using HashMap
save the num , index then loop through and check
* */

import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    // TC : O(n^2) SC : O(1)
    private static int[] twoSum1(int[] nums, int target) {
        for(int i = 0; i < nums.length; i++ ){
            int num = target - nums[i];
            for(int j = i + 1; j < nums.length; j++){
                if(nums[j] == num){
                    return  new int[]{i,j};
                }
            }
        }
        return new int[]{};
    }

    // TC : O(n) SC : O(n)
    private static int[] twoSum2(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < nums.length; i++){
            int num1 = nums[i];
            int num2 = target - num1;
            if(map.containsKey(num2)){
                return new int[]{map.get(num2), i};
            }
            map.put(nums[i], i);
        }
        return new  int[]{};
    }

    public static void main(String[] args) {
        int[] nums = {2,7,11,15};
        int target = 9;
//        int[] res = twoSum1(nums, target);
        int[] res = twoSum2(nums, target);
        for(int num : res){
            System.out.println(num);
        }
    }


}
