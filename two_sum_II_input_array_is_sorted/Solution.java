package kai.leetcode.algorithm.two_sum_II_input_array_is_sorted;

//Given an array of integers that is already sorted in ascending order, find two numbers such that they add up to a specific target number.
//
//The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must be less than index2. Please note that your returned answers (both index1 and index2) are not zero-based.
//
//You may assume that each input would have exactly one solution.
//
//Input: numbers={2, 7, 11, 15}, target=9
//Output: index1=1, index2=2

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
