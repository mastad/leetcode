package _008;

/**
 * Author: reiserx
 * Date:2019/1/20
 * Des:
 */
public class Solution {


    //考虑负数
    public int myAtoi(String str) {

        //判断空
        if (str == null || str.isEmpty()) {
            return 0;
        }
        char[] chars = str.toCharArray();
        int i = 0;
        StringBuilder sb = new StringBuilder();
        while (chars[i] == ' ') {
            i++;
        }
        if (chars[i] == '+' || chars[i] == '-'||(chars[i] <= '9' && chars[i] >= '1')) {
            sb.append(chars[i]);
            i += 1;
        } else {
            return 0;
        }
        for (; i < chars.length; i++) {
            char item = chars[i];
            if (item <= '9' && item >= '1') {
                sb.append(item);
            }
        }
        return Integer.valueOf(sb.toString());
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
//        System.out.println(solution.myAtoi("42"));
        System.out.println(solution.myAtoi("4193 with words"));
        System.out.println(solution.myAtoi("-91283472332"));
        System.out.println(solution.myAtoi("   -42"));
        System.out.println(solution.myAtoi("words and 987"));

    }
}
