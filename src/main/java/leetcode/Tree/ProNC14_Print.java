package leetcode.Tree;

import java.util.*;

/**
 * 算法：
 * 1、层序遍历二叉树
 * 2、Z方式输出
 */
public class ProNC14_Print {

    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {

        if (null == pRoot) {
            return new ArrayList<>();
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(pRoot);

        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        int level = 0;
        while(!queue.isEmpty()) {
            int size = queue.size();
            ArrayList<Integer> tmpList = new ArrayList<>();
            while (size > 0) {
                TreeNode tmp = queue.poll();
                tmpList.add(tmp.val);
                if (tmp.left != null) {
                    queue.add(tmp.left);
                }
                if (tmp.right != null) {
                    queue.add(tmp.right);
                }
                size--;
            }
            if (level % 2 == 0) {
                res.add(tmpList);
            } else {
                Collections.reverse(tmpList);
                res.add(tmpList);
            }
            level++;
        }

        return res;
    }
}
