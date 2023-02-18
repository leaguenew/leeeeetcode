package leetcode.Stack;


import java.util.*;

/**
 * @program: risk-leecode-example
 * @description: 超时了，换数据结构
 * @author: niuliguo
 * @create: 2019-12-23 11:02
 **/
public class Pro895 {

//    public FreqStack() {
//
//    }
    private Stack<Integer> s1;
    private Stack<Integer> s2;
    private Map<Integer, Integer> val2cnt;
    public Pro895() {
        s1 = new Stack<>();
        s2 = new Stack<>();
        val2cnt = new HashMap<>();
    }

    public void push(int x) {
        s1.push(x);
        if (!val2cnt.containsKey(x)) {
            val2cnt.put(x, 1);
        } else {
            val2cnt.put(x, val2cnt.get(x) + 1);
        }
    }

    public int pop() {
        //find most freq val list
        List<Integer> valList = new ArrayList<>();
        int mostFreq = Integer.MIN_VALUE;
        for(Map.Entry<Integer, Integer> map: val2cnt.entrySet()) {
            if (map.getValue() > mostFreq) {
                valList.clear();
                valList.add(map.getKey());
                mostFreq = map.getValue();
            } else if (map.getValue() == mostFreq) {
                valList.add(map.getKey());
            }
        }
        //pop most freq val using two stack
        int res = 0;
        while(s1.size() > 0) {
            int val = s1.pop();
            if (valList.contains(val)) {
                res = val;
                if (val2cnt.get(val) > 1) {
                    val2cnt.put(val, val2cnt.get(val) - 1);
                } else {
                    val2cnt.remove(val);
                }
                break;
            } else {
                s2.push(val);
            }
        }

        while (s2.size() > 0) {
            s1.push(s2.pop());
        }

        return res;
    }

    public static void main(String[] args) {
        Pro895 pro = new Pro895();
        pro.push(5);
        pro.push(7);
        pro.push(5);
        pro.push(7);
        pro.push(4);
        pro.push(5);
        System.out.println(pro.pop());
        System.out.println(pro.pop());
        System.out.println(pro.pop());
        System.out.println(pro.pop());
    }
}
