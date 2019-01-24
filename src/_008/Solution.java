package _008;

/**
 * Author: reiserx
 * Date:2019/1/20
 * Des:
 */
public class Solution {

    //考虑负数
    public int myAtoi(String str) {


        int digit = 1;
        int total = 0;
        int i = 0;

        if (str == null || str.isEmpty() || str.length() == 0) {
            return total;
        }


        char[] chars = str.toCharArray();

        while (i < str.length() && chars[i] == ' ') {
            i++;
        }

        if (i >= str.length()) {
            return total;
        }

        if (chars[i] == '+') {
            i += 1;
        } else if (chars[i] == '-') {
            i += 1;
            digit = -1;
        }


        for (; i < chars.length; i++) {
            int d = chars[i] - '0';
            if (d < 0 || d > 9) {
                break;
            }

            if (digit == 1) {
                if (total > Integer.MAX_VALUE / 10 || (total == Integer.MAX_VALUE / 10 && d > 7)) {
                    return Integer.MAX_VALUE;
                }
            } else {
                if (total > Integer.MAX_VALUE / 10 || (total == Integer.MAX_VALUE / 10 && d > 8)) {
                    return Integer.MIN_VALUE;
                }
            }
            total = 10 * total + d;
        }
        return total * digit;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.myAtoi("42"));
        System.out.println(solution.myAtoi("4193 with words"));
        System.out.println(solution.myAtoi("-91283472332"));
        System.out.println(solution.myAtoi("   -42"));
        System.out.println(solution.myAtoi("words and 987"));
        System.out.println(solution.myAtoi(" "));
        System.out.println(solution.myAtoi("3.14159"));

    }
}
