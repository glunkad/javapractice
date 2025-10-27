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
    // Bruteforce O(NlogN+MlogM)
    public static boolean isAnagram1(String s, String t) {
        char[] sArr = s.toCharArray();
        char[] tArr = t.toCharArray();

        Arrays.sort(sArr);
        Arrays.sort(tArr);

        for(int i  = 0; i < sArr.length; i++){
            if(sArr[i] != tArr[i]){
                return false;
            }
        }
        return true;
    }


    // TC : O(n+m) SC : O(1)
    public static boolean isAnagram2(String s, String t) {
        if(s.length() != t.length()){
            return false;
        }
        HashMap<Character, Integer> mapS = new HashMap<Character, Integer>();
        HashMap<Character, Integer> mapT = new HashMap<Character, Integer>();
        for(int i = 0 ; i < s.length(); i++){
            mapS.put(s.charAt(i), mapS.getOrDefault(s.charAt(i), 0) + 1);
            mapT.put(t.charAt(i), mapT.getOrDefault(t.charAt(i), 0) + 1);
        }

        return mapS.equals(mapT);
    }

    // TC : O(n+m) SC : O(1)
    public static boolean isAnagram3(String s, String t) {
        if(s.length() != t.length()){
            return false;
        }
        int[] map = new int[26];
        for(int i = 0; i < s.length(); i ++){
            map[s.charAt(i) - 'a']++;
            map[t.charAt(i) - 'a']--;
        }

        for(int i : map){
            if( i != 0){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "anagram";
        String t = "nagaram";
        System.out.println(isAnagram3(s, t));
    }
}
