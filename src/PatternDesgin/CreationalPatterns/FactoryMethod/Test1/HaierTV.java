package CreationalPatterns.FactoryMethod.Test1;

/**
 * @ClassName Haier
 * @Description TODO
 * @Author 彭德民
 * @Date 2022/11/1 20:42
 */

public class HaierTV extends TV {

    final static Integer COPY_MAX = 1;
    private HaierTV haierTVinstance;

    //构造函数
    public HaierTV(HaierTV haierTVinstance) {
        this.haierTVinstance = haierTVinstance;
    }

    @Override
    public void play() {
        System.out.println("海尔电视是这样播放视频的....");
    }

    @Override
    public TV clone() {
        Object object;
        //浅克隆
        object = clone();
        return (HaierTV) object;
    }

    //返回一个海尔电视对象的实例
    public HaierTV getHaierTVInstance() {
        return haierTVinstance;
    }

}
