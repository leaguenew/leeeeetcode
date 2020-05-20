package leetcode.Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @program: risk-leecode-example
 * @description:
 * @author: niuliguo
 * @create: 2020-03-28 21:12
 **/
public class Pro144 {

    private List<Integer> resList = new ArrayList<>();
    public List<Integer> preorderTraversal(TreeNode root) {

        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;

        while(!stack.isEmpty() || cur != null) {
            if(cur != null) {
                stack.push(cur);
                resList.add(cur.val);  // Add before going to children
                cur = cur.left;
            } else {
                TreeNode node = stack.pop();
                cur = node.right;
            }
        }

        return resList;
    }

    public List<Integer> preorderTraversal1(TreeNode root) {

        preOrder(root);

        return resList;
    }

    private void preOrder(TreeNode root) {
        if (null == root) {
            return;
        }

        resList.add(root.val);
        preOrder(root.left);
        preOrder(root.right);
    }
}
