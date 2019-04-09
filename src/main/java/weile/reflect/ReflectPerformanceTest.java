package weile.reflect;

import java.lang.reflect.Method;

/**
 * @Auth weile
 * @Time 2019-04-04 19:37
 * @Description 反射性能测试，测试证明反射的代码也会被JIT优化，调用次数累计到一定程度会放入JIT进行优化
 **/
public class ReflectPerformanceTest {


    long v;

    public void func0() {
        v++;
    }

    public void func1() {
        v--;
    }

    public void func2() {
        v++;
    }

    public void func3() {
        v--;
    }

    public void testInterface() {
        long t = System.nanoTime();
        Runnable[] rs = {
                this::func0,
                this::func1,
                this::func2,
                this::func3,
        };
        for (int i = 0; i < 1_0000_0000; i++)
            rs[i & 3].run(); // 关键调用
        t = (System.nanoTime() - t) / 1_000_000;
        System.out.format("testInterface: %d %dms\n", v, t);
    }

    public void testReflect() throws Exception {
        long t = System.nanoTime();
        Method[] ms = {
                ReflectPerformanceTest.class.getMethod("func0"),
                ReflectPerformanceTest.class.getMethod("func1"),
                ReflectPerformanceTest.class.getMethod("func2"),
                ReflectPerformanceTest.class.getMethod("func3"),
        };
        for (int i = 0; i < 1_0000_0000; i++)
            ms[i & 3].invoke(this); // 关键调用
        t = (System.nanoTime() - t) / 1_000_000;
        System.out.format("testReflect  : %d %dms\n", v, t);
    }

    public static void main(String[] args) throws Exception {

        for (int i = 0; i < 10; i++) {

            ReflectPerformanceTest b;
            b = new ReflectPerformanceTest(); // 预热部分
            b.testInterface();
            b = new ReflectPerformanceTest();
            b.testReflect();

            b = new ReflectPerformanceTest(); // 实测部分
            b.testInterface();
            b = new ReflectPerformanceTest();
            b.testReflect();
        }
    }
}
