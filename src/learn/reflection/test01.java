package learn.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import entity.User;

public class test01 {
    @SuppressWarnings({ "rawtypes", "unchecked" })
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchFieldException {
        Class c1 = Class.forName("entity.User");
        Constructor constructor = c1.getConstructor(String.class, int.class, int.class);
        User u1 = (User) constructor.newInstance("张三", 20, 1001);
        System.out.println(u1);

        Method m1 = c1.getDeclaredMethod("setName", String.class);
        m1.invoke(u1, "李四");//通过invoke 函数激活m1构造方法来对u1这个对象内部字段进行赋值
        System.out.println(u1);


        Constructor constructor2 = c1.getConstructor();//通过constructor获取c1对象中的无参构造方法
        User u2 = (User) constructor2.newInstance();
        Field name = c1.getDeclaredField("name");
        name.setAccessible(true);
        name.set(u2, "wangwu");
        System.out.println(u2.getName());
    }
}

