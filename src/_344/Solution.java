package _344;

/**
 * Created by reiserx on 2017/11/27.
 * 颠倒字符串
 */
public class Solution {

    public String reverseString(String s) {
        StringBuilder sb = new StringBuilder();
        char[] chars = s.toCharArray();
        for (int j = chars.length - 1; j > -1; j--) {
            sb.append(chars[j]);
        }
        return sb.toString();
    }

    public String reverseString2(String s) {
        return new StringBuilder(s).reverse().toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.reverseString("hello"));
        System.out.println(solution.reverseString2("hello"));


    }
}
