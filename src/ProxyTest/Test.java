package ProxyTest;

/**
 * @ClassName Test
 * @Description TODO
 * @Author 彭德民
 * @Date 2024/4/25 17:01
 */

public class Test {
    public static void main(String[] args) {
        //创建明星
        BigStar s = new BigStar("杨超越");
        //为明星创建代理对象
        Star starProxy = ProxyUtil.createProxy(s);
        //通过代理对象去执行唱歌和跳舞
        String rs = starProxy.sing("好日子");
        System.out.println(rs);
        starProxy.dance();

        //或者直接创建代理对象，并指定其明星
        Star sp = ProxyUtil.createProxy(new BigStar("民哥"));
        System.out.println(sp.sing("大好山河"));
        sp.dance();
    }
}
