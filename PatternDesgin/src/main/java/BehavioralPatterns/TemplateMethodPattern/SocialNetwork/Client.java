package BehavioralPatterns.TemplateMethodPattern.SocialNetwork;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @ClassName Client
 * @Description TODO
 * @Author 彭德民
 * @Date 2022/10/23 12:08
 */

public class Client {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        NetWork netWork = null;

        System.out.println("Input user name:");
        String userName = reader.readLine();

        System.out.println("Input password:");
        String passWord = reader.readLine();

        System.out.println("Input message:");
        String message = reader.readLine();

        System.out.println("\nChoose social network for posting message.\n" + "1 - Facebook\n" + "2 - Twitter");
        int choice = Integer.parseInt(reader.readLine());

        //选择某个社交网络，然后实例化的对应的某个子类对象，利用构造函数赋值用户名和密码给这个对象
        if (choice == 1) {
            netWork = new Facebook(userName,passWord);
        }else if(choice == 2){
            netWork = new Twitter(userName, passWord);
        }

        //发送消息
        netWork.postMessage(message);
    }
}
