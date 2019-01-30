package _028;

/**
 * Author: reiserx
 * Date:2019/1/30
 * Des:字符串匹配
 */
public class Solution {

    //BF
    public int strStr1(String haystack, String needle) {
        char[] mainchars = haystack.toCharArray();
        char[] pchars = needle.toCharArray();

        if (pchars.length == 0 || haystack.equals(needle)) {
            return 0;
        }

        for (int i = 0; i <= mainchars.length - pchars.length; i++) {

            if (mainchars[i] == pchars[0]) {
                if (pchars.length == 1) {
                    return i;
                } else {
                    for (int j = 0; j < pchars.length; j++) {
                        if (mainchars[i + j] != pchars[j]) {
                            break;
                        } else {
                            if (j == pchars.length - 1) {
                                return i;
                            }
                        }
                    }
                }
            }

        }


        return -1;
    }

    public static void main(String[] args) {

        Solution solution=new Solution();

        System.out.println(solution.strStr1("ababcba","abc"));
    }
}
