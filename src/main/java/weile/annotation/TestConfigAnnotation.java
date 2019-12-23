package weile.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Auth weile
 * @Time 2019/12/23 19:02
 * @Description TODO
 **/

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface TestConfigAnnotation {

    public String name() default "name";
    public int age() default 0;
    public String memo() default "";
}
