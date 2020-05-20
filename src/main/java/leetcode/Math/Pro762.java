package leetcode.Math;

/**
 * @program: risk-leecode-example
 * @description:
 * @author: niuliguo
 * @create: 2019-12-03 23:42
 **/
public class Pro762 {

    public int countPrimeSetBits(int L, int R) {
        int res = 0;
        for(int i = L; i <= R; i++) {
            int bitOneCnt = bitOneCnt(i);
            if (prime(bitOneCnt)) {
                res += 1;
            }
        }

        return res;
    }

    /**
     * 判断二进制1的个数
     * @param n
     * @return
     */
    private int bitOneCnt(int n) {
        int c = 0 ; // 计数器
        while (n > 0)
        {
            if((n & 1) == 1) // 当前位是1
                ++c ; // 计数器加1
            n >>= 1 ; // 移位
        }
        return c ;
    }

    /**
     * 判断质数
     * @param num
     * @return
     */
    private boolean prime(int num) {
        boolean flag = true;
        if(num == 1) {
            return false;
        }
        for(int i = 2; i <= num/2; i++) {
            if (num % i == 0) {
                flag = false;
                break;
            }
        }

        return flag;
    }

    public static void main(String[] args) {

    }
}
