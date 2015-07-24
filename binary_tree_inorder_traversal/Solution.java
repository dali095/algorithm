package kai.leetcode.algorithm.binary_tree_inorder_traversal;

import java.util.ArrayList;
import java.util.List;

//  Definition for binary tree
class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
	}
}

public class Solution {
	public List<Integer> inorderTraversal(TreeNode root) {
        
        List<Integer> result = new ArrayList<Integer>();
        if (root == null)
            return result;
        
        if (root.left != null)
            t(root.left, result);
        result.add(root.val);
        if (root.right != null)
            t(root.right, result);
        return result;
        
    }

	private void t(TreeNode root, List<Integer> result) {
		if (root.left != null)
			t(root.left, result);
		result.add(root.val);
		if (root.right != null)
			t(root.right, result);

	}
}