package com.glunkad.javapractice.week1;

import java.util.HashMap;

//Given an array of integers nums and an integer target, return the indices i and j such that nums[i] + nums[j] == target and i != j.
//You may assume that every input has exactly one pair of indices i and j that satisfy the condition.
//Return the answer with the smaller index first.
public class TwoSum {

    public static int[] twoSum1(int[] nums, int target) {
        for(int i = 0; i < nums.length; i++){
            for(int j = i+1; j < nums.length; j++){
                if(nums[i]+ nums[j] == target){
                    return new int[]{i,j};
                }
            }
        }
        return new int[]{-1,-1};
    }

    // TC : O(n) SC : O(n)
    public static int[] twoSum2(int[] nums, int target) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            map.put(nums[i], i);
        }

        for(int i = 0; i < nums.length; i++){
            int nums2 = target - nums[i];
            if(map.containsKey(nums2) && map.get(nums2) != i){
                return new int[]{i, map.get(nums2)};
            }
        }

        return new int[]{};
    }

    public static int[] twoSum3(int[] nums, int target) {
        HashMap<Integer,Integer> map = new HashMap<>();

        for(int i = 0; i < nums.length; i++){
            int nums2 = target - nums[i];
            if(map.containsKey(nums2) ){
                return new int[]{map.get(nums2),i };
            }
            map.put(nums[i], i);
        }
        return new int[]{};
    }

    public static void main(String[] args) {
        int[] nums = {3,4,5,6};
        int target = 10;
        System.out.println(twoSum3(nums,target)[0]+""+twoSum2(nums,target)[1]);

    }

}
