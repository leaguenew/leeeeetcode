

import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
public class CP1 {

    private List<List<Integer>> resList = new ArrayList<>();
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        if (null == root) {
            //logger
            return resList;
        }

        queue.add(root);
        int levelIdx = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> level = new ArrayList<>();
            while (size-- > 0) {
                TreeNode node = queue.poll();
                if (node == null) {
                    continue;
                }
                level.add(node.val);
                if (null != node.left) {
                    queue.add(node.left);
                }
                if (null != node.right) {
                    queue.add(node.right);
                }
            }
            resList.add(level);
            if (levelIdx%2 != 0) {
                Collections.reverse(level);
            }
            resList.add(level);

            levelIdx++;
        }

        return resList;
    }

    public static void main(String[] args) {
        CP1 cp = new CP1();
        //case1: null;
        TreeNode root = null;
        System.out.println(cp.levelOrder(root));

        //case2: one
        root = new TreeNode(2);
    }
}
