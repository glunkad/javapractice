package com.glunkad.javapractice.week1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
/*
M1
Sort the strings & use them as a key in hashtable
and append the list O(mnlogn)

M2
count the freq of the characters and use them as a key in the hash table
so the TC improves O(m*n) SC : O(m)
* */
public class GroupAnagrams {
    // TC : O(mnlogn)
    public static List<List<String>> groupAnagrams1(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();
        for(String str : strs){
            char[] charArray = str.toCharArray();
            Arrays.sort(charArray);
            String key = Arrays.toString(charArray);
            map.putIfAbsent(key,new ArrayList<>());
            map.get(key).add(str);
        }
        return new ArrayList<>(map.values());
    }

    private static List<List<String>> groupAnagrams2(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();
        for(String str : strs){
            int[] count = new int[26];
            for(char ch : str.toCharArray()){
                count[ch  - 'a']++;
            }
            String key = Arrays.toString(count);
            map.putIfAbsent(key, new ArrayList<>());
            map.get(key).add(str);
        }
        return new ArrayList<>(map.values());
    }


    public static void main(String[] args) {
        String[] input = {"eat", "tea", "tan", "ate", "nat", "bat"};
//        List<List<String>> output = groupAnagrams1(input);
        List<List<String>> output = groupAnagrams2(input);
        System.out.println(output);
    }

}
