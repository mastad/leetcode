package _069;


/**
 * Author: reiserx
 * Date:2019/3/29
 * Des:Sqrt(x)
 */
public class Solution {

    public int mySqrt(int x) {
        if (x == 1) {
            return 1;
        }
        int low = 1;
        int high = x;
        int mid = 0;
        while (low <= high) {
            mid = low + ((high - low) >> 1);
            int n = x / mid;
            if (n == mid) {
                return mid;
            } else if (n < mid) {
                high = mid - 1;
            } else {
                int nr = x / (mid + 1);
                if (nr < (mid + 1)) {
                    return mid;
                } else {
                    low = mid + 1;
                }
            }
        }

        return mid;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
//        System.out.println(solution.mySqrt(4));
//        System.out.println(solution.mySqrt(8));
//        System.out.println(solution.mySqrt(6));
//        System.out.println(solution.mySqrt(36));
//        System.out.println(solution.mySqrt(2147395599));
        System.out.println(solution.mySqrt(Integer.MAX_VALUE));
//        System.out.println(solution.longestValidParentheses(")()())"));
//        System.out.println(solution.longestValidParentheses(")"));
//        System.out.println(solution.longestValidParentheses(""));
//        System.out.println(solution.longestValidParentheses("("));
    }
}
