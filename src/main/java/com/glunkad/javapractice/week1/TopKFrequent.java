package com.glunkad.javapractice.week1;

import java.util.*;

/*
Given an integer array nums and an integer k, return the k most frequent elements. You may return the answer in any order.



Example 1:

Input: nums = [1,1,1,2,2,3], k = 2

Output: [1,2]

Example 2:

Input: nums = [1], k = 1

Output: [1]

Example 3:

Input: nums = [1,2,1,2,1,2,3,1,3,2], k = 2

Output: [1,2]



Constraints:

1 <= nums.length <= 105
-104 <= nums[i] <= 104
k is in the range [1, the number of unique elements in the array].
It is guaranteed that the answer is unique.


Follow up: Your algorithm's time complexity must be better than O(n log n), where n is the array's size.
 */
public class TopKFrequent {
    //TC O(NlogN)
    public static int[] topKFrequent1(int[] nums, int k) {
        Map<Integer,Integer> count = new HashMap<>();
        for(int num :  nums){
            count.put(num, count.getOrDefault(num, 0)+1);
        }

        List<int[]> arr = new ArrayList<>();
        for(Map.Entry<Integer,Integer> entry : count.entrySet()){
            arr.add(new int[]{entry.getValue(), entry.getKey()});
        }

        arr.sort((a, b) -> b[0] - a[0]);

        int[] res = new int[k];
        for(int i = 0; i < k ; i++){
            res[i] = arr.get(i)[1];
        }
        return res;
    }

    // TC O(KlogN)
    public static int[] topKFrequent2(int[] nums, int k) {
        Map<Integer,Integer> count = new HashMap<>();
        for(int num :  nums){
            count.put(num, count.getOrDefault(num, 0)+1);
        }

        PriorityQueue<int[]> heap = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        for(Map.Entry<Integer,Integer> entry : count.entrySet()){
            heap.offer(new int[]{entry.getValue(), entry.getKey()});
            if(heap.size() > k){
                heap.poll();
            }
        }

        int[] res = new int[k];
        for(int i = 0; i < k; i++){
            res[i] = heap.poll()[1];
        }
        return res;
    }

    // TC : O(n)
    public static int[] topKFrequent3(int[] nums, int k){
        Map<Integer,Integer> count = new HashMap<>();
        for(int num : nums){
            count.put(num, count.getOrDefault(num,0)+1);
        }
        List<Integer>[] freq = new List[nums.length +1];
        for(int i = 0; i < freq.length; i++){
            freq[i] = new ArrayList<>();
        }

        for(Map.Entry<Integer, Integer> entry: count.entrySet()){
            freq[entry.getValue()].add(entry.getKey());
        }

        int[] res = new int[k];
        int index = 0;
        for(int i = freq.length - 1; i > 0 && index < k; i--){
            for(int n : freq[i]){
                res[index++] = n;
                if(index == k){
                    return res;
                }
            }
        }
        return res;
    }


    public static void main(String[] args){
        int[] nums = {1,1,1,2,2,3};
        int k = 2;
//        int[] res = topKFrequent1(nums, k);
//        int[] res = topKFrequent2(nums, k);
        int[] res = topKFrequent3(nums, k);
        for(int num : res){
            System.out.println(num);
        }
    }
}
