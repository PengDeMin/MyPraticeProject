package LeetCode._3_Hash;

/**
 * @ClassName Lc383
 * @Description 赎金信（简单）
 * @Author 彭德民 ransomNote 和 magazine ，判断 ransomNote 能不能由 magazine 里面的字符构成。
 * @Date 2024/5/3 13:14
 */

public class _4_Lc383_canConstruct_easy {
    public static void main(String[] args) {
        String ransomNote = "aa";
        String magazine = "ab";
        System.out.println(canConstruct(ransomNote, magazine));
    }

    public static boolean canConstruct(String ransomNote, String magazine) {
        int[] freRecord = new int[26];
        //1、记录magazine串的字符及频数，相当于计算能给的赎金大小，在凑钱
        for (int i = 0; i < magazine.length(); i++) {
            ++freRecord[magazine.charAt(i) - 'a'];
        }
        //2、记录ransomNote串消耗的字符及频数，相当于从赎金从拿掉钱，花钱
        for (int i = 0; i < ransomNote.length(); i++) {
            --freRecord[ransomNote.charAt(i) - 'a'];
        }
        //3、看一开始准备的钱有没有盈余
        for (int i : freRecord) {
            //有哪个字母的频数为负，说明要拿的比准备的多，钱不够
            if (i < 0) {
                return false;
            }
        }
        return true;
    }
}
