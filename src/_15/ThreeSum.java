package _15;

import java.util.*;

/**
 * Created by reiserx on 2017/12/8.
 * 三和为零
 */
public class ThreeSum {
    public static void main(String[] args) {
        int[] s = new int[]{-1, 0, 1, 2, -1, -4};
//        int[] s = new int[]{-4,-2,-2,-2,0,1,2,2,2,3,3,4,4,6,6};
//        int[] s = new int[]{12,5,-12,4,-11,11,2,7,2,-5,-14,-3,-3,3,2,-10,9,-15,2,14,-3,-15,-3,-14,-1,-7,11,-4,-11,12,-15,-14,2,10,-2,-1,6,7,13,-15,-13,6,-10,-9,-14,7,-12,3,-1,5,2,11,6,14,12,-10,14,0,-7,11,-10,-7,4,-1,-12,-13,13,1,9,3,1,3,-5,6,9,-4,-2,5,14,12,-5,-6,1,8,-15,-10,5,-15,-2,5,3,3,13,-8,-13,8,-5,8,-6,11,-12,3,0,-2,-6,-14,2,0,6,1,-11,9,2,-3,-6,3,3,-15,-5,-14,5,13,-4,-4,-10,-10,11};
//        int[] s = new int[]{0,0,0,0};
        List<List<Integer>> result = threeSum(s);
        System.out.println(result.size());
    }


    private static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        Map<String, Integer> hadIndex = new HashMap<>();
        for (int i = 0; i < nums.length - 2; i++) {
            int one = nums[i];
            for (int j = i + 1; j < nums.length - 1; j++) {
                int two = nums[j];
                //二分查找
                int threeIndex = -1;
                int start = j + 1;
                int end = nums.length - 1;
                int khey = -(one + two);
                int mid;
                while (start <= end) {
                    mid = start + (end - start) / 2;
                    if (nums[mid] < khey)
                        start = mid + 1;
                    else if (nums[mid] > khey)
                        end = mid - 1;
                    else {
                        threeIndex = mid;
                        break;
                    }
                }
                if (threeIndex != -1) {
                    //去重
                    int three = nums[threeIndex];
                    String index = String.valueOf(one) + String.valueOf(two) + String.valueOf(three);
                    if (one + two + three == 0 && hadIndex.get(index) == null) {
                        List<Integer> r = new ArrayList<>();
                        r.add(one);
                        r.add(two);
                        r.add(three);
                        result.add(r);
                        hadIndex.put(index, 0);
                    }
                }
            }

        }
        return result;
    }

}
