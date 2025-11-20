package com.glunkad.javapractice.week3;

import java.util.Stack;

/*
Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

An input string is valid if:

Open brackets must be closed by the same type of brackets.
Open brackets must be closed in the correct order.
Every close bracket has a corresponding open bracket of the same type.

Example 1:

Input: s = "()"

Output: true

Example 2:

Input: s = "()[]{}"

Output: true

Example 3:

Input: s = "(]"

Output: false

Example 4:

Input: s = "([])"

Output: true

Example 5:

Input: s = "([)]"

Output: false

Constraints:

1 <= s.length <= 104
s consists of parentheses only '()[]{}'.
 */

public class ValidParentheses {

    // TC : O(n) SC : O(n)
    private static boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        for(char ch : s.toCharArray()){
            if(ch == '(' || ch == '[' || ch == '{'){
                st.push(ch);
            }
            else{
                if(st.empty()){
                    return false;
                }
                char top = st.peek();
                if(ch == ')' && top != '(') {
                    return false;
                }
                if(ch == ']' && top != '[') {
                    return false;
                }
                if(ch == '}' && top != '{') {
                    return false;
                }
            }

        }
        return st.empty();
    }

    public static void main(String[] args) {
        String s = "]";
        System.out.println(isValid(s));
    }



}
