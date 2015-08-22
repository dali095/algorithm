package kai.leetcode.algorithm.maximum_depth_of_binary_tree;


//Given a binary tree, find its maximum depth.
//
//The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.


//Definition for binary tree
class TreeNode {
  int val;
  TreeNode left;
  TreeNode right;
  TreeNode(int x) { val = x; }
}

public class Solution {
    public int maxDepth(TreeNode root) {
        if (root == null)
            return 0;
        if (root.left == null && root.right == null)
            return 1;
        else if (root.right == null)
            return maxDepth(root.left) + 1;
        else if (root.left == null)
            return maxDepth(root.right) + 1;
        else {
            int l = maxDepth(root.left);
            int r = maxDepth(root.right);
            if (r > l)
                return r + 1;
            else 
                return l + 1;
        }
    }
}