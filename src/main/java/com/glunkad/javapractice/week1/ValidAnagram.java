package com.glunkad.javapractice.week1;

public class ValidAnagram {

    private static boolean isAnagram(String s, String t) {
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
        System.out.println(isAnagram(s,t));
    }

}
