package _007;

/**
 * Author: reiserx
 * Date:2019/1/11
 * Des:
 */
public class Solution {

    public int reverse(int x) {
        boolean negative = false;
        if (x < 0) {
            negative = true;
            x = -x;
        } else if (x == 0) {
            return x;
        }
        char[] container = String.valueOf(x).toCharArray();
        int result = 0;
        for (int i = container.length - 1; i > -1; i--) {
            int t = (int) Math.pow(10, i);
            int r = Integer.valueOf(String.valueOf(container[i])) * t;
            result += r;
        }
        return negative ? -result : result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
//        System.out.println(solution.reverse(123));
//        System.out.println(solution.reverse(-123));
//        System.out.println(solution.reverse(153423646));
//        System.out.println(solution.reverse(1534236469));
        System.out.println(9*1000000000);
//        System.out.println(solution.reverse(2147483647));
    }
}
