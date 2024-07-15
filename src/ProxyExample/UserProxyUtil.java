package ProxyExample;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @ClassName ProxyUtil
 * @Description TODO
 * @Author 彭德民
 * @Date 2024/4/25 18:24
 */

public class UserProxyUtil {
    public static UserService createProxy(UserServiceImpl userServiceImp){
        UserService userServiceProxy = (UserService)Proxy.newProxyInstance(UserProxyUtil.class.getClassLoader(),
                new Class[]{UserService.class}, new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        if(method.getName().equals("login") || method.getName().equals("deleteUser") || method.getName().equals("selectUser")){
                            //代理要干的事情，统计执行时间
                            long loginTime = System.currentTimeMillis();

                            //userService是真正的业务对象，由他执行真正的方法
                            Object rs = method.invoke(userServiceImp,args);

                            long endTime = System.currentTimeMillis();
                            System.out.println(method.getName()+ "方法耗时"+(endTime-loginTime)/1000+"秒");
                            return rs;
                        }else{
                            Object rs = method.invoke(userServiceImp,args);
                            return rs;
                        }
                    }
                });
        return userServiceProxy;
    }
}
