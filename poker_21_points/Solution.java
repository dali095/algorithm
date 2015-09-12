package kai.leetcode.algorithm.poker_21_points;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class Solution {

    public static void main(String[] args){
    	int[] cards = {1,1,1,9};
        System.out.println(new Solution().points(cards));
    }

    public boolean points(int[] cards){
    	List<Integer> list = new ArrayList<Integer>();
    	for (int i : cards)
    		list.add(i);
    	return points(0, list);
    }
    
    private boolean points(int have, List<Integer> cards){
    	System.out.println(have);
    	for (int i = 0; i < cards.size(); i++){
    		int card = cards.get(i);
    		if (have + card == 21 && cards.size() == 1){
    			System.out.println(have + "+" + card);
    			return true;
    		} else {
    			cards.remove(i);
    			if (points(have + card, cards))
    				return true;
    		}
    		cards.add(i, card);
    		
    		if (have - card == 21 && cards.size() == 1){
    			System.out.println(have + "-" + card);
    			return true;
    		} else {
    			cards.remove(i);
    			if (points(have - card, cards))
    				return true;
    		}
    		cards.add(i, card);
    		
    		if (have * card == 21 && cards.size() == 1){
    			System.out.println(have + "*" + card);
    			return true;
    		} else {
    			cards.remove(i);
    			if (points(have * card, cards))
    				return true;
    		}
    		cards.add(i, card);
    		
    		if (have % card == 0 && have / card == 21 && cards.size() == 1){
    			System.out.println(have + "/" + card);
    			return true;
    		} else {
    			cards.remove(i);
    			if (points(have / card, cards))
    				return true;
    		}
    		cards.add(i, card);
    		
    		if (Math.pow(have, card) == 21 && cards.size() == 1){
    			System.out.println(have + "exp" + card);
    			return true;
    		} else {
    			cards.remove(i);
    			if (have >= 0 && Math.pow(have, card) < Integer.MAX_VALUE && Math.pow(have, card) > Integer.MIN_VALUE && points((int)Math.pow(have, card), cards))
    				return true;
    		}
    		cards.add(i, card);
    	}
    	return false;
    }
    
}