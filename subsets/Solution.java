package kai.leetcode.algorithm.subsets;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
//
//Given a set of distinct integers, nums, return all possible subsets.
//
//Note:
//Elements in a subset must be in non-descending order.
//The solution set must not contain duplicate subsets.
//For example,
//If nums = [1,2,3], a solution is:
//
//[
//  [3],
//  [1],
//  [2],
//  [1,2,3],
//  [1,3],
//  [2,3],
//  [1,2],
//  []
//]

public class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new LinkedList<List<Integer>>();
        Arrays.sort(nums);
        List<Integer> aList = new LinkedList<Integer>();
        result.add(aList);
        
        for (int i : nums){
            List<List<Integer>> more = new LinkedList<List<Integer>>();
            for (List<Integer> list : result) {
                List<Integer> c = new LinkedList<Integer>();
                c.addAll(list);
                c.add(i);
                more.add(c);
            }
            result.addAll(more);
        }
        return result;
    }
}
