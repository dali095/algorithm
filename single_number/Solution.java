package kai.leetcode.algorithm.single_number;

import java.util.HashSet;
public class Solution {
    public int singleNumber(int[] A) {
        HashSet<Integer> set = new HashSet<Integer>();
        for (int i = 0; i < A.length; i++){
            if (set.contains(A[i])){
                set.remove(A[i]);
            } else {
                set.add(A[i]);
            }
        }
        return set.iterator().next();
    }
}
