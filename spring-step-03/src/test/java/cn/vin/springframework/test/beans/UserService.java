package cn.vin.springframework.test.beans;

/**
 * 作者：DerekYRC https://github.com/DerekYRC/mini-spring
 */
public class UserService {

    private String name;

    @Override
    public String toString() {
        return "UserService{" +
                "name='" + name + '\'' +
                '}';
    }

    public UserService() {
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public UserService(String name) {
        this.name = name;
    }

    public void queryUserInfo(){
        System.out.println("查询用户信息");
    }

}
