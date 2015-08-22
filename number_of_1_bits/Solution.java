package kai.leetcode.algorithm.number_of_1_bits;
//Write a function that takes an unsigned integer and returns the number of ’1' bits it has (also known as the Hamming weight).
//
//For example, the 32-bit integer ’11' has binary representation 00000000000000000000000000001011, so the function should return 3.

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