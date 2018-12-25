package easy._026;

/**
 * Created by reiserx on 2018/5/3.
 */
public class RemoveDuplicate {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3,2,1};
        System.out.printf(removeDuplicates(nums) + "");
    }


    public static int removeDuplicates(int[] nums) {
        int max = nums[nums.length - 1];
        int index = 0;
        int less = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[index] == max) {
                break;
            }
            index = i;

            for (int j = i; j < nums.length; j++) {
                int a = nums[i];
                int b = nums[j];

                if (b > less) {
                    nums[i] = b;
                    nums[j] = a;
                    less = b;
                    break;
                }
            }
        }

        return index + 1;
    }

}



