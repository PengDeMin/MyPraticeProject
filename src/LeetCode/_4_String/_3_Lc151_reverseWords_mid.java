package LeetCode._4_String;


import java.util.Arrays;

/**
 * @ClassName Lc151
 * @Description 翻转字符串里的单词（中等）
 * @Author 彭德民
 * @Date 2024/5/4 20:09
 */

public class _3_Lc151_reverseWords_mid {
    public static void main(String[] args) {
        System.out.println(reverseWords2(" 3c      2zPeO dpIMVv2SG    1AM       o       VnUhxK a5YKNyuG     x9    EQ  ruJO       0Dtb8qG91w 1rT3zH F0m n G wU"));
    }

    //自己按照直面思想做的版本，还是边调试边找问题才做对的，而且用时和内存都不占优，用了四个指针
    public static String reverseWords(String s) {
        //单只有一个单词且就一个字母的，直接返回
        if (s.length() == 1) {
            return s;
        }
        char[] str = s.toCharArray();
        int leftStart = 0, leftEnd = 0, rightStart = 0, rightEnd = str.length - 1;
        String leftStr = "";
        String rightStr = "";
        while (leftStart < rightEnd) {
            //1.1找左边单词开头
            while (str[leftStart] == ' ') {
                ++leftStart;
            }
            //1.2找左边单词结尾(单词可能只有一个字母)
            if (leftStart > rightEnd) {
                break;
            }
            leftEnd = leftStart;
            while (leftEnd < str.length && str[leftEnd] != ' ') {
                ++leftEnd;
            }
            //1.3确定左边单词并添加进右半边字符串
            //注意subtring(left, right)返回的子字符串下标范围是[left, right-1]
            rightStr = s.substring(leftStart, leftEnd) + " " + rightStr;
            //更新左边单词寻找索引
            leftStart = leftEnd;

            //2.1找右边单词结尾
            while (str[rightEnd] == ' ' && leftEnd < rightEnd) {
                --rightEnd;
            }
            //2.2找右边单词开头
            rightStart = rightEnd;
            while (str[rightStart] != ' ' && leftEnd < rightStart) {
                --rightStart;
            }
            //3.3确定右边单词并加进左半边字符串,要增加判断上面的右边单词循环结束到第有没有找到有效的单词
            if (leftEnd < rightEnd) {
                leftStr = leftStr + " " + s.substring(rightStart + 1, rightEnd + 1);
                //更新右边单词寻找索引
                rightEnd = rightStart;
            }
        }
        //要看leftstr是否为空，因为如果只有一个单词，则会被rightStr收录到，导致leftstr为空
        if (!leftStr.isEmpty()) {
            //去除首尾的空格
            return leftStr.substring(1) + " " + rightStr.substring(0, rightStr.length() - 1);
        } else {
            return rightStr.substring(0, rightStr.length() - 1);
        }
    }

    /**
     * 版本2：双指针，切用套路
     * <p>
     * 1.去除首尾以及中间多余空格
     * 2.反转整个字符串
     * 3.反转各个单词
     */
    public static String reverseWords2(String s) {
        // 1.去除首尾以及中间多余空格
        StringBuilder sb = removeSpace(s);
        // 2.反转整个字符串
        reverseString(sb, 0, sb.length() - 1);
        // 3.反转各个单词
        reverseEachWord(sb);
        //return sb.toString();

        char[] abb = new char[]{'1', '2', '3', '4', '5', '6', '7', '8', '9', '0'};
        return new String(Arrays.copyOfRange(abb,1,4));
    }

    private static StringBuilder removeSpace(String s) {
        int start = 0;
        int end = s.length() - 1;
        //跳过首尾的空格
        while (s.charAt(start) == ' ') {
            start++;
        }
        while (s.charAt(end) == ' ') {
            end--;
        }
        StringBuilder sb = new StringBuilder();
        while (start <= end) {
            char c = s.charAt(start);
            //要么当前字符不是空格，要么当前字符是空格且刚才放进去的不是空格（它是有效空格）
            // 否则若当前字符是空格且前一个字符也是空格（他是多余的空格）则丢弃
            if (c != ' ' || sb.charAt(sb.length() - 1) != ' ') {
                sb.append(c);
            }
            start++;
        }
        // System.out.println("ReverseWords.removeSpace returned: sb = [" + sb + "]");
        return sb;
    }

    /**
     * 反转字符串指定区间[start, end]的字符
     */
    public static void reverseString(StringBuilder sb, int start, int end) {
        // System.out.println("ReverseWords.reverseString() called with: sb = [" + sb + "], start = [" + start + "], end = [" + end + "]");
        while (start < end) {
            char temp = sb.charAt(start);
            sb.setCharAt(start, sb.charAt(end));
            sb.setCharAt(end, temp);
            start++;
            end--;
        }
        // System.out.println("ReverseWords.reverseString returned: sb = [" + sb + "]");
    }

    private static void reverseEachWord(StringBuilder sb) {
        int start = 0;
        int end = 1;
        int n = sb.length();
        while (start < n) {
            while (end < n && sb.charAt(end) != ' ') {
                end++;
            }
            reverseString(sb, start, end - 1);
            start = end + 1;
            end = start + 1;
        }
    }
}
