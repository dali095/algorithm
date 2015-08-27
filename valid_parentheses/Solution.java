package kai.leetcode.algorithm.valid_parentheses;

import java.util.ArrayList;

public class Solution {
    public boolean isValid(String s) {
        if (s == null || s.length() < 1)
            return true;
            
        if (s.length() == 1)
            return false;
        
        ArrayList<Character> arr = new ArrayList<Character>();
        for (int i = 0; i < s.length(); i++){
            if (s.charAt(i) == '(' || s.charAt(i) == '[' || s.charAt(i) == '{'){
                arr.add(s.charAt(i));
            } else if (s.charAt(i) == ')'){
                if (arr.size() > 0 && arr.get(arr.size() - 1) == '('){
                    arr.remove(arr.size() - 1);
                } else {
                    return false;
                }
            } else if (s.charAt(i) == ']'){
                if (arr.size() > 0 && arr.get(arr.size() - 1) == '['){
                    arr.remove(arr.size() - 1);
                } else {
                    return false;
                }
            } else if (s.charAt(i) == '}'){
                if (arr.size() > 0 && arr.get(arr.size() - 1) == '{'){
                    arr.remove(arr.size() - 1);
                } else {
                    return false;
                }
            }
        }
        return arr.size() == 0;
        
        
    }
}