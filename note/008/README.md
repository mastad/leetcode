[String to Integer (atoi)](https://leetcode.com/problems/string-to-integer-atoi/)

**题目**

转化字符串为数字，字符串中不仅有数字还有字母和空格。

例子:

>Input: "42"
>Output: 42

>Input: "   -42"
>Output: -42

>Input: "4193 with words"
>Output: 4193

>Input: "words and 987"
>Output: 0

>Input: "-91283472332"
>Output: -2147483648

**思路**

本题考察的重点是代码的鲁棒性，对特殊情况的处理，如包含空格、首字母为```+/— ```、包含字母。当然处理整型时一定要考虑整型的取值范围。读题是关键

代码:

``` java
public int myAtoi(String str) {


        int digit = 1;
        int total = 0;
        int i = 0;

        if (str == null || str.isEmpty() || str.length() == 0) {
            return total;
        }


        char[] chars = str.toCharArray();
      
        while (i < str.length() && chars[i] == ' ') {
            i++;
        }

        if (i >= str.length()) {
            return total;
        }

        if (chars[i] == '+') {
            i += 1;
        } else if (chars[i] == '-') {
            i += 1;
            digit = -1;
        }


        for (; i < chars.length; i++) {
            int d = chars[i] - '0';
            if (d < 0 || d > 9) {
                break;
            }

            if (digit == 1) {
                if (total > Integer.MAX_VALUE / 10 || (total == Integer.MAX_VALUE / 10 && d > 7)) {
                    return Integer.MAX_VALUE;
                }
            } else {
                if (total > Integer.MAX_VALUE / 10 || (total == Integer.MAX_VALUE / 10 && d > 8)) {
                    return Integer.MIN_VALUE;
                }
            }
            total = 10 * total + d;
        }
        return total * digit;
    }
```



