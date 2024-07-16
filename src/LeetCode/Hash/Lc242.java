package LeetCode.Hash;

/**
 * @ClassName Lc242
 * @Description 有效的字母异位词(中等)
 * @Author 彭德民
 * @Date 2024/5/2 15:35
 */

public class Lc242 {
    public static void main(String[] args) {
        //题目说了s和t仅包含小写字母
        String s = "aeeesqer";
        String t = "eeeaqers";
        System.out.println(isAnagram(s, t));
    }

    public static boolean isAnagram(String s, String t) {
        //1、创建一个长度为26的数组，记录每个字母的频数，刚好有26个字母
        //基本类型的默认值为0
        int[] freRecord = new int[26];

        //2、处理s字符串中每个字母的频数,往上加
        for (int i = 0; i < s.length(); i++) {
            //charAt(int index):从字符串中根据索引下标取单个字符
            //s.charAt(i)-'a':某个字符相对于‘a’的ascii码差值
            freRecord[s.charAt(i) - 'a']++;
        }
        //3、处理t字符串中每个字母的频数,往下减
        for (int i = 0; i < t.length(); i++) {
            freRecord[t.charAt(i) - 'a']--;
        }
        //4、最后全归于0则频数相等，否则不等
        for (int i : freRecord) {
            if (i != 0) {
                return false;
            }
        }
        return true;
    }
}
