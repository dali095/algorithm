package kai.leetcode.algorithm.sort_colors;

//Given an array with n objects colored red, white or blue, sort them so that objects of the same color are adjacent, with the colors in the order red, white and blue.
//
//Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.
//
//Note:
//You are not suppose to use the library's sort function for this problem.

public class Solution {
    public void sortColors(int[] A) {
        if (A == null || A.length < 2)
            return;
        int red = 0;
        int blue = A.length - 1;
        
        while (red < A.length && A[red] == 0)
            red++;
            
        while (blue >= 0 && A[blue] == 2)
            blue--;
        

        for (int i = red; i <= blue && i < A.length; i++){
            if (A[i] == 0){
                A[i] = A[red];
                A[red] = 0;
                while (red < A.length && A[red] == 0)
                    red++;

            }
        }
        
        while (blue >= 0 && A[blue] == 2)
            blue--;
        
        for (int i = red; i <= blue && i < A.length; i++){
            if (A[i] == 2){
                A[i] = A[blue];
                A[blue] = 2;
                while (blue >= 0 && A[blue] == 2)
                    blue--;

            }
        }
        
    }
}