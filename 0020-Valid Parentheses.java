/*
Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
An input string is valid if:
    1. Open brackets must be closed by the same type of brackets.
    2. Open brackets must be closed in the correct order.
    3. Every close bracket has a corresponding open bracket of the same type.
*/

import java.util.Stack;

class Solution {
    public boolean isValid(String s) {
        int openCh = 0;
        boolean res = true;
        Stack<Character> stack = new Stack<>();
        for(int i=0; i<s.length() && res; i++)
        {
            switch (s.charAt(i)){
                case '(': stack.push(')'); openCh++; break;
                case '[': stack.push(']'); openCh++; break;
                case '{': stack.push('}'); openCh++; break;
                default: 
                    if (stack.empty() || stack.pop() != s.charAt(i)) res = false;
                    else  openCh--;
            }
        }
        return (res && openCh == 0);
    }
}