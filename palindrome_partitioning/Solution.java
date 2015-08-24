package kai.leetcode.algorithm.palindrome_partitioning;

import java.util.ArrayList;

//Given a string s, partition s such that every substring of the partition is a palindrome.
//
//Return all possible palindrome partitioning of s.
//
//For example, given s = "aab",
//Return
//
//  [
//    ["aa","b"],
//    ["a","a","b"]
//  ]

public class Solution {
    public ArrayList<ArrayList<String>> partition(String s) {
        ArrayList<ArrayList<String>> arr = new ArrayList<ArrayList<String>>();
        ArrayList<String> part = new ArrayList<String>();
        find (s, part, arr);
        return arr;
        
    }
    
    public void find(String s, ArrayList<String> part, ArrayList<ArrayList<String>> result){
        if (s.length() < 1){
            ArrayList<String> pc = (ArrayList<String>)part.clone();
            result.add(pc);
            return;
        }
        
        for (int i = 1; i < s.length() + 1; i++){
            if (isPal(s.substring(0, i))){
                ArrayList<String> pc = (ArrayList<String>)part.clone();
                pc.add(s.substring(0, i));
                find(s.substring(i), pc, result);
            }
        }
        
        return;
        
    }
    
    public boolean isPal(String s){
        for (int i = 0; i < s.length() / 2; i++) {
            if (s.charAt(i) != s.charAt(s.length() - i - 1)){
                return false;
            }
        }
        return true;
    }
}
