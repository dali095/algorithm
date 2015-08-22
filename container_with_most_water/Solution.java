package kai.leetcode.algorithm.container_with_most_water;

import java.util.ArrayList;

//
//Given n non-negative integers a1, a2, ..., an, where each represents a point at coordinate (i, ai). n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). Find two lines, which together with x-axis forms a container, such that the container contains the most water.
//
//Note: You may not slant the container.


public class Solution {
	public int maxArea(int[] height) {
		if (height.length <= 1)
			return 0;

		int max = 0;
		ArrayList<Integer> inc = new ArrayList<Integer>();
		inc.add(0);
		ArrayList<Integer> dec = new ArrayList<Integer>();
		dec.add(height.length - 1);

		for (int i = 1; i < height.length; i++) {
			if (height[i] > height[inc.get(inc.size() - 1)]) {
				inc.add(i);
			}

			if (height[height.length - i - 1] > height[dec.get(dec.size() - 1)]) {
				dec.add(height.length - i - 1);
			}
		}

		int p1 = 0;
		int p2 = 0;

		while (p1 < inc.size() && p2 < dec.size()) {
			while (p1 < inc.size() && p2 < dec.size()
					&& height[inc.get(p1)] <= height[dec.get(p2)]) {
				if (max < cal(inc.get(p1), dec.get(p2), height)) {
					max = cal(inc.get(p1), dec.get(p2), height);
				}
				p1++;
			}

			while (p1 < inc.size() && p2 < dec.size()
					&& height[dec.get(p2)] <= height[inc.get(p1)]) {
				if (max < cal(inc.get(p1), dec.get(p2), height)) {
					max = cal(inc.get(p1), dec.get(p2), height);
				}
				p2++;
			}

		}
		return max;
	}

	public int cal(int i, int j, int[] height) {
		if (height[i] > height[j])
			return height[j] * (j - i);
		else
			return height[i] * (j - i);
	}
}