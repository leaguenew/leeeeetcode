package leetcode.Stack;

import java.util.Stack;

/**
 * @program: risk-leecode-example
 * @description:
 * @author: niuliguo
 * @create: 2019-12-23 20:34
 **/
public class Pro1209 {

    class VO {
        private Character character;
        private int freq;

        public VO(Character character, int freq) {
            this.character = character;
            this.freq = freq;
        }

        public Character getCharacter() {
            return character;
        }

        public void setCharacter(Character character) {
            this.character = character;
        }

        public int getFreq() {
            return freq;
        }

        public void setFreq(int freq) {
            this.freq = freq;
        }
    }

    private Stack<VO> stack = new Stack<>();
    public String removeDuplicates(String s, int k) {
        if (s == null || s.length() == 0) {
            return s;
        }

        for(Character character: s.toCharArray()) {
            if(stack.isEmpty()) {
                stack.add(new VO(character, 1));
                continue;
            }
            if (stack.peek().getCharacter() == character) {
                if (stack.peek().getFreq() == k -1) {
                    int popCnt = k - 1;
                    while(popCnt > 0) {
                        stack.pop();
                        popCnt--;
                    }
                } else {
                    VO vo = new VO(character, stack.peek().getFreq() + 1);
                    stack.add(vo);
                }
            } else {
                stack.add(new VO(character, 1));
            }
        }

        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()) {
            Character c = stack.pop().getCharacter();
            sb.append(c);
        }
        sb.reverse();

        return sb.toString();
    }

    public static void main(String[] args) {
        Pro1209 pro = new Pro1209();
        System.out.println(pro.removeDuplicates("deeedbbcccbdaa", 3));
        System.out.println(pro.removeDuplicates("pbbcggttciiippooaais", 2));
    }
}
