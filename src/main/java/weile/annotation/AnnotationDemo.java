package weile.annotation;

import javax.sound.midi.Soundbank;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Optional;

/**
 * @Auth weile
 * @Time 2019/12/23 18:37
 * @Description 注解demo
 **/
public class AnnotationDemo {

    public static void main(String[] args) {


        //annotation use demo

        TargetClass targetClass = new TargetClass();

        Optional<Method> optionalMethod = Arrays.stream(targetClass.getClass().getMethods()).filter(m -> m.getName().equals("getUserInfo")).findFirst();

        optionalMethod.ifPresent(method -> {

            TestConfigAnnotation annotation = method.getAnnotation(TestConfigAnnotation.class);

            System.out.println(annotation.memo());
            System.out.println(annotation.name());
            System.out.println(annotation.age());


        });


    }

}
