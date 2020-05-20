package leetcode.Heap;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @program: risk-leecode-example
 * @description:
 * @author: niuliguo
 * @create: 2019-12-22 19:27
 **/
public class Pro767 {

    class VO {
        private Character character;
        private Integer cnt;

        public VO(Character character, Integer cnt) {
            this.character = character;
            this.cnt = cnt;
        }

        public Character getCharacter() {
            return character;
        }

        public void setCharacter(Character character) {
            this.character = character;
        }

        public Integer getCnt() {
            return cnt;
        }

        public void setCnt(Integer cnt) {
            this.cnt = cnt;
        }
    }

    public String reorganizeString(String S) {
        Map<Character, Integer> char2Cnt = new HashMap<>();
        for(Character character: S.toCharArray()) {
            if (char2Cnt.get(character) == null) {
                char2Cnt.put(character, 1);
            } else {
                char2Cnt.put(character, char2Cnt.get(character) + 1);
            }
        }

        PriorityQueue<VO> bigHeap = new PriorityQueue<VO>((vo1, vo2) -> (vo2.cnt - vo1.cnt));
        for(Map.Entry<Character, Integer> map: char2Cnt.entrySet()) {
            bigHeap.add(new VO(map.getKey(), map.getValue()));
        }

        StringBuilder sb = new StringBuilder();
        while(sb.length() < S.length()) {
            VO peek = bigHeap.poll();
            if (sb.length() == 0 || peek.getCharacter() != sb.charAt(sb.length() - 1)) {
                sb.append(peek.getCharacter());
                if (peek.getCnt() > 1) {
                    peek.setCnt(peek.getCnt() - 1);
                    bigHeap.add(peek);
                }
            } else {
                VO peek2 = bigHeap.poll();
                if (peek2 == null || peek2.getCharacter() == peek.getCharacter()) {
                    return "";
                }
                sb.append(peek2.getCharacter());
                sb.append(peek.getCharacter());
                if (peek.getCnt() > 1) {
                    peek.setCnt(peek.getCnt() - 1);
                    bigHeap.add(peek);
                }
                if (peek2.getCnt() > 1) {
                    peek2.setCnt(peek2.getCnt() - 1);
                    bigHeap.add(peek2);
                }
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        Pro767 pro = new Pro767();
        System.out.println(pro.reorganizeString("aaab"));
    }
}
