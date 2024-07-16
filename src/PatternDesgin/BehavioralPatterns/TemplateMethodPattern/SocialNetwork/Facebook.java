package PatternDesgin.BehavioralPatterns.TemplateMethodPattern.SocialNetwork;

/**
 * @ClassName Facebook
 * @Description TODO
 * @Author 彭德民
 * @Date 2022/10/23 11:41
 */

public class Facebook extends NetWork {

    public Facebook(String username, String password) {
        this.userName = username;
        this.passWord = password;
    }

    /**
     * @return boolean
     * @Description:模仿登录过程
     * @Param
     **/
    @Override
    boolean logIn(String userName, String passWord) {
        System.out.println("\nChecking user's parameters");
        System.out.println("Name: " + this.userName);
        System.out.print("Password: ");

        for (int i = 0; i < this.passWord.length(); i++) {
            System.out.println("*");
        }

        simulateNetworkLatency();
        System.out.println("\n\nLogIn success on Facebook");
        return false;
    }

    /***
     * @Description:模拟发送数据
     * @Param
     * @return boolean
     **/
    @Override
    boolean sendData(byte[] data) {
        boolean messagePosted = true;
        if (messagePosted) {
            System.out.println("Message: '" + new String(data) + "' was posted on Facebook");
            return true;
        } else {
            return false;
        }
    }

    /***
     * @Description:模拟退出
     * @Param
     * @return void
     **/
    @Override
    void logOut() {
        System.out.println("User: '" + userName + "' was logged out from Facebook");
    }

    /**
     * @return void
     * @Description:模拟消息传输时的网络延迟
     * @Param
     **/
    private void simulateNetworkLatency() {
        try {
            int i = 0;
            System.out.println();
            while (i < 10) {
                System.out.println(".");
                Thread.sleep(500);
                i++;
            }
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }
}
