package BehavioralPatterns.TemplateMethodPattern.Car;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @ClassName Client
 * @Description TODO
 * @Author 彭德民
 * @Date 2022/10/22 17:00
 */

public class Client {

    public static void main(String[] args) throws IOException {
        System.out.println("-------H1型号悍马--------");
        System.out.println("H1型号的悍马是否需要喇叭声响？0-不需要 1-需要");
        String type = (new BufferedReader(new InputStreamReader(System.in))).readLine();

        HummerH1 h1 = new HummerH1();
        if (type.equals("0")) {
            h1.setAlarm(false);
        }
        h1.run();

        System.out.println("\n-------H2型号悍马--------");
        HummerH2 h2 = new HummerH2();
        h2.run();

    }
}
