package leetcode.Tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @program: risk-leecode-example
 * @description:
 * @author: niuliguo
 * @create: 2019-12-07 22:10
 **/
public class Pro1022 {

    private List<List<Integer>> res = new ArrayList<List<Integer>>();
    public int sumRootToLeaf(TreeNode root) {

        if (root == null) {
            return 0;
        }

        preOrder(root, new ArrayList<Integer>());

        System.out.println(res);

        return process(res);
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

    public int process(List<List<Integer>> listList) {
        if (listList == null || listList.size() == 0) {
            return 0;
        }

        int sum = 0;
        for(List<Integer> list: listList) {
            Collections.reverse(list);
            for(int i = 0; i < list.size(); i++) {
                if (list.get(i) == 0) {
                    continue;
                }
                sum += (1 << i);
            }
        }

        return sum;
    }

    public static void main(String[] args) {

    }
}
