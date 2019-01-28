[Letter Combinations of a Phone Number](https://leetcode.com/problems/letter-combinations-of-a-phone-number/)

**题目**

手机数字键盘的字母组合

例子:


>Input: "23"
>Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].


**思路**

开始看这道题把我整得有点懵，一直往树的方向去思考了。后来发现用```递归```的方式写是很简单的，其实也是对```递归```的考察

代码:

``` java
private Map<String, String> phone = new HashMap<String, String>() {{
        put("2", "abc");
        put("3", "def");
        put("4", "ghi");
        put("5", "jkl");
        put("6", "mno");
        put("7", "pqrs");
        put("8", "tuv");
        put("9", "wxyz");
    }};

    private List<String> output = new ArrayList<>();


    public List<String> letterCombinations(String digits) {

        if (digits.length() != 0) {
            backtrack("", digits);
        }
        return output;
    }

    private void backtrack(String combination, String nextDigits) {

        if ("".equals(nextDigits)) {
            output.add(combination);
            return;
        }
        String num = nextDigits.substring(0, 1);
        String chars = phone.get(num);
        for (int i = 0; i < chars.length(); i++) {
            String subcombination = combination + chars.substring(i, i + 1);
            backtrack(subcombination, nextDigits.substring(1));
        }


    }
```


