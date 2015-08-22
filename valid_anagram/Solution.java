package kai.leetcode.algorithm.valid_anagram;
//Given two strings s and t, write a function to determine if t is an anagram of s.
//
//For example,
//s = "anagram", t = "nagaram", return true.
//s = "rat", t = "car", return false.


public class Solution {
    public boolean isAnagram(String s, String t) {
        if (s == null || t == null)
            return false;
        if (s.length() != t.length()){
            return false;
        }
        
        int[] counts = new int[26];
        
        for (int i = 0; i < s.length(); i++){
            counts[s.charAt(i) - 97] ++;
        }
        
        for (int i = 0; i < t.length(); i++){
            counts[t.charAt(i) - 97] --;
            if (counts[t.charAt(i) - 97] < 0)
                return false;
        }
        
        return true;
        
    }
}