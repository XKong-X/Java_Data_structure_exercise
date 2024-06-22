package test3;

/**
 * Created with IntelliJ IDEA.
 * Description: 520. 检测大写字母
 * Author: 行空XKong
 * Date: 2024-06-23
 * Time: 2:05
 * Version:
 */
class Solution {
    public boolean detectCapitalUse(String word) {
        int len = word.length();
        // 当第一个字母小写且第二个字母大写时，返回 false
        if (len >= 2 && Character.isLowerCase(word.charAt(0)) && Character.isUpperCase(word.charAt(1))) {
            return false;
        }
        // 其他字母必须与第 2 个字母的大小写相同
        for (int i = 2; i < len; ++i) {
            char ch = word.charAt(i);
            if (Character.isLowerCase(word.charAt(1)) ^ Character.isLowerCase(ch)) {
                return false;
            }
        }
        return true;
    }
}
