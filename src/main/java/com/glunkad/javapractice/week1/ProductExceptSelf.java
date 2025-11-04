package com.glunkad.javapractice.week1;

import java.util.Arrays;

/*
Given an integer array nums, return an array output where output[i] is the product of all the elements of nums except nums[i].
Each product is guaranteed to fit in a 32-bit integer.
Follow-up: Could you solve it in O(n)O(n) time without using the division operation?

Example 1:
Input: nums = [1,2,4,6]
Output: [48,24,12,8]

Example 2:
Input: nums = [-1,0,1,2,3]
Output: [0,-6,0,0,0]

Constraints:
    2 <= nums.length <= 1000
    -20 <= nums[i] <= 20
 */
public class ProductExceptSelf {
    // TC : O(N^2) SC : O(N)
    public static int[] productExceptSelf1(int[] nums) {
        int[] res = new int[nums.length];
        for(int i = 0; i < nums.length; i++){
            int num = nums[i];
            int product = 1;
            for(int j = 0; j < nums.length; j++){
                if(nums[j] != num){
                    product = product * nums[j];
                }
            }
            res[i] = product;
        }
        return res;
    }


    // TC : O(N) SC : O(N)
    private static int[] productExceptSelf2(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        int[] prefix = new int[n];
        int[] suffix = new int[n];

        prefix[0] = 1;
        suffix[n - 1] = 1;

        for(int i = 1; i < nums.length; i++){
            prefix[i] = nums[i - 1] * prefix[i - 1];
        }

        for(int i = n - 2; i >=0; i--){
            suffix[i] = nums[i + 1] * suffix[i + 1];
        }

        for(int i = 0; i < n ; i++){
            res[i] = prefix[i] * suffix[i];
        }
        return res;
    }

    // TC : O(N) SC : O(1)
    private static int[] productExceptSelf3(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];

        res[0] = 1;
        for(int i = 1; i < n; i++){
            res[i] = res[i - 1] * nums[i - 1];
        }

        int postfix = 1;
        for(int i = n - 1; i >= 0; i--){
            res[i] = res[i] * postfix;
            postfix = postfix * nums[i];
        }

        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,4,6};
//        int[] product = productExceptSelf1(nums);
//        int[] product = productExceptSelf2(nums);
        int[] product = productExceptSelf3(nums);
        for(int num : product){
            System.out.println(num);
        }
    }




}
