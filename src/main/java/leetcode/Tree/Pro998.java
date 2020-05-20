package leetcode.Tree;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * @program: risk-leecode-example
 * @description:
 * @author: niuliguo
 * @create: 2019-12-07 21:25
 **/
public class Pro998 {

    private List<String> ret = new ArrayList<String>();
    private List<List<Integer>> res = new ArrayList<List<Integer>>();
    public String smallestFromLeaf(TreeNode root) {

        if (root == null) {
            return null;
        }

        preOrder(root, new ArrayList<Integer>());

        System.out.println(res);

        process(res);

        System.out.println(ret);
        return ret.get(0);
    }

    public void preOrder(TreeNode node, List<Integer> tempList) {
        if (node == null) {
            return;
        }

        tempList.add(node.val);
        if (node.left == null && node.right == null) {
            res.add(tempList);
        }

        preOrder(node.left, new ArrayList<Integer>(tempList));
        preOrder(node.right, new ArrayList<Integer>(tempList));

        return ;
    }

    public void process(List<List<Integer>> listList) {
        if (listList == null || listList.size() == 0) {
            return;
        }

        for(List<Integer> list: listList) {
            Collections.reverse(list);
            StringBuilder sb = new StringBuilder();
            for(Integer Int : list) {
                sb.append(String.valueOf((char)('a' + Int)));
            }
            ret.add(sb.toString());
        }

        Collections.sort(ret);
    }

    public static void main(String[] args) {

        List<String> list = new ArrayList<String>();
        list.add("c");
        list.add("b");
        list.add("a");
        list.add("abd");
        list.add("abc");
        System.out.println(list);
        Collections.sort(list);
        System.out.println(list);

        System.out.println(String.valueOf((char) ('a' + 3)));

        TreeNode l3Node1 = new TreeNode(5);
        TreeNode l2Node1 = new TreeNode(2, null, l3Node1);
        TreeNode l2Node2 = new TreeNode(3, null, null);
        TreeNode root = new TreeNode(1, l2Node1, l2Node2);
        Pro998 pro = new Pro998();
        System.out.println(pro.smallestFromLeaf(root));

    }
}
