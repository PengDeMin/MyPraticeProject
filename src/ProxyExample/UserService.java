package ProxyExample;

/**
 * @ClassName UserService
 * @Description TODO
 * @Author 彭德民
 * @Date 2024/4/25 17:25
 */
public interface UserService {

    void login(String username, String password)throws Exception;
    void deleteUser() throws Exception;
    String[] selectUser() throws Exception;
}
