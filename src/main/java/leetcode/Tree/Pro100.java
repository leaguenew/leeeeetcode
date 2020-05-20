package leetcode.Tree;

public class Pro100 {

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (null == p && q == null) {
            return true;
        } else if ( (null == p && null != q) || (null != p && null == q) ) {
            return false;
        } else {
            return (p.val == q.val) && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        }
    }
}
