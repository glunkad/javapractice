package com.glunkad.javapractice.week3;

/*
You are given a string s consisting of lowercase English letters. A duplicate removal consists of choosing two adjacent and equal letters and removing them.

We repeatedly make duplicate removals on s until we no longer can.

Return the final string after all such duplicate removals have been made. It can be proven that the answer is unique.

Example 1:
Input: s = "abbaca"
Output: "ca"
Explanation:
For example, in "abbaca" we could remove "bb" since the letters are adjacent and equal, and this is the only possible move.  The result of this move is that the string is "aaca", of which only "aa" is possible, so the final string is "ca".

Example 2:
Input: s = "azxxzy"
Output: "ay"

Constraints:
1 <= s.length <= 105
s consists of lowercase English letters.
 */

import java.util.Stack;

public class RemoveAllAdjacentDuplicatesInString {

    // TC : O(n) SC : O(n)
    public static String removeDuplicates(String s){
        Stack<Character> st = new Stack<>();

        for(char ch : s.toCharArray()){
            if(!st.empty()){
                if(st.peek() == ch){
                    st.pop();
                }
                else{
                    st.push(ch);
                }
            }
            else{
                st.push(ch);
            }
        }
        StringBuilder sb = new StringBuilder();
        while(!st.empty()){
            sb.append(st.peek());
            st.pop();
        }
        sb.reverse();
        return sb.toString();
    }

    public static void main(String[] args){
        String s = "azxxzy";
        String res = removeDuplicates(s);
        System.out.println(res);
    }
}
