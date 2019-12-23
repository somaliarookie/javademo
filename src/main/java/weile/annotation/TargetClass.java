package weile.annotation;

/**
 * @Auth weile
 * @Time 2019/12/23 19:04
 * @Description TODO
 **/
public class TargetClass {



    @TestConfigAnnotation(age = 1,memo = "memo",name = "username")
    public  String getUserInfo() {
        return "user";
    }


}
