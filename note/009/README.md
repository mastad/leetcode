[Palindrome Number](https://leetcode.com/problems/palindrome-number/)

**题目**

判断回文数字

例子:

>Input: 121
>Output: true

>Input: 10
>Output: false

>Input: -121
>Output: false



**思路1**

使用 String 解决问题

代码:

``` java
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }

        if (x < 10) {
            return true;
        }

        String xs = String.valueOf(x);

        int i = 0;
        int j = xs.length() - 1;

        while (i < xs.length() / 2) {
            if (xs.charAt(i) != xs.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }

        return true;
    }
```

**思路2**

不使用 String 解决

