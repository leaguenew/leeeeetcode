package leetcode.DP;

/**
 * @program: risk-leecode-example
 * @description:
 * @author: niuliguo
 * @create: 2019-12-04 00:00
 **/
public class Pro338 {

    public int[] countBits(int num) {
        int[] res = new int[num + 1];
        for(int i = 0; i<= num; i++) {
            res[i] = bitOneCnt(i);
        }

        return res;
    }

    public int[] countBits1(int num) {
        int[] dp = new int[num + 1];

        dp[0] = 0;
        dp[1] = 1;

        for(int i = 2; i <= num; i++) {
            dp[i] = dp[i >> 1] + (i & 1);
        }

        return dp;
    }

    public int bitOneCnt(int n) {
        int c = 0 ; // 计数器
        while (n > 0)
        {
            if((n & 1) == 1) // 当前位是1
                ++c ; // 计数器加1
            n >>= 1 ; // 移位
        }
        return c ;
    }

    public static void main(String[] args) {
        Pro338 pro = new Pro338();

        int[] res = pro.countBits(5);
        for(Integer Int: res) {
            System.out.println(Int);
        }
    }
}
