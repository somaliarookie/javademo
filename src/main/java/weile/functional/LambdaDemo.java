package weile.functional;

import org.omg.CORBA.ServiceInformationHolder;

/**
 * @Auth weile
 * @Time 2019-04-02 20:18
 * @Description lambda 实例
 **/
public class LambdaDemo {


    public static void main(String[] args) {

        //thread
        new Thread(() -> System.out.println("Hello world !")).start();

        //custom  interface

        MathInterface interface1=(x, y)->x+y ;

        System.out.println(interface1.add(1,2));


    }
}

interface MathInterface{
    public int add(int x,int y);
}

