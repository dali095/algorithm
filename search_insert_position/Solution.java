package kai.leetcode.algorithm.search_insert_position;
//Given a sorted array and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.
//
//You may assume no duplicates in the array.
//
//Here are few examples.
//[1,3,5,6], 5 → 2
//[1,3,5,6], 2 → 1
//[1,3,5,6], 7 → 4
//[1,3,5,6], 0 → 0
public class Solution {
    public int searchInsert(int[] A, int target) {
        if (A == null || A.length == 0)
            return 0;
        
        
        return search(A, 0, A.length - 1, target);
        
    }
    
    private int search(int[] A, int startIndex, int endIndex, int target){
        int i = (startIndex + endIndex) / 2;

        if (A[i] < target){
            startIndex = i + 1;
            if (startIndex >= A.length)
                return A.length;
            
            
            if (startIndex <= endIndex)
                return search(A, startIndex, endIndex, target);
            else 
                return startIndex;
        } else if (A[i] == target){
            return i;
        } else {
            endIndex = i - 1;
            if (endIndex < 0)
                return 0;
            if (endIndex < startIndex)
                return startIndex;
            else 
                return search(A, startIndex, endIndex, target);
        }
        
    }
}