package LeetCode.String;

/**
 * @ClassName youxuanStr
 * @Description 右旋字符串
 * @Author 彭德民
 * @Date 2024/5/5 15:37
 */

public class youxuanStr {
    public static void main(String[] args) {
        System.out.println(youxuan("abcdefg", 9));
    }

    /**
     * 字符串的右旋转操作是把字符串尾部的若干个字符转移到字符串的前面。
     * 给定一个字符串 s 和一个正整数 k，请编写一个函数，
     * 将字符串中的后面 k 个字符移到字符串的前面，实现字符串的右旋转操作。
     */
    public static String youxuan(String s,int k){
        if(k<=0){
            return s;
        }
        //先整体反转
        StringBuilder sb = new StringBuilder(s);
        reverse(sb,0,s.length()-1);
        //再局部反转,如果反转要求大于字符串长度，相当于整体反转，那上一步任务已经完成，就不进入if了
        if(k<s.length()){
            //局部反转前段
            reverse(sb,0,k-1);
            //局部反转后段
            reverse(sb,k,sb.length()-1);
        }
        return sb.toString();
    }

    /**
     * @param sb :给定串
     * @param start：反转开始位置
     * @param end：反转结束位置 mn
     * */
    public static void reverse(StringBuilder sb ,int start,int end){
        while(start<end){
            char temp = sb.charAt(start);
            sb.setCharAt(start++,sb.charAt(end));
            sb.setCharAt(end--,temp);
        }
    }
}
