package learn.lambda;

public class testLambda {
    // 静态内部类
    static class test2 implements Test {
        @Override
        public void run() {
            System.out.println("run2");
        }
    }

    public static void main(String[] args) {
        Test t = new TestImpl();
        t.run();
        Test t2 = new test2();
        t2.run();
        // 局部内部类
        class test3 implements Test {
            @Override
            public void run() {
                System.out.println("run3");
            }
        }
        Test t3 = new test3();
        t3.run();
        // 匿名内部类：借助接口或者父类
        Test t4 = new Test() {
            @Override
            public void run() {
                System.out.println("run4");
            }
        };
        t4.run();
        // lambda表达式
        Test t5 = () -> {
            System.out.println("run5");
        };
        t5.run();
        // 带参的lambda表达式
        Test01 t6 = (String name) -> {
            System.out.println(name);
        };
        t6.run("run6");
        Test01 t7 = (name) -> {
            System.out.println(name);
        };
        t7.run("run7");
        Test01 t8 = name -> {
            System.out.println(name);
        };
        t8.run("run8");
        Test01 t9 = name -> System.out.println(name);
        t9.run("run9");


    }
}

// 只有一个方法的接口叫做函数式接口
interface Test {
    void run();
}

/**
 * Test01
 */
interface Test01 {
    void run(String name);

}

// 外部类
class TestImpl implements Test {
    @Override
    public void run() {
        System.out.println("run1");
    }
}