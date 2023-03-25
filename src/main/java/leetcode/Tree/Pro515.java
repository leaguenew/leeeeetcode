package leetcode.Tree;


import java.util.*;

/**
 * @program: risk-leecode-example
 * @description:
 * 算法一：map + 递归遍历（带层数递归）
 * 算法二：层序遍历
 * @author: niuliguo
 * @create: 2020-02-02 19:39
 **/
public class Pro515 {

    private Map<Integer, Integer> level2Max = new HashMap<>();
    public List<Integer> largestValues(TreeNode root) {

        inorderTraversal(root, 0);

        List<Integer> resList = new ArrayList<>();

        for(Map.Entry<Integer, Integer> map: level2Max.entrySet()) {
            resList.add(map.getValue());
        }

        return resList;
    }

    private void inorderTraversal(TreeNode root, int level) {

        if (root == null) {
            return;
        }

        inorderTraversal(root.left, level + 1);
        if (level2Max.get(level) == null) {
            level2Max.put(level, root.val);
        } else {
            if (level2Max.get(level) < root.val) {
                level2Max.put(level, root.val);
            }
        }
        inorderTraversal(root.right, level + 1);
    }


    private List<Integer> res = new ArrayList<>();
    public List<Integer> largestValues1(TreeNode root) {

        Queue<TreeNode> queue = new LinkedList<TreeNode>();

        if (root == null) {
            return res;
        }

        queue.add(root);

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
                int max = findMax(list);
                res.add(max);
            }
        }

        return res;
    }

    private int findMax(List<Integer> list) {
        int max = Integer.MIN_VALUE;
        for(Integer item: list) {
            if (item > max) {
                max = item;
            }
        }

        return max;
    }

    public static void main(String[] args) {

    }
}
