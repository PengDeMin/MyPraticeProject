package LeetCode._3_Hash;


import java.util.Arrays;
import java.util.List;

/**
 * @ClassName test
 * @Description TODO
 * @Author 彭德民
 * @Date 2024/5/5 16:01
 */

public class test {
    public static void main(String[] args) {
        int start = 0, end = 3, index = 0;
        String str = new String("HelloWorld");
        //看长度、空不空、相等比较、包含、替换、
        int length = str.length();
        boolean empty = str.isEmpty();
        boolean helloWorld = str.equals("HelloWorld");
        boolean s = str.contains("s");
        str.replace('l', 'h');
        //分割，返回范围[start,end-1]
        str.substring(start, end);
        //取字符
        char c = str.charAt(index);

        //字符串转数组：
        // 长度、克隆（避免java的字符串常量池）按下标遍历、相等比较、转回字符串、排序、拷贝
        char[] charArray = str.toCharArray();
        int length1 = charArray.length;
        char[] clone = charArray.clone();
        boolean equals = charArray.equals(new char[]{'2', '3'});
        String s1 = new String(charArray);
        for (int i = 0; i < length1; i++) {
            //TODO;
        }
        Arrays.sort(charArray);
        char[] chars = Arrays.copyOfRange(charArray, 0, length1);
        boolean equals1 = Arrays.equals(charArray, new char[]{'1', '2', '3'});


        //字符串转可变数据类型、长度、获取字符、设置某个位置字符、删除范围、删除某个位置、切割、添加字符、转回数组
        StringBuffer buffer = new StringBuffer(str);
        int length2 = buffer.length();
        char c1 = buffer.charAt(start);
        buffer.setCharAt(start, 'a');
        buffer.delete(start, 1);
        buffer.deleteCharAt(start);
        String substring = buffer.substring(start, end);
        buffer.append("aaa");
        String s2 = buffer.toString();

        //数组转集合
        List<String> strings = Arrays.asList(str);
        int size = strings.size();
        strings.isEmpty();
        strings.add(start, "sas");
        strings.get(1);
        strings.remove(1);
        boolean sas = strings.contains("sas");

        Integer a = new Integer(3);
        int i = a.parseInt(substring);
        int b = a;//1.5之后自动拆装箱
        int i1 = Integer.parseInt("123");
    }
}
