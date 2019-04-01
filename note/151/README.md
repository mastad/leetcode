[151. Reverse Words in a String](https://leetcode.com/problems/reverse-words-in-a-string/)

**题目**

反转字符串中的单词顺序

例子

> Input: "the sky is blue"
>
> Output: "blue is sky the"

> Input: "  hello world!  "
>
> Output: "world! hello"

> Input: "a good   example"
>
> Output: "example good a"

**思路**

见代码

代码：

``` java
    public String reverseWords(String s) {
        String[] words = s.split(" ");
        StringBuilder sb = new StringBuilder();

        for (int i = words.length - 1; i >= 0; i--) {

            if (!"".equals(words[i].trim())) {
                sb.append(words[i]).append(" ");
            }
        }
        if (sb.length() == 0) {
            return sb.toString();
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }
```
