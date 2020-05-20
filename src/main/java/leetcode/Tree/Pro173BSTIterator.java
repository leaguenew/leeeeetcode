package leetcode.Tree;

import java.util.Stack;

/**
 * @program: risk-leecode-example
 * @description: 参考中序遍历的迭代实现
 * @author: niuliguo
 * @create: 2020-03-28 22:50
 **/
public class Pro173BSTIterator {

    Stack<TreeNode> stack = new Stack<TreeNode>();
    public Pro173BSTIterator(TreeNode root) {
        while (root != null) {
            stack.add(root);
            root = root.left;
        }
    }

    /** @return the next smallest number */
    public int next() {
        TreeNode cur = stack.pop();
        TreeNode root = cur.right;
        while (root != null) {
            stack.add(root);
            root = root.left;
        }

        return cur.val;
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !stack.isEmpty();
    }
}
