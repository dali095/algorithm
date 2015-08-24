package kai.leetcode.algorithm.palindrome_number;

//Determine whether an integer is a palindrome. Do this without extra space.

public class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0)
            return false;
        if (x < 10)
            return true;
        if (x % 10 == 0)
            return false;
        
        int m = 1;
        int xx = x;
        while (xx >= 10){
            xx = xx / 10;
            m = m * 10;
        }
        
        while (x >= 10){
            if (x % 10 == x / m){

                x = x % m;
                x = x / 10;
                m = m / 100;
                
                
                while (x < m){
                    if (x % 10 != 0)
                        return false;
                    else {
                        x = x / 10;
                        m = m / 100;
                    }
                }
            }else 
                return false;
        }
        
        
        return true;
    }
}