package leetcode.Tree;

/**
 * @program: leeeeetcode
 * @description:
 * @author: niuliguo
 * @create: 2020-08-23 18:22
 **/
public class Pro404_Sum_Of_Left_Leaves {

    private int sum = 0;
    public int sumOfLeftLeaves(TreeNode root) {

        inOrder(root);

        return sum;
    }

    public void inOrder(TreeNode root) {
        if (null == root) {
            return;
        }

        inOrder(root.left);
        //定位左叶子节点
        if (root.left != null && root.left.left == null && root.left.right == null) {
            sum += root.left.val;
        }
        inOrder(root.right);
    }
}
