package leetcode.Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @program: risk-leecode-example
 * @description:
 * @author: niuliguo
 * @create: 2019-12-06 23:08
 **/
public class Pro429 {

    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        Queue<Node> queue = new LinkedList<Node>();

        if (root == null) {
            return res;
        }

        List<Integer> list;
        queue.add(root);
        while (queue.size() > 0) {
            list = new ArrayList<Integer>();
            int size = queue.size();
            while(size-- >  0) {
                Node tmp = queue.poll();
                if (tmp != null) {
                    list.add(tmp.val);
                    List<Node> children = tmp.children;
                    if (children != null) {
                        for(Node node: children) {
                            queue.add(node);
                        }
                    }
                }
            }

            res.add(list);
        }

        return res;
    }

    public static void main(String[] args) {
        Pro429 pro = new Pro429();

        Node l3Node1 = new Node(5, null);
        Node l3Node2 = new Node(6, null);
        List<Node> childl2Node1 = new ArrayList<Node>();
        childl2Node1.add(l3Node1);
        childl2Node1.add(l3Node2);

        Node l2Node1 = new Node(3, childl2Node1);
        Node l2Node2 = new Node(2, null);
        Node l2Node3 = new Node(4, null);
        List<Node> childl1Node1 = new ArrayList<Node>();
        childl1Node1.add(l2Node1);
        childl1Node1.add(l2Node2);
        childl1Node1.add(l2Node3);

        Node root = new Node(1, childl1Node1);

        System.out.println(pro.levelOrder(root));
    }
}
