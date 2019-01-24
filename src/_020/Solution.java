package _020;

import java.util.Stack;

/**
 * Created by reiserx on 2017/12/11.
 */
public class Solution {

    public  boolean isValid(String s) {
        Stack<Integer> p = new Stack<>();
        for(int i = 0; i < s.length(); i++) {
            int q = "(){}[]".indexOf(s.substring(i, i + 1));
            if(q % 2 == 1) {
                if(p.isEmpty() || p.pop() != q - 1) return false;
            } else p.push(q);
        }
        return p.isEmpty();

    }

    public static void main(String[] args) {
        Solution solution=new Solution();
        System.out.println(solution.isValid("()"));
        System.out.println(solution.isValid("(]"));
        System.out.println(solution.isValid("(){}"));
        System.out.println(solution.isValid("){"));
        System.out.println(solution.isValid("([)]"));
    }
}
