[Longest Common Prefix](https://leetcode.com/problems/longest-common-prefix/)

**题目**

判断回文数字

例子:

>Input: ["flower","flow","flight"]
>Output: "fl"

>Input: ["dog","racecar","car"]
>Output: ""


**思路**

使用第一个字符串作为子串，匹配后面的主串。注意判断为空的情况和字串比主串长的情况

代码:

``` java
    public String longestCommonPrefix(String[] strs) {
        if (strs.length < 1) {
            return "";
        }
        String result = "";
        for (int i = 0; i < strs[0].length(); i++) {
            char c = strs[0].charAt(i);
            for (int j = 1; j < strs.length; j++) {
                if (i>strs[j].length()-1||strs[j].charAt(i) != c) {
                    return result;
                }
            }
            result += c;
        }

        return result;
    }
```


