package leetcode.Tree;

import java.util.*;

/**
 * @program: risk-leecode-example
 * @description:
 * @author: niuliguo
 * @create: 2020-03-28 21:43
 **/
public class Pro145 {

    List<Integer> resList = new ArrayList<Integer>();

    public List<Integer> postorderTraversal(TreeNode root) {
        postOrder(root);

        return resList;
    }

    private void postOrder(TreeNode root) {
        if (null == root) {
            return;
        }

        postOrder(root.left);
        postOrder(root.right);
        resList.add(root.val);
    }


    /**
     * 后续遍历迭代解法：基于谦虚遍历迭代解法
     * 接下来我们思考一下前序遍历和后序遍历之间的关系：
       前序遍历顺序为：根 -> 左 -> 右
       后序遍历顺序为：左 -> 右 -> 根
       如果1： 我们将前序遍历中节点插入结果链表尾部的逻辑，修改为将节点插入结果链表的头部
       那么结果链表就变为了：右 -> 左 -> 根
       如果2： 我们将遍历的顺序由从左到右修改为从右到左，配合如果1
       那么结果链表就变为了：左 -> 右 -> 根
       这刚好是后序遍历的顺序
     * param root
     * @return
     */
    public List<Integer> postorderTraversal1(TreeNode root) {
        LinkedList<Integer> result = new LinkedList<>();
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode cur = root;
        while(!stack.isEmpty() || cur != null) {
            if(cur != null) {
                stack.push(cur);
                result.addFirst(cur.val);  // Reverse the process of preorder
                cur = cur.right;             // Reverse the process of preorder
            } else {
                TreeNode node = stack.pop();
                cur = node.left;           // Reverse the process of preorder
            }
        }
        return result;
    }
}
