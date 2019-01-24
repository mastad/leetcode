package _013;

/**
 * Created by reiserx on 2017/12/6.
 * 罗马转整数
 */
public class Solution {

    private int romanToInt(String s) {
        int num[] = new int[s.length()];

        for (int i = 0; i < s.length(); i++) {
            switch (s.charAt(i)) {
                case 'M':
                    num[i] = 1000;
                    break;
                case 'D':
                    num[i] = 500;
                    break;
                case 'C':
                    num[i] = 100;
                    break;
                case 'L':
                    num[i] = 50;
                    break;
                case 'X':
                    num[i] = 10;
                    break;
                case 'V':
                    num[i] = 5;
                    break;
                case 'I':
                    num[i] = 1;
                    break;
            }
        }
        int sum = 0;
        for (int i = 0; i < num.length; i++) {
            if (i < num.length - 1 && num[i] < num[i + 1]) {
                sum = sum - num[i];
            } else {
                sum = sum + num[i];
            }
        }

        return sum;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.romanToInt("DCXXI"));
    }
}
