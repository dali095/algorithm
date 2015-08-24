package kai.leetcode.algorithm.pow_x_y;

//Implement pow(x, n).

public class Solution {
    public double pow(double x, int n) {
        
        if (n == 0)
            return 1d;
        else if (n < 0){
            if (n == Integer.MIN_VALUE){
                return 1 / pow(x, -n - 1) / x;
            } else 
                return 1 / pow(x, -n);
        }
        else {
            double result = pow(x, n / 2);
            if (n % 2 == 0)
                return result * result;
            else
                return result * result * x;
        }
    }
}
