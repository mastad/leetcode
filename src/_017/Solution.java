package _017;

import java.util.*;

/**
 * Author: reiserx
 * Date:2019/1/28
 * Des:数字转字母
 */
public class Solution {


    private Map<String, String> phone = new HashMap<String, String>() {{
        put("2", "abc");
        put("3", "def");
        put("4", "ghi");
        put("5", "jkl");
        put("6", "mno");
        put("7", "pqrs");
        put("8", "tuv");
        put("9", "wxyz");
    }};

    private List<String> output = new ArrayList<>();


    public List<String> letterCombinations(String digits) {

        if (digits.length() != 0) {
            backtrack("", digits);
        }
        return output;
    }

    private void backtrack(String combination, String nextDigits) {

        if ("".equals(nextDigits)) {
            output.add(combination);
            return;
        }
        String num = nextDigits.substring(0, 1);
        String chars = phone.get(num);
        for (int i = 0; i < chars.length(); i++) {
            String subcombination = combination + chars.substring(i, i + 1);
            backtrack(subcombination, nextDigits.substring(1));
        }


    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.letterCombinations(""));
        System.out.println(solution.letterCombinations("23"));
    }
}
