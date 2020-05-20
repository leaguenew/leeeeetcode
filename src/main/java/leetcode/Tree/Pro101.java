package leetcode.Tree;

import java.util.*;

public class Pro101 {

    public TreeNode root = null;

    public boolean isSymmetric(TreeNode root) {

        if (null == root || ((root.left) == null && (root.right) == null)) {
            return true;
        }

        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        while(queue.size() > 0) {

            int size = queue.size();
            List<TreeNode> list = new ArrayList<TreeNode>();
            while(size-- > 0) {

                TreeNode node = queue.poll();
                list.add(node);
                if (node != null) {
                    queue.add(node.left);
                    queue.add(node.right);
                }
            }

            boolean flag = isSymmetricList(list);

            if (!flag) {
                return flag;
            }
        }

        return true;
    }

    private boolean isSymmetricList(List<TreeNode> list) {

        for (int i = 0 ;i < (list.size() + 1) / 2; i++) {
            if ( list.get(i) == null && list.get(list.size() - i - 1) == null) {
                continue;
            }
            if ( (list.get(i) == null && list.get(list.size() - i - 1) != null) ||
                    (list.get(i) != null && list.get(list.size() - i - 1) == null) ) {
                return false;
            }

            if ( list.get(i).val == list.get(list.size() - i - 1).val ) {
                continue;
            } else {
                return false;
            }
        }

        return true;
    }

    /**
     * 创建二叉树
     */
    private TreeNode createBinaryTree(TreeNode node) {

        Scanner in = new Scanner(System.in);
        //输入节点的值
//        System.out.println("请输入节点的值：");
        int value = in.nextInt();
        if(value != 0){
            node = new TreeNode(value);
            node.left = createBinaryTree(node.left);
            node.right = createBinaryTree(node.right);
        }else{
            node = null;
        }
        return node;
    }

    public static void main(String[] args) {

        Pro101 bTree = new Pro101();

        //input : 1 2 0 5 0 0 3 0 4 0 0
        /**
         1
         / \
         2  3
         \  \
         5  4
         */
        TreeNode root = bTree.createBinaryTree(bTree.root);

        System.out.println(bTree.isSymmetric(root));
    }
}
