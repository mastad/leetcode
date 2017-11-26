package string._557;

/**
 * Created by reiserx on 2017/11/26.
 */
public class ReverseWords {

    public static void main(String[] args) {
        String input = "Let's take LeetCode contest";
        String output = "s'teL ekat edoCteeL tsetnoc";

        String out = reverseWords(input);
        System.out.println(out);
        System.out.println(out.equals(output));


    }


    private static String reverseWords(String s) {
        String space = " ";
        String[] inpputArray = s.split(space);
        StringBuilder outputSb = new StringBuilder();
        for (int i = 0; i < inpputArray.length; i++) {
            StringBuilder sb = new StringBuilder();
            char[] chars = inpputArray[i].toCharArray();
            for (int j = chars.length - 1; j > -1; j--) {
                sb.append(chars[j]);
            }
            outputSb.append(sb);
            if (i != inpputArray.length - 1) {
                outputSb.append(space);
            }
        }
        return outputSb.toString();

    }

}
