package _15;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by reiserx on 2017/12/8.
 * 三和为零
 */
public class ThreeSum {
    public static void main(String[] args) {
        int[] s = new int[]{-1, 0, 1, 2, -1, -4};
        List<List<Integer>> result = threeSum(s);
        System.out.println(result.size());
    }

    private static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> hadIndex = new ArrayList<>();
        for (int i = 0; i < nums.length - 2; i++) {
            int one = nums[i];
            for (int j = i + 1; j < nums.length - 1; j++) {
                int two = nums[j];
                for (int k = j + 1; k < nums.length; k++) {
                    int three = nums[k];
                    int indexSum = i + j + k;
                    if (one + two + three == 0&&!hadIndex.contains(indexSum)) {
                        List<Integer> r = new ArrayList<>();
                        r.add(one);
                        r.add(two);
                        r.add(three);
                        result.add(r);
                        hadIndex.add(indexSum);
                    }


                }
            }

        }
        return result;

    }
}
