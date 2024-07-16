package BehavioralPatterns.TemplateMethodPattern.SocialNetwork;

import java.nio.charset.StandardCharsets;

/**
 * @ClassName Net
 * @Description 基础社交网络模板类
 * @Author 彭德民
 * @Date 2022/10/23 11:36
 */

public abstract class NetWork {

    String userName;
    String passWord;

    abstract boolean logIn(String username, String password);

    abstract boolean sendData(byte[] message);

    abstract void logOut();

    public boolean postMessage(String message) {
        if (logIn(this.userName, this.passWord)) {
            //真正执行时是哪个子类的实例化对象则调用对应重写的方法逻辑
            boolean result = sendData(message.getBytes(StandardCharsets.UTF_8));
            logOut();
            return result;
        }
        return false;
    }

}
