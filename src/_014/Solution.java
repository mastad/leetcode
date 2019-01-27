package _014;

/**
 * Author: reiserx
 * Date:2019/1/27
 * Des:寻找最长前缀
 */
public class Solution {

    public String longestCommonPrefix(String[] strs) {
        if (strs.length < 1) {
            return "";
        }
        String result = "";
        for (int i = 0; i < strs[0].length(); i++) {
            char c = strs[0].charAt(i);
            for (int j = 1; j < strs.length; j++) {
                if (i>strs[j].length()-1||strs[j].charAt(i) != c) {
                    return result;
                }
            }
            result += c;
        }

        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(solution.longestCommonPrefix(new String[]{"dog", "racecar", "car"}));
        System.out.println(solution.longestCommonPrefix(new String[]{"flower", "flow", "flight"}));
        System.out.println(solution.longestCommonPrefix(new String[]{}));
        System.out.println(solution.longestCommonPrefix(new String[]{"aa","a"}));
        System.out.println(solution.longestCommonPrefix(new String[]{"aa"}));
    }
}
