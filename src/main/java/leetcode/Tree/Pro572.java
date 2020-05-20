package leetcode.Tree;

import java.awt.*;

/**
 * @program: risk-leecode-example
 * @description:
 * 题目508 + 100的综合体，涉及到两步：
 * 1.遍历二叉树
 * 2.判断子树跟目标数是否是相同的树，
 * @author: niuliguo
 * @create: 2019-12-07 23:17
 **/
public class Pro572 {

    private TreeNode ss;
    private TreeNode tt;
    private boolean flag = false;
    public boolean isSubtree(TreeNode s, TreeNode t) {

        ss = s;
        tt = t;

        preOrder(ss);

        return flag;
    }

    private void preOrder(TreeNode root) {
        if (root == null) {
            return;
        }

        preOrder(root.left);
        preOrder(root.right);
        if (isSameTree(root, tt)) {
            flag = true;
        }

        return;
    }

    private boolean isSameTree(TreeNode r1, TreeNode r2) {

        if (r1 == null && r2 == null) {
            return true;
        } else if ( (r1 != null && r2 == null) || (r1 == null && r2 != null) ) {
            return false;
        }

        return r1.val == r2.val && isSameTree(r1.left, r2.left) && isSameTree(r1.right, r2.right);
    }

    public static void main(String[] args) {

    }
}
