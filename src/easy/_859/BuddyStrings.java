package easy._859;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by reiserx on 2018/7/9.
 */
public class BuddyStrings {

    public static void main(String[] args) {

        System.out.println(buddyStrings("abbbccb", "cbbbabc"));
        System.out.println(buddyStrings("abab", "abab"));

    }

    public static boolean buddyStrings(String A, String B) {

        int length = A.length();

        if (length != B.length()) {
            return false;
        }

        if (length < 2) {
            return false;
        }

        char[] a = A.toCharArray();

        if (A.equals(B)) {
            Set<Character> set = new HashSet<>();
            for (Character c : a) {
                set.add(c);
            }
            return set.size() != length;
        }
        char[] b = B.toCharArray();

        List<Integer> dif = new ArrayList<>();

        for (int i = 0; i < length; i++) {
            if (a[i] != b[i]) {
                dif.add(i);
            }
        }
        return dif.size() == 2 && a[dif.get(0)] == b[dif.get(1)] && a[dif.get(1)] == b[dif.get(0)];
    }
}
