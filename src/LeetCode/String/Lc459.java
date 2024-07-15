package LeetCode.String;

/**
 * @ClassName Lc459
 * @Description 重复的子字符串(套路题)
 * 给定一个非空的字符串 s ，检查是否可以通过由它的一个子串重复多次构成
 * @Author 彭德民
 * @Date 2024/5/6 11:03
 */

public class Lc459 {
    public static void main(String[] args) {
        Boolean res = repSubstringKMP("aabaaba");
        System.out.println(res);
    }


    //枚举法,关键在于知道应该在什么区间内枚举，时间复杂度n^2
    public static boolean repSubstringEnum(String s) {
        int motLen = s.length();
        //枚举重复子串的长度,最大可能是sLen/2,因为至少要重复一次
        //也就是由两个子串构成母串
        for(int subLen = 1; subLen*2 <= motLen; subLen++){
            //也不是什么样的subLen都枚举，即母串必须是此轮假设子串长度的倍数
            if(motLen % subLen==0){
                //每轮枚举前都要设置
                boolean match = true;
                int valid= 0;
                for (int j = subLen; j< motLen;j++){
                    //一旦某轮枚举失败，则退出
                    if(s.charAt(j) != s.charAt(j-subLen)){
                        match = false;
                        break;
                    }
                }
                if(match){
                    return true;
                }
            }
        }
        return false;
    }

    //组装法，思想也很巧妙
    public static boolean repSubstringAssemble(String s) {
        if(s.isEmpty()||s.length()==1){
            return false;
        }
        String bigStr = s+s;
        return bigStr.substring(1,bigStr.length()-1).contains(s);
    }

    //KMP思想
    public static boolean repSubstringKMP(String s) {
        if(s.isEmpty()||s.length()==1){
            return false;
        }

        //1、搞定next数组
        int sLen = s.length();
        int[] next = new int[sLen];
        getNext(s,next);

        //2、利用next数组
        //next[i]也代表了[s[0],s[i]]这段范围串的最长公共前后缀长度
        //（1）next[sLen-1] !=0意味着[s[0],s[len-1]]是存在公共前后缀的，即长度不为0
        //并且next[sLen-1]就是这个最长公共前后缀的长度
        //（2）因此slen-next[sLen-1]=最小重复子串的长度
        if(next[sLen-1] !=0 && sLen % (sLen-next[sLen-1]) == 0){
            return true;
        }
        return false;
    }

    public static void getNext(String s, int[] next) {
        int j = 0;
        next[0]=0;
        for (int i = 1; i < s.length(); i++){
            while(j>0 && s.charAt(j)!=s.charAt(i)){
                j = next[j-1];
            }
            if(s.charAt(j) == s.charAt(i)){
                j++;
            }
            next[i] = j;
        }
    }
}
