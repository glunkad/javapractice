package com.glunkad.javapractice.week1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
Given an array nums of size n, return the majority element.

The majority element is the element that appears more than [n / 2] times.
You may assume that the majority element always exists in the array.

Example 1:

Input: nums = [3,2,3]
Output: 3

Example 2:

Input: nums = [2,2,1,1,1,2,2]
Output: 2



Constraints:

    n == nums.length
    1 <= n <= 5 * 104
    -109 <= nums[i] <= 109
    The input is generated such that a majority element will exist in the array.


Follow-up: Could you solve the problem in linear time and in O(1) space?
 */
public class MajorityElement {

    // TC : O(n^2) SC : O(1)
    private static int majorityElement1(int[] nums) {
        int n = nums.length;
        for(int i = 0 ; i < n; i++){
            int count = 0;
            for(int j = 0; j < n; j++){
                if(nums[i] == nums[j]){
                    count++;
                }
            }
            if(count  >= n/2){
                return nums[i];
            }
        }
        return 0;
    }

    // TC : O(n) SC : O(n)
    public static int majorityElement2(int[] nums) {
        int n = nums.length;
        Map<Integer,Integer> count = new HashMap<>();

        for(int num : nums){
            count.put(num, count.getOrDefault(num,0)+1);
        }

        int res = 0;
        for(Map.Entry<Integer,Integer> entry : count.entrySet()){
            if(entry.getValue() >= n / 2){
                res = entry.getKey();
            }
        }
        return res;
    }

    // TC : O(nlogn) SC : O(1)
    private static int majorityElement3(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }


    // TC : O(n) SC : O(1)
    private static int majorityElement4(int[] nums) {
        int candidate = 0;
        int count = 0;

        for(int num : nums){
            if(count == 0){
                candidate = num;
            }
            count += (num == candidate) ? 1 : -1;
        }

        return candidate;
    }

    public static void main(String[] args) {
        int[] nums = {3,2,3};
//        int res = majorityElement1(nums);
//        int res = majorityElement2(nums);
//        int res = majorityElement3(nums);
        int res = majorityElement4(nums);
        System.out.println(res);
    }
}
