package kai.leetcode.algorithm.single_number_ii;

import java.util.HashMap;
import java.util.Iterator;
//
//Given an array of integers, every element appears three times except for one. Find that single one.
//
//Note:
//Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?


public class Solution {
    public int singleNumber(int[] A) {
        HashMap<Integer, Integer> m = new HashMap<Integer, Integer>();
        
        for (int i = 0; i < A.length; i++){
            if (!m.containsKey(A[i])){
                m.put(A[i], null);
            } else {
                if (m.get(A[i]) == null){
                    m.put(A[i], A[i]);
                } else {
                    m.remove(A[i]);
                }
            }
        }
        
        Iterator<Integer> i = m.keySet().iterator();
        return i.next();
        
        
    }
}