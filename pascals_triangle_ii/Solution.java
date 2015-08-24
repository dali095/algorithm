package kai.leetcode.algorithm.pascals_triangle_ii;

import java.util.ArrayList;

//Given an index k, return the kth row of the Pascal's triangle.
//
//For example, given k = 3,
//Return [1,3,3,1].
//
//Note:
//Could you optimize your algorithm to use only O(k) extra space?

public class Solution {
    public ArrayList<Integer> getRow(int rowIndex) {
        
        ArrayList<Integer> result = new ArrayList<Integer>();
        result.add(1);
        if (rowIndex == 0){
            return result;
        }
        
        for (int i = 1; i <= rowIndex; i++){
            ArrayList<Integer> arr = new ArrayList<Integer>();
            arr.add(1);
            for (int j = 0; j < i - 1; j++){
                arr.add(result.get(j) + result.get(j + 1)); 
            }
            arr.add(1);
            result = arr;
        }
        return result;
        
    }
}
