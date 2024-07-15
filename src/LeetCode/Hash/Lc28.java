package LeetCode.Hash;

/**
 * @ClassName Lc28
 * @Description 找出字符串中第一个匹配项的下标(简单) 滑动窗口法和KMP法
 * @Author 彭德民
 * @Date 2024/5/5 17:22
 */

public class Lc28 {
    public static void main(String[] args) {
        String haystack = "sadbutsad";
        String needle = "sad";
        System.out.println(strStrKMP(haystack, needle));
    }

    //方法一：滑动窗口方法(时间复杂度跟暴力解法一样的，没什么区别)
    public static int strStrHua(String haystack, String needle) {
        //TODO;
        return -1;
    }

    //暴力方法
    public static int strStrBaoLi(String haystack, String needle) {
        int hLen = haystack.length(),nLen = needle.length();
        char[] hStr = haystack.toCharArray();
        char[] nStr = needle.toCharArray();

        for(int hIndex = 0; hIndex < hLen-nLen+1; hIndex++) {
            int start = hIndex;
            int nIndex = 0;
            while(nIndex<nLen && hStr[start]==nStr[nIndex]){
                start++;
                nIndex++;
            }
            if(nIndex == nLen){
                return hIndex;
            }
        }
        return -1;
    }

    //KMP方法
    public static int strStrKMP(String haystack, String needle) {
        if(needle.length() ==0){
            return 0;
        }
        int[] next = new int[needle.length()];
        //1、搞定模式串的next数组，也就是前缀表
        getNext(next,needle);

        //2、利用next数组辅助匹配
        int nIndex= 0;
        //iIndex其实是记录整个主串的索引位置
        for (int iIndex=0; iIndex<haystack.length();iIndex++) {
            //如果字符匹配不上
            while(nIndex>0 && haystack.charAt(iIndex)!= needle.charAt(nIndex)){
                //则查询next数组，获取应该重新开始比较的位置
                nIndex = next[nIndex-1];
            }
            //如果字符匹配上了，双方开开心心都忘后移动
            if(haystack.charAt(iIndex)== needle.charAt(nIndex)){
                nIndex++;
            }
            //如果已经匹配到模式串末尾了，说明匹配上了
            //根据此时主串的末尾索引位置，找到并返回其开头位置
            if(nIndex == needle.length()){
                return iIndex-needle.length()+1;
            }
        }
        return -1;
    }

    //重难点就是这个next数组的获取
    private static void getNext(int[] next, String needle) {
        //指向前缀末尾位置，也代表了i及i之前最长公共前后缀的长度
        int j  = 0;//代表的是某个位置不匹配时应该返回重新开始匹配的模式串位置
        next[0] = 0;//初始化数组首位，也代表了在首位就应该回退到首位
        //i指向后缀末尾位置
        for(int i = 1;i<needle.length();i++) {
            //若前后缀匹配不上
            //1、增加判断j>0是为了让最多就回退到初始位置，也就是0的位置，防止因为j<0而越界
            //2、设置成while是可能会出现连续回退的情况，也就是退到那个位置后，那个位置的字符与i处
            //字符仍然不等，那就是说明还继续需要回退
            while(j>0 && needle.charAt(j)!= needle.charAt(i)){
                //则应该回退到前一位的next值的位置
                j = next[j-1];
            }
            //若前后缀对应上了，则前后缀长度+1
            if(needle.charAt(j)== needle.charAt(i)){
                j++;
            }
            //给相应位置赋值，这个值不仅是不等要回退到的位置，也是i及i之前的最长公共前后缀长度
            next[i] = j;
        }
    }
}
