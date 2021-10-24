package leetcode.Tree;

public class Pro111_Minimum_Depth_Of_Binary_Tree {

    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        if (root.left == null && root.right == null) {
            return 1;
        }

        int leftDepth = minDepth(root.left);
        int rightDepth = minDepth(root.right);

        if (leftDepth == 0) {
            return 1 + rightDepth;
        } else if (rightDepth == 0) {
            return 1 + leftDepth;
        } else {
            return 1 + Math.min(rightDepth, leftDepth);
        }
    }
}
