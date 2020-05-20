package leetcode.Graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program: risk-leecode-example
 * @description:
 * @author: niuliguo
 * @create: 2020-05-13 10:33
 **/

class Node {
    public int val;
    public List<Node> neighbors;

    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }

    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }

    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}

/**
 * 1.bfs，构建邻接表，map，key:val value:关联节点值
 * 2.重新建立
 */
public class Pro133_Clone_Graph {

    private Map<Integer, List<Integer>> val2neighbors = new HashMap<>();
    private Map<Integer, Node> val2node = new HashMap<>();
    public Node cloneGraph(Node node) {
        if (null == node) {
            return null;
        }
        if (null == node.neighbors || node.neighbors.size() == 0) {
            return new Node(node.val);
        }

        createMap(node);

        for(Map.Entry<Integer, List<Integer>> entry: val2neighbors.entrySet()) {
            int val = entry.getKey();
            List<Integer> list = entry.getValue();
            Node nodeTmp = val2node.get(val);
            List<Node> neighbors = new ArrayList<>();
            for(Integer neighborVal : list) {
                neighbors.add(val2node.get(neighborVal));
            }
            nodeTmp.neighbors = neighbors;
        }

        for(Map.Entry<Integer, Node> entry: val2node.entrySet()) {
            return entry.getValue();
        }

        return null;
    }

    private void createMap(Node node) {
        if (node == null || val2neighbors.containsKey(node.val)) {
            return;
        }

        List<Integer> list = new ArrayList<>();
        List<Node> neighbors = node.neighbors;
        if (!val2node.containsKey(node.val)) {
            val2node.put(node.val, new Node(node.val));
        }
        for(Node neighbor: neighbors) {
            list.add(neighbor.val);
            if (!val2node.containsKey(neighbor.val)) {
                val2node.put(neighbor.val, new Node(neighbor.val));
            }
            createMap(neighbor);
        }
        val2neighbors.put(node.val, list);

    }
}
