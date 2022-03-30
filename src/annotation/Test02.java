package annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author HP
 * @date 2022/3/29
 * 注解在哪里使用？
 * 可以附加在package，class，method，field等上面，相当于给他们额外添加的辅助信息，
 * 我们可以通过反射机制编程实现对这些元数据的访问
 * 自定义注解
 */
public class Test02 {

    //注解可以显示赋值，如果没有默认值则必须给注解赋值
    @MyAnnotation2(name = "vvv")
    public void test(){

    }
}

/**
 * @author HP
 */
@Target({ElementType.TYPE,ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@interface MyAnnotation2{
    //注解的参数：参数类型+参数名();
    String name() default "";
    int age() default 0;
    int id() default -1; //如果默认值为-1，代表不存在

    String[] schools() default {"安徽财经大学","南京航空航天大学"};
}

