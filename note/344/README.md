[344. Reverse String](https://leetcode.com/problems/reverse-string/)

**题目**

反转字符串

例子:



**思路**

没啥难度，直接反向输出就是了

代码:

``` java
    public String reverseString(String s) {
        StringBuilder sb=new StringBuilder();
        char[] chars = s.toCharArray();
            for (int j = chars.length - 1; j > -1; j--) {
                sb.append(chars[j]);
            }
        return sb.toString();
    }

```



