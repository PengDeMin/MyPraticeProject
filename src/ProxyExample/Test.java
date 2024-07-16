package ProxyExample;

import java.util.Arrays;

/**
 * @ClassName Test
 * @Description TODO
 * @Author 彭德民
 * @Date 2024/4/25 18:23
 */

public class Test {

    public static void main(String[] args) throws Exception {
        UserService userService = UserProxyUtil.createProxy(new UserServiceImpl());

        userService.login("admin", "123456");
        System.out.println("-------------------");

        userService.deleteUser();
        System.out.println("-------------------");

        String[] names = userService.selectUser();
        System.out.println("查询到的用户是：" + Arrays.toString(names));
        System.out.println("-------------------");


    }

}
