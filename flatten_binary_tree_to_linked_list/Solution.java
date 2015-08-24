package kai.leetcode.algorithm.flatten_binary_tree_to_linked_list;

//Given a binary tree, flatten it to a linked list in-place.
//
//For example,
//Given
//
//         1
//        / \
//       2   5
//      / \   \
//     3   4   6
//The flattened tree should look like:
//   1
//    \
//     2
//      \
//       3
//        \
//         4
//          \
//           5
//            \
//             6

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
	public void flatten(TreeNode root) {
		flat(root);
	}

	public TreeNode flat(TreeNode root) {
		if (root == null)
			return null;
		if (root.left == null && root.right == null)
			return root;
		else if (root.left == null) {
			return flat(root.right);
		} else if (root.right == null) {
			root.right = root.left;
			root.left = null;
			return flat(root.right);
		} else {
			TreeNode node = flat(root.left);
			node.right = root.right;
			TreeNode node1 = flat(root.right);
			root.right = root.left;
			root.left = null;
			return node1;
		}
	}
}