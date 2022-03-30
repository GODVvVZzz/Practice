package annotation;

import java.lang.annotation.*;

/**
 * @author HP
 * @date 2022/3/29
 * 测试元注解
 */

public class Test01 {

    @MyAnnotation
    public void test(){

    }
}

//定义一个注解
//Target 表示我们的注解可以用在哪些地方
@Target(value = ElementType.METHOD) //只能在方法上使用

//Retention 表示我们的注解在什么地方还有效
//runtime>class>sources
@Retention(value = RetentionPolicy.RUNTIME)

//Documented 表示是否将我们的注解生成在Javadoc中
@Documented

//Inherited 表示子类可以继承父类的注解
@Inherited

@interface MyAnnotation{

}
