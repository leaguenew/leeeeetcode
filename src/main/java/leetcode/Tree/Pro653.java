package leetcode.Tree;

/**
 * @program: risk-leecode-example
 * @description:
 * @author: niuliguo
 * @create: 2019-12-08 10:22
 **/
public class Pro653 {

    private boolean flag = false;
    private int target;
    private TreeNode rootRoot;
    public boolean findTarget(TreeNode root, int k) {
        if (root == null) {
            return false;
        }

        rootRoot = root;
        this.target = k;
        postOrder(root);

        return  flag;
    }

    private void postOrder(TreeNode root) {
        if (root == null) {
            return;
        }

        postOrder(root.left);
        postOrder(root.right);
        if (root.val != target - root.val) {
            treeContainVal(rootRoot, target - root.val);
        }

        return;
    }

    private void treeContainVal(TreeNode root, int val) {
        if(root == null) {
            return;
        }

        /**
         * 利用BST的特性剪枝，不然超时
         */
        if (root.val == val) {
            flag = true;
        } else if (val < root.val) {
            treeContainVal(root.left, val);
        } else {
            treeContainVal(root.right, val);
        }

    }

    public static void main(String[] args) {
        int num = 2;
        System.out.println(num);
        System.out.println(-num);
    }
}
