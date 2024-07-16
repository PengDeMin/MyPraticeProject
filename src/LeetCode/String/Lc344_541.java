package LeetCode.String;

/**
 * @ClassName Lc344_541
 * @Description 344:反转字符串（简单）、
 * 541：反转字符串II(简单)
 * @Author 彭德民
 * @Date 2024/5/4 17:30
 */

public class Lc344_541 {
    public static void main(String[] args) {
        char[] s = new char[]{'h', 'e', 'l', 'l', 'o'};
        //System.out.println(reverseString(s));
        System.out.println(reverseStr("abcdefg", 9));
    }

    //344反转字符串
    public static char[] reverseString(char[] s) {
        int left = 0, right = s.length - 1;
        while (left < right) {
            //字符交换方式1
            //这种方式left<right和left<=right都可以
//            char tmp = s[left];
//            s[left++] = s[right];
//            s[right--] = tmp;

            //字符交换方式2：利用位（同0异1的异或）运算,这种方式
            //这种方式要求left<right，不能等，自己和自己异或这里有问题
            s[left] ^= s[right];
            s[right] ^= s[left];
            s[left++] ^= s[right--];
        }
        return s;
    }

    //541反转字符串II(自己做的)
    public static String reverseStr(String s, int k) {
        //1、字符串不能根据下标来赋值、改变值，如s.charAt(index) = 'a'会直接报错
        //所以将它转为数组，处理完返回结果时再讲数组转回字符串
        char[] str = s.toCharArray();
        int i = 0;
        int rightBound = 0;//右边界
        do {
            int left = 2 * k * i;
            //看到本轮时，数组所剩余元素还够不够k个，够则继续取k个置换，否则只能将就点有多少取多少
            rightBound = (left + (k - 1)) <= s.length() - 1 ? (left + (k - 1)) : s.length() - 1;
            int right = rightBound;
            while (left < right) {
                char temp = str[left];
                str[left++] = str[right];
                str[right--] = temp;
            }
            i++;
        } while (rightBound < s.length() - 1);//如果本轮置换的右边界已经碰到数组末尾了，就该停止了

        //千万不能用str.tostring(),这个方法返回的是char[]的类名等信息;
        return new String(str);
    }

    //541反转字符串II(别人的优化版本)
    public static String reverseStr2(String s, int k) {
        char[] str = s.toCharArray();
        for (int i = 0; i < str.length; i += 2 * k) {
            int start = i;
            int end = Math.min(start + k - 1, str.length);
            while (start < end) {
                char temp = str[start];
                str[start++] = str[end];
                str[end--] = temp;
            }
        }
        return new String(str);
    }
}

