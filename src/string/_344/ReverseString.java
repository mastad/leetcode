package string._344;

import static sun.misc.Version.println;

/**
 * Created by reiserx on 2017/11/27.
 * 颠倒字符串
 */
public class ReverseString {

    public static void main(String[] args) {
        System.out.println(reverseString("hello"));
        System.out.println(reverseString2("hello"));

    }


    public static String reverseString(String s) {
        StringBuilder sb = new StringBuilder();
        char[] chars = s.toCharArray();
        for (int j = chars.length - 1; j > -1; j--) {
            sb.append(chars[j]);
        }
        return sb.toString();
    }

    public static String reverseString2(String s) {
        return new StringBuilder(s).reverse().toString();
    }
}
