package LeetCode.Dianxin0928;

/**
 * @ClassName T1
 * @Author Demin Peng
 * @Date 2024/9/28 10:02
 * @Description TODO
 */

public class T1 {
    public static void main(String[] args) {
        int res = binary_fill(18);
        System.out.println(res);
    }


    public static int binary_fill (int n) {

        String binary = Integer.toBinaryString(n);
        StringBuilder sb = new StringBuilder(binary);

        for (int i = 0; i < sb.length(); i++) {
            if (sb.charAt(i) == '0') {
                int j = i + 1;
                while (j < sb.length() && sb.charAt(j) == '0') {
                    j++;
                }
                if (j < sb.length() && sb.charAt(j) == '1') {
                    sb.setCharAt(i, '1');
                }
            }
        }

        return Integer.parseInt(sb.toString(), 2);
    }
}
