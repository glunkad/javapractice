package com.glunkad.javapractice.week1;
/*
Given an integer array nums, move all 0's to the end of it while maintaining the relative order of the non-zero elements.
Note that you must do this in-place without making a copy of the array.

Example 1:
Input: nums = [0,1,0,3,12]
Output: [1,3,12,0,0]

Example 2:
Input: nums = [0]
Output: [0]

Constraints:
    1 <= nums.length <= 104
    -231 <= nums[i] <= 231 - 1

Follow up: Could you minimize the total number of operations done?
 */

public class MoveZeroes {

    // TC : O(n) SC : O(n) => extra array.
    public static int[] moveZeroes(int[] nums) {
        int sz = nums.length;
        int[] res = new int[sz];

        int countOfZeroes = 0;
        int index = 0;

        for(int i = 0; i < sz; i++){
            if(nums[i] != 0){
                res[index++] = nums[i];
            }
            else{
                countOfZeroes++;
            }
        }

        for(int i = 0; i < countOfZeroes; i++){
            res[index++] = 0;
        }
        return res;
    }

    // TC : O(n) SC : O(1)
    private static int[] moveZeroes2(int[] nums) {
        int sz = nums.length;

        int index = 0;
        int noOfZeroes = 0;

        for(int num : nums){
            if(num!=0){
                nums[index++] = num;
            }
            else{
                noOfZeroes++;
            }
        }

        for(int i = 0; i < noOfZeroes; i++){
            nums[index++] = 0;
        }
        return nums;
    }
    public static void main(String[] args) {
        int[] nums = {0,1,0,3,12};
//        int[] res = moveZeroes1(nums);
        int[] res = moveZeroes2(nums);
        for(int num : res){
            System.out.println(num);
        }
    }



}
