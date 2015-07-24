package kai.leetcode.algorithm.number_of_1_bits;
public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        if (n == 0)
            return 0;
        else if ( n < 0){
            long l = n;
            l = l + 1 + Integer.MAX_VALUE;
            return hammingWeight((int)(l / 2)) + ((int)(l % 2)) + 1;
        } else 
            return hammingWeight(n / 2) + (n % 2);
    }
}