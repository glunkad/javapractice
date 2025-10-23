package com.glunkad.javapractice.week1;

import java.util.Arrays;
import java.util.HashMap;

//Given two strings s and t, return true if t is an of s, and false otherwise.
//Example 1:
//Input: s = "anagram", t = "nagaram"
//Output: true
//Example 2:
//Input: s = "rat", t = "car"
//Output: false
//Constraints:
//1 <= s.length, t.length <= 5 * 104
//s and t consist of lowercase English letters.
//Follow up: What if the inputs contain Unicode characters? How would you adapt your solution to such a case?
public class ValidAnagram {

    /*TC: O(nLog(n))*/
    public static boolean isAnagram1(String s, String t){
        char[] sArray = s.toCharArray();
        char[] tArray = t.toCharArray();

        Arrays.sort(sArray);
        Arrays.sort(tArray);
        return Arrays.equals(sArray, tArray);
    }

//    TC : O(N) SC : O(1)
    public static boolean isAnagram2(String s, String t){
        if(s.length() != t.length()){
            return false;
        }

        int[] map = new int[26];

        for(int i = 0; i < s.length(); i++){
            map[s.charAt(i) - 'a']++;
            map[t.charAt(i) - 'a']--;
        }

        for(int i = 0; i < 26; i++){
            if(map[i] != 0){
                return false;
            }
        }
        return true;

    }

    public static void main(String[] args) {
        String s = "anagram";
        String t = "nagaram";
        System.out.println(isAnagram2(s, t));
    }
}
