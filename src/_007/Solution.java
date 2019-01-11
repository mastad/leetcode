package _007;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: reiserx
 * Date:2019/1/11
 * Des:
 */
public class Solution {

    public int reverse(int x) {
        boolean negative = false;
        if (x < 0) {
            negative = true;
            x = -x;
        } else if (x == 0) {
            return x;
        }
        List<Integer> container = new ArrayList<>();

        container.add(1);
        container.add(2);
        container.add(3);
        container.add(4);
        container.add(2);
        container.add(3);
        container.add(6);
        container.add(4);
        container.add(6);
        container.add(9);


        int result = 0;
        for (int i = container.size() - 1; i > -1; i--) {
            int t = (int) Math.pow(10, i);
            int r = container.get(i) * t;
            result += r;
        }
        return negative ? -result : result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.reverse(123));
        System.out.println(solution.reverse(-123));
        System.out.println(solution.reverse(1534236469));
        System.out.println(solution.reverse(2147483647));
    }
}
