package _009;

/**
 * Author: reiserx
 * Date:2019/1/22
 * Des:回文数字
 */
public class Solution {

    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }

        if (x < 10) {
            return true;
        }

        String xs = String.valueOf(x);

        int i = 0;
        int j = xs.length() - 1;

        while (i < xs.length() / 2) {
            if (xs.charAt(i) != xs.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }

        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(solution.isPalindrome(0));
        System.out.println(solution.isPalindrome(-121));
        System.out.println(solution.isPalindrome(121));
        System.out.println(solution.isPalindrome(1001));
        System.out.println(solution.isPalindrome(1000));
        System.out.println(solution.isPalindrome(10));
    }
}
