package CreationalPatterns.FactoryMethod.Test1;

/**
 * @ClassName HisenseTV
 * @Description TODO
 * @Author 彭德民
 * @Date 2022/11/1 20:47
 */

public class HisenseTV extends TV implements Cloneable{

    final static Integer COPY_MAX = 1;

    private HisenseTV hisenseTVInstance;

    //构造函数
    public HisenseTV(HisenseTV hisenseTVInstance) {
        this.hisenseTVInstance = hisenseTVInstance;
    }

    @Override
    public void play() {
        System.out.println("海信电视是这样播放视频的....");
    }

    @Override
    public TV clone() {
        Object object;
        //浅克隆
        object = clone();
        return (HisenseTV) object;
    }

    //返回一个海信电视对象的实例
    public HisenseTV getHisenseTVInstance() {
        return hisenseTVInstance;
    }
}
