package _041;

/**
 * Author: reiserx
 * Date:2019/3/12
 * Des:  First Missing Positive
 */
public class Solution {

    public int firstMissingPositive(int[] nums) {

        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (nums[i] <= 0 || nums[i] > n) {
                nums[i] = n + 1;
            }
        }
        for (int i = 0; i < n; i++) {
            int num = Math.abs(nums[i]);
            if (num > n) {
                continue;
            }
            num--;
            if (nums[num] > 0) {
                nums[num] = -1 * nums[num];
            }
            print(nums);
        }

        for (int i = 0; i < n; i++) {
            if (nums[i] >= 0) {
                return i + 1;
            }
        }

        return n + 1;

    }

    public static void main(String[] args) {
        Solution solution = new Solution();

//        System.out.println(solution.firstMissingPositive(new int[]{1, 2, 0}));
//        System.out.println(solution.firstMissingPositive(new int[]{3, 4, -1, 1}));
//        System.out.println(solution.firstMissingPositive(new int[]{1, 7, 8, 9, 11, 12}));
//        System.out.println(solution.firstMissingPositive(new int[]{2, 1}));
        System.out.println(solution.firstMissingPositive(new int[]{2, 1, 4, -10, 0}));
        System.out.println(solution.firstMissingPositive(new int[]{1, 2, 3, 4, 5}));
    }

    private void print(int[] nums) {

        System.out.print("[");
        for (int i : nums) {
            System.out.print(" " + i + ",");
        }
        System.out.println("]");
    }


}
