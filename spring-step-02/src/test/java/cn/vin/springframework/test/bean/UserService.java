package cn.vin.springframework.test.bean;

/**
 * 作者：DerekYRC https://github.com/DerekYRC/mini-spring
 */
public class UserService {

    private String name;

    public UserService(String name) {
        this.name = name;
    }

    public void queryUserInfo(){
        System.out.println("查询用户信息");
    }

}
