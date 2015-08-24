package kai.leetcode.algorithm.longest_consecutive_sequence;

import java.util.HashMap;

//Given an unsorted array of integers, find the length of the longest consecutive elements sequence.
//
//For example,
//Given [100, 4, 200, 1, 3, 2],
//The longest consecutive elements sequence is [1, 2, 3, 4]. Return its length: 4.
//
//Your algorithm should run in O(n) complexity.
public class Solution {
    public int longestConsecutive(int[] num) {
        HashMap<Integer, Range> minMap = new HashMap<Integer, Range>();
        HashMap<Integer, Range> maxMap = new HashMap<Integer, Range>();
        
        for (int i = 0; i < num.length; i++){
            if (maxMap.containsKey(num[i] - 1) && minMap.containsKey(num[i] + 1)){
                Range maxRange = maxMap.get(num[i] - 1);
                maxMap.remove(num[i] - 1);
                
                Range minRange = minMap.get(num[i] + 1);
                minMap.remove(num[i] + 1);
                
                Range newRange = new Range(maxRange.min, minRange.max);
                maxMap.put(newRange.max, newRange);
                minMap.put(newRange.min, newRange);
                
            } else if (maxMap.containsKey(num[i] - 1)){
                Range maxRange = maxMap.get(num[i] - 1);
                maxMap.remove(maxRange.max);
                minMap.remove(maxRange.min);
                
                if (maxMap.get(maxRange.max + 1) != null){
                    if (maxMap.get(maxRange.max + 1).max - maxMap.get(maxRange.max + 1).min >= maxRange.max + 1 - maxRange.min)
                        continue;
                }
                Range newRange = new Range(maxRange.min, maxRange.max + 1);
                maxMap.put(newRange.max, newRange);
                minMap.put(newRange.min, newRange);
                
            } else if (minMap.containsKey(num[i] + 1)) {
                Range minRange = minMap.get(num[i] + 1);
                maxMap.remove(minRange.max);
                minMap.remove(minRange.min);
                
                if (minMap.get(minRange.min - 1) != null){
                    if (minMap.get(minRange.min - 1).max - minMap.get(minRange.min - 1).min >= minRange.max + 1 - minRange.min)
                        continue;
                }

                Range newRange = new Range(minRange.min - 1, minRange.max);
                maxMap.put(newRange.max, newRange);
                minMap.put(newRange.min, newRange);
            } else {
                if (!maxMap.containsKey(num[i]) && !minMap.containsKey(num[i])){
                    Range r = new Range(num[i], num[i]);
                    minMap.put(num[i], r);
                    maxMap.put(num[i], r);
                }
            }
        }
        
        int result = 0;
        for (Range r : maxMap.values()){
            if (result < r.max - r.min + 1)
                result = r.max - r.min + 1;
        }
        return result;
        
        
    }
}

class Range{
    int max;
    int min;
    Range(int i, int j){
        min = i;
        max = j;
    }
}
