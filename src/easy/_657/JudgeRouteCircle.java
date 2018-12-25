package easy._657;

/**
 * Created by reiserx on 2017/11/24.
 */
public class JudgeRouteCircle {
    public static void main(String[] args) {
        String input1 = "UD";
        String input2 = "LL";

        System.out.println(judgeCircle(input1));
        System.out.println(judgeCircle(input2));

    }


    private static boolean judgeCircle(String moves) {
        char[] chars = moves.toCharArray();
        int[] point = new int[]{0, 0};
        for (char c : chars) {
            switch (c) {
                case 'R':
                    point[0]++;
                    break;
                case 'L':
                    point[0]--;
                    break;
                case 'U':
                    point[1]++;
                    break;
                case 'D':
                    point[1]--;
                    break;
            }
        }
        return point[0] == 0 && point[1] == 0;
    }
}
