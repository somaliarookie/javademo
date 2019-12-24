package weile.springfreamwork;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Auth weile
 * @Time 2019/12/24 20:27
 * @Description TODO
 **/
public class SpringIOCDemo {

    @Autowired
    People people;

    public static void main(String[] args) {



        testSpringIOCWithBean();





    }


    public static void  testSpringIOCWithBean() {

        //traditional

        People peopleTraditional = new People();

        System.out.println(peopleTraditional.name);


        //spring ioc


        AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext(BeansConfiguration.class);
        People bean = context.getBean(People.class);

        System.out.println(bean.getName());

    }


}

@Data
class People {


    String name;
    int age;


}


@Configuration
 class BeansConfiguration {

    @Bean
    public People initPeople() {

        People people = new People();
        people.setAge(11);
        people.setName("weile");
        return people;
    }
}


