package _151;

/**
 * Created by reiserx on 2019/4/1.
 * 颠倒单词
 */
public class Solution {

    public String reverseWords(String s) {


        String[] words = s.split(" ");
        StringBuilder sb = new StringBuilder();

        for (int i = words.length - 1; i >= 0; i--) {

            if (!"".equals(words[i].trim())) {
                sb.append(words[i]).append(" ");
            }
        }
        if (sb.length() == 0) {
            return sb.toString();
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.reverseWords("the sky is blue"));
        System.out.println(solution.reverseWords("  hello world!  "));
        System.out.println(solution.reverseWords("a good   example"));
        System.out.println(solution.reverseWords(""));
        System.out.println(solution.reverseWords(" "));
//        System.out.println(solution.reverseString2("hello"));


    }
}
