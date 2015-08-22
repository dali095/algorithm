package kai.leetcode.algorithm.generate_parentheses;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

//Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
//
//For example, given n = 3, a solution set is:
//
//"((()))", "(()())", "(())()", "()(())", "()()()"


public class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<String>();
        HashSet<String> set = new HashSet<String>();
        result.addAll(gen(n, n, set, ""));
        return result;
        
    }
    
    public HashSet<String> gen(int left, int right, HashSet<String> result, String current){
        if (left == 0 && right == 0) {
            result.add(current);
        } else if (left == right) {
            gen(left - 1, right, result, current + "(");
        } else if (left < right) {
            if (left > 0) {
                gen(left - 1, right, result, current + "(");
            }
            gen(left, right - 1, result, current + ")");
        }
        return result;
    }
    
    private Set<String> gen(int n) {
        Set<String> set = new HashSet<String>();
        if (n == 1) {
            set.add("()");
        } else {
            Set<String> oldSet = gen(n - 1);
            Iterator it = oldSet.iterator();
            while (it.hasNext()){
                String ss = (String)it.next();
                for (int i = 0; i <= ss.length(); i++){
                    for (int j = i; j <= ss.length(); j++){
                        set.add(ss.substring(0, i) + "(" + ss.substring(i, j) + ")" + ss.substring(j));
                    }
                }
            }
        }
        return set;
    }
}