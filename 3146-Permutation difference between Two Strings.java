import java.util.HashMap;
import java.util.Map;

/**
    You are given two strings s and t such that every character occurs at most once in s and t is a permutation of s.

    The permutation difference between s and t is defined as the sum of the absolute difference between the index of the occurrence of each character in s and the index of the occurrence of the same character in t.

    Return the permutation difference between s and t.
 */
class Solution {
    public int findPermutationDifference(String s, String t) {
        Map<Character,Integer> indexS = new HashMap<>();
        //1. We store the characters of s with its index
        for (int i=0; i<s.length(); i++)
            indexS.put(s.charAt(i),i);
        int sum = 0;
        //2. Sum every difference between index of t and its index at s
        for(int i=0; i<t.length(); i++)
            sum += Math.abs(i-indexS.get(t.charAt(i)));
        return sum;
    }
}