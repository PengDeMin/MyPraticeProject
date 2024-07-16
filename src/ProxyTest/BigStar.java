package ProxyTest;

/**
 * @ClassName BigSATR
 * @Description TODO
 * @Author 彭德民
 * @Date 2024/4/25 16:49
 */

public class BigStar implements Star {
    private String name;

    public BigStar(String name) {
        this.name = name;
    }

    //明星对象自己该做的事
    @Override
    public String sing(String songName) {
        System.out.println(name + "正在唱歌：" + songName);
        return "谢谢谢谢！";
    }

    @Override
    public void dance() {
        System.out.println(name + "正在优美地跳舞");
    }
}
