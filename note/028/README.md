[Implement strStr()](https://leetcode.com/problems/implement-strstr/)

**题目**

查找模串的下标位置

例子:


>Input: haystack = "hello", needle = "ll"
>Output: 2

>Input: haystack = "aaaaa", needle = "bba"
>Output: -1


**思路1**

BF,字符串匹配是算法中的经典，思路之一就是暴力匹配算法（Brute Force），我觉得这种算法的好处是简单。很多时候在工作中选择算法，因为考虑到维护的问题，最好选择简单的算法。毕竟计算得慢不算 BUG 嘛。

代码:

``` java
    public int strStr(String haystack, String needle) {
        char[] mainchars = haystack.toCharArray();
        char[] pchars = needle.toCharArray();

        if (pchars.length == 0 || haystack.equals(needle)) {
            return 0;
        }

        for (int i = 0; i <= mainchars.length - pchars.length; i++) {

            if (mainchars[i] == pchars[0]) {
                if (pchars.length == 1) {
                    return i;
                } else {
                    for (int j = 0; j < pchars.length; j++) {
                        if (mainchars[i + j] != pchars[j]) {
                            break;
                        } else {
                            if (j == pchars.length - 1) {
                                return i;
                            }
                        }
                    }
                }
            }

        }


        return -1;
    }
```


