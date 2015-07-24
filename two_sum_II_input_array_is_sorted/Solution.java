package kai.leetcode.algorithm.two_sum_II_input_array_is_sorted;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int[] twoSum(int[] numbers, int target) {
        if (numbers == null || numbers.length < 1)
            return null;
        
        Map<Integer,Integer> map = new HashMap<Integer, Integer>();
        
        int[] result = new int[2];
        int i = 0;
        for (; numbers[i] <= target / 2; i++){
            map.put(numbers[i], i);
            if (numbers[i] == target / 2) {
                i++;
                break;
            }
        }
        
        for (; i < numbers.length; i++){
            if (map.containsKey(target - numbers[i])) {
                result[0] = map.get(target - numbers[i]) + 1;
                result[1] = i + 1;
                return result;
            }
        }
        return result;
        
    }
}
