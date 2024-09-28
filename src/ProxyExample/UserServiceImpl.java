package ProxyExample;

/**
 * @ClassName UserServiceImpl
 * @Description 以下每个业务逻辑中都有公共的记录执行时间代码，直接注释掉，通过代理模式去做这种杂活
 * 实现接口的目标类
 * @Author 彭德民
 * @Date 2024/4/25 17:27
 */

public class UserServiceImpl implements UserService {
    @Override
    public void login(String username, String password) throws Exception {
        //long loginTime = System.currentTimeMillis();
        if ("admin".equals(username) && "123456".equals(password)) {
            System.out.println("登录成功了捏");
        } else {
            System.out.println("登录失败，用户名或者密码错误");
        }
        Thread.sleep(1000);
//        long endTime = System.currentTimeMillis();
//        System.out.println("登录方法耗时"+(endTime-loginTime)/1000+"秒");
    }

    @Override
    public void deleteUser() throws Exception {
//        long loginTime = System.currentTimeMillis();

        System.out.println("已经删除了一万个用户");
        Thread.sleep(1000);

//        long endTime = System.currentTimeMillis();
//        System.out.println("删除用户方法耗时"+(endTime-loginTime)/1000+"秒");
    }

    @Override
    public String[] selectUser() throws Exception {
//        long loginTime = System.currentTimeMillis();

        System.out.println("已经查询出3个用户");
        String[] names = {"王二狗", "张全蛋", "牛爱华"};
        Thread.sleep(1000);

//        long endTime = System.currentTimeMillis();
//        System.out.println("查询用户方法耗时"+(endTime-loginTime)/1000+"秒");
        return names;
    }
}
