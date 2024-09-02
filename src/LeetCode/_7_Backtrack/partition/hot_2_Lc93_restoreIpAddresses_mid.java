package LeetCode._7_Backtrack.partition;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @Author：彭德民
 * @ClassName：_Lc93_restoreIpAddresses_mid
 * @Date：2024/9/2 15:42
 * @Description：有效 IP 地址 正好由四个整数
 * （每个整数位于 0 到 255 之间组成，且不能含有前导 0），整数之间用 '.' 分隔。
 *
 * 1、指定递归函数的参数及返回值
 * 2、递归终止条件：因为IP地址包括4段，则以添加3个'.'表示分割了四段作为终止条件
 *  （1）当有3个'.'，要判断第四段子串是否合法，若合法则说明整个结果合法，添加到res中
 * 3、单层搜索逻辑：从startIndex开始，依次判断从startIndex到end位置的子串是否合法，
 *  (1)如果startIndex到end位置的子串合法，则在sb中添加一个'.'，并递归调用本函数，看后面的串是否合法
 */

public class hot_2_Lc93_restoreIpAddresses_mid {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s=scanner.next();
        System.out.println(restoreIpAddresses(s));
    }

    public static List<String> restoreIpAddresses(String s)
    {
        //1、指定递归回溯函数的参数及返回条件
        StringBuilder sb = new StringBuilder(s);
        List<String> res = new ArrayList<>();
        if(s.length() < 4 || s.length() > 12) return res; //这里算是剪枝了

        //2、回溯函数
        restoreHepler(sb,0, 0,res);

        return res;
    }

    /**
     * @param s 输入的字符串
     * @param startIndex 当前递归的起始位置
     * @param pointNum 当前已经添加的'.'的个数
     * @param res 存储结果的集合
     */
    public static void restoreHepler(StringBuilder sb, int startIndex, int pointNum, List<String> res)
    {
        //2、明确递归终止条件
        //因为IP地址包括4段，则以添加3个'.'表示分割了四段作为终止条件
        if(pointNum == 3){
            //判断第四段子串是否合法，如果不合法那前3段子串合法也没用；若合法则说明整个结果合法，添加到res中
            //第四段子串等于从start到结束位置的子串
            if(isValidIP(sb,startIndex,sb.length()-1)){
                res.add(sb.toString());
            }
            return;
        }

        //3、开始for循环单层搜索逻辑
        for(int i = startIndex; i<sb.length();i++){
            //每次循环是以startIndex为子串开头，来判断子串合法性
            //判断子串是否合法
            if(isValidIP(sb,startIndex,i)){
                //这一段合法了，往下递归看后面的是否合法
                //使用StringBuilder就是为了在这里能方便的insert或者deleteCharAt标点符号，避免了创建新的StringBuilder
                sb.insert(i+1,'.');//先插如一个标点,如在‘113112’中i=2，则插入‘.’，变成‘113.112’
                //往后看,由于在i+1位置插入了标点，所以后面要从i+2开始看
                restoreHepler(sb,i+2,pointNum+1,res);
                //回溯，撤销刚刚放进去的标点
                sb.deleteCharAt(i+1);
            }
            else break;
        }
    }

    //判断母串sb从start到end这部分的子串是否合法
    /*
    * 1、子串多位，且开头是0，不合法
    * 2、子串数值大于255，不合法
     */
    static boolean isValidIP(StringBuilder sb, int start, int end){
        //加这一步是为了避免当整个结果还没符合要求，但遍历已经走到串末尾了
        //如10102，在1.0.102.的时候，end是7，但start走到了8
        if(start>end) return false;

        //子串有多位且首位以0开头，则不合法
        if(sb.charAt(start) == '0' && start!=end) return false;

        //将子串转为数字
        int num = 0;
        for (int i = start; i <= end; i++){
            //这种硬将字符转为数字的方法很蠢很费时
            //int singleNum = Integer.parseInt(String.valueOf(sb.charAt(i)));
            int singleNum = sb.charAt(i) - '0';
            num = num * 10 + singleNum;
            if(num>255) return false;
        }
        return true;
    }
}
