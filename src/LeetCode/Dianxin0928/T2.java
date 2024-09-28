package LeetCode.Dianxin0928;

/**
 * @ClassName T2
 * @Author Demin Peng
 * @Date 2024/9/28 10:12
 * @Description TODO
 */

public class T2 {
    public static void main(String[] args) {
        System.out.println(repeatString("abc", 2, 5));
    }

    public static String repeatString (String S, long l, long r) {
        //如果S为空，返回null
        if (S.length() == 0) return null;
        StringBuilder sb = new StringBuilder(S);
        StringBuilder newSb = new StringBuilder(sb);

        String s = S;
        //当sb不为空时，持续除去它的第一个字符，并结果拼接到newSb后面
        //如果在外层循环直接用一个StringBuilder，在循环里不断append会导致堆溢出
        //因此要每次都创建一个新的StringBuilder
        while (sb.length() != 0) {
            StringBuilder tmp = new StringBuilder(s);
            sb.deleteCharAt(0);
            s = tmp.append(sb).toString();
        }

        //返回从l到r的字符串
        return s.substring((int) l - 1, (int) r);
    }
}
