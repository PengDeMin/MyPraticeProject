package ProxyTest;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @ClassName ProxyUtil
 * @Description 代理工具类，创建一个代理对象并返回
 * @Author 彭德民
 * @Date 2024/4/25 16:51
 */

public class ProxyUtil {
    public static Star createProxy(BigStar bigStar){
//        ClassLoader loader：指定一个类的加载器
//        Class<?>[] interfaces:指定生成的代理长什么样子，有哪些方法
//        InvocationHandler h:指定生成的代理对象要干什么事情
        //创建代理
        Star startProxy = (Star)Proxy.newProxyInstance(ProxyUtil.class.getClassLoader(),
                new Class[]{Star.class}, new InvocationHandler() {
                    //学习代理的重点方法，也是一个回调方法
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        //代理对象要干的事情
                        if(method.getName().equals("sing")){
                            System.out.println("代理去准备话筒，收钱");
                        }else if(method.getName().equals("dance")){
                            System.out.println("代理准备服装，收钱");
                        }
                        //让真正的对象（明星）去干这事，args是干事情的具体参数
                        //并且要将结果返回
                        return method.invoke(bigStar,args);
                    }
                });
        //返回代理
        return startProxy;
    }
}
