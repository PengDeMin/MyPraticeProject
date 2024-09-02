package LeetCode._4_String;

/**
 * @Author：彭德民
 * @ClassName：test
 * @Date：2024/8/30 20:41
 * @Description：TODO
 */

public class test {
    public static void main(String[] args) {
        repeatedSubstringPattern(new String("aabaaba"));
    }

    private static boolean repeatedSubstringPattern(String s) {

        char[] tempStr =  s.toCharArray();
        //若存在，则先找子串，若构成重复，子串最大长度为母串的一半
        for(int i = 1; i<=s.length()/2; i++){
            //1、确定一个假定子串
            String subStr = s.substring(0,i);
            //2、计算子串的next数组
            // int[] next = getNext(subStr,new int[i]);
            //3、将子串和母串对比
            if(compare(s,subStr)){
                return true;
            }
        }
        //如果走出循环，说明一次也没匹配到
        return false;

    }

    private static boolean compare(String s, String subStr){

        int i = 0;
        int subIndex = 0;
        while(i<s.length()){
            subIndex = 0;
            while(subIndex<subStr.length() && i<s.length()){
                if(s.charAt(i) != subStr.charAt(subIndex)){
                    return false;
                }
                subIndex++;
                i++;
            }
        }
        if(subIndex != subStr.length()){
            return false;
        }
        return true;

    }
}
