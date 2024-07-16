package PatternDesgin.CreationalPatterns.FactoryMethod.CreateHuman;

/**
 * @ClassName Human
 * @Description 人类接口
 * @Author 彭德民
 * @Date 2022/10/23 19:38
 */
public interface Human {
    //每个人种的皮肤都有相应的颜色
    public void getColor();

    //人类会说话
    public void talk();

}
