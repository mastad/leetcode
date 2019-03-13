package _169;

import java.util.HashMap;
import java.util.Map;

/**
 * Author: reiserx
 * Date:2019/3/12
 * Des:Majority Element
 */
class Solution {
    public int majorityElement(int[] nums) {

        Map<Integer, Integer> map = new HashMap();
        int n = nums.length % 2 == 1 ? nums.length / 2 + 1 : nums.length / 2;

        for (int i = 0; i < nums.length; i++) {
            int key = nums[i];
            Integer times = map.get(key);
            if (times == null) {
                map.put(key, 1);
            } else {
                times += 1;
                if (times >= n) {
                    return nums[i];
                }
                map.put(key, times);
            }
        }

        return nums[0];

    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.majorityElement(new int[]{3, 2, 3}));
        System.out.println(solution.majorityElement(new int[]{2, 2, 1, 1, 1, 2, 2}));
        System.out.println(solution.majorityElement(new int[]{1}));
    }
}