package leetcode.Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @program: risk-leecode-example
 * @description:
 * @author: niuliguo
 * @create: 2019-12-08 00:15
 **/
public class Pro1161 {

    public int maxLevelSum(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<TreeNode>();

        if (root == null) {
            return 0;
        }

        queue.add(root);

        int max = 0, levelRet = 1, level = 1;
        while (queue.size() > 0) {

            List<Integer> list = new ArrayList<Integer>();

            int size = queue.size();

            while (size-- > 0) {
                TreeNode tmp = queue.poll();
                if (tmp != null) {
                    list.add(tmp.val);
                    queue.add(tmp.left);
                    queue.add(tmp.right);
                }
            }

            if (list.size() > 0) {
                int sumList = sum(list);
                if (sumList > max) {
                    levelRet = level;
                }
            }
            level++;
        }

        return levelRet;
    }

    private int sum(List<Integer> list) {
        int sum = 0;
        for(Integer Int: list) {
            sum += Int;
        }

        return sum;
    }

    public static void main(String[] args) {

    }
}
