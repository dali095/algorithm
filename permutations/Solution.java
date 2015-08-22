package kai.leetcode.algorithm.permutations;

import java.util.LinkedList;
import java.util.List;

//Given a collection of numbers, return all possible permutations.
//
//For example,
//[1,2,3] have the following permutations:
//[1,2,3], [1,3,2], [2,1,3], [2,3,1], [3,1,2], and [3,2,1].

public class Solution {
    public List<List<Integer>> permute(int[] num) {
        List<List<Integer>> result = new LinkedList<List<Integer>>();
        if (num == null || num.length < 1)
            return result;

        
        List<Integer> l = new LinkedList<Integer>();
        l.add(num[0]);
        result.add(l);
        return find(result, num, 1);
        
        
    }
    
    private List<List<Integer>> find(List<List<Integer>> l, int[] num, int pos) {
        if (pos == num.length)
            return l;
        
        List<List<Integer>> result = new LinkedList<List<Integer>>();
        
        for (List<Integer> ll : l){
            for (int i = 0; i <= ll.size(); i++){
                List<Integer> copy = new LinkedList<Integer>();
                copy.addAll(ll);
                copy.add(i, num[pos]);
                result.add(copy);
            }
        }
        
        return find(result, num, pos + 1);
    }
}