package leetcode.Tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @program: leeeeetcode
 * @description:
 * @author: niuliguo
 * @create: 2020-08-23 19:03
 **/
public class Pro513_Find_Bottom_Left_Tree_Value {

    //递归
    private  int maxDepth = -1, res;
    public int findBottomLeftValue(TreeNode root) {
        inOrder(root, 0);

        return res;
    }

    private void inOrder(TreeNode root, int depth) {
        if (null == root) {
            return;
        }

        inOrder(root.left, depth + 1);
        if(depth > maxDepth) {
            maxDepth = depth;
            res = root.val;
        }
        inOrder(root.right, depth + 1);
    }

    //迭代
    public int findBottomLeftValue1(TreeNode root) {
        //层序遍历
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int res = 0;
        while (!queue.isEmpty()) {
            int count = queue.size();
            //将每层左边第一个作为结果
            res = queue.peek().val;
            while (count-- > 0) {
                TreeNode cur = queue.poll();
                if (cur.left != null) {
                    queue.add(cur.left);
                }
                if (cur.right != null) {
                    queue.add(cur.right);
                }
            }
        }
        return res;
    }


}
