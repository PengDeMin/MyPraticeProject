package LeetCode;


import java.util.Scanner;

/**
 * @ClassName DJI0817
 * @Author Demin Peng
 * @Date 2024/8/18 19:54
 * @Description TODO
 */

public class DJI0817 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] strArrays = sc.nextLine().split(",");
        StringBuilder res = new StringBuilder();
        res.append("[");

        for (String str : strArrays) {
            //编写表达式去除字符串中的括号、逗号和引号
            str = str.replaceAll("[\\[\\]\\,\']", "");
            str = str.replaceAll(" ", "");
            System.out.println(str);

            //取文件名
            String[] subStr = str.split("_v");
            String name = subStr[0];
            //取版本号和文件类型
            String[] subStr2 = subStr[1].split("\\.");
            String version;
            String type;
            if(subStr2.length == 2){
                version = subStr2[0];
                type = subStr2[1];
            }else {
                version = "'0";
                type = subStr2[0];

            }
            String resStr =  "('" + name + "','" + type + "','" + version + "),";
            res.append(resStr);


            //[('file', 'txt', 1), ('file', 'txt', 2)]
            //System.out.println(name + " " + version + " " + type);
            //System.out.println(resStr);
        }
        res = new StringBuilder(res.substring(0, res.length()-1));
        res.append("]");
        System.out.println(res.toString());
    }
}
