package leetcode.Tree;

import java.util.ArrayList;
import java.util.List;

public class Pro783_Minimum_Distance_Between_BST_Nodes {


    private List<Integer> list = new ArrayList<>();

    public int minDiffInBST(TreeNode root) {

        inorderTraverse(root);

        return findMinDis();

    }

    private int findMinDis() {
        int minDis = Integer.MAX_VALUE;
        for(int i = 0; i < list.size() - 1; i++) {
            minDis = Math.min(minDis, list.get(i+1) - list.get(i));
        }

        return minDis;
    }

    private void inorderTraverse(TreeNode root) {
        if (null == root) {
            return;
        }

        inorderTraverse(root.left);

        list.add(root.val);

        inorderTraverse(root.right);
    }
}
